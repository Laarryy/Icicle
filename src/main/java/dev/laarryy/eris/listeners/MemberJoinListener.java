package dev.laarryy.eris.listeners;

import com.github.benmanes.caffeine.cache.LoadingCache;
import dev.laarryy.eris.commands.punishments.PunishmentManager;
import dev.laarryy.eris.managers.PropertiesCacheManager;
import dev.laarryy.eris.managers.PunishmentManagerManager;
import dev.laarryy.eris.models.guilds.DiscordServer;
import dev.laarryy.eris.models.guilds.DiscordServerProperties;
import dev.laarryy.eris.models.users.DiscordUser;
import dev.laarryy.eris.models.users.Punishment;
import dev.laarryy.eris.storage.DatabaseLoader;
import dev.laarryy.eris.utils.AddServerToDB;
import discord4j.core.event.domain.guild.MemberJoinEvent;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.channel.PrivateChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;

public class MemberJoinListener {
    LoadingCache<Long, DiscordServerProperties> cache = PropertiesCacheManager.getManager().getPropertiesCache();
    private final Logger logger = LogManager.getLogger(this);
    private final AddServerToDB addServerToDB = new AddServerToDB();
    private final PunishmentManager punishmentManager = PunishmentManagerManager.getManager().getPunishmentManager();


    @EventListener
    public Mono<Void> on(MemberJoinEvent event) {
        if (event.getGuild().block() == null) {
            return Mono.empty();
        }
        Guild guild = event.getGuild().block();

        DiscordServerProperties discordServerProperties = cache.get(guild.getId().asLong());

        if (discordServerProperties.getStopJoins()) {
            Member member = event.getMember();
            try {
                PrivateChannel privateChannel = member.getPrivateChannel().block();
                privateChannel.createMessage("You have been kicked from " + guild.getName() + " at this time, as a part of anti-raid measures. If you aren't a spam-bot, please try again later!").block();
            } catch (Exception ignored) {
            }

            punishmentManager.discordKickUser(guild, member.getId().asLong(), "Automatically kicked as part of anti-raid measures");
            return Mono.empty();
        }

        addServerToDB.addUserToDatabase(event.getMember(), event.getGuild().block());

        // Apply evaded mutes

        DatabaseLoader.openConnectionIfClosed();
        DiscordUser user = DiscordUser.findFirst("user_id_snowflake = ?", event.getMember().getId().asLong());
        DiscordServer discordServer = DiscordServer.findFirst("server_id = ?", guild.getId().asLong());

        if (user != null) {
            Punishment activePunishment = Punishment.findFirst("user_id_punished = ? and end_date_passed = ? and server_id = ?",
                    user.getUserId(), false, discordServer.getServerId());
            if (activePunishment != null && activePunishment.getPunishmentType().equals("mute")) {
                punishmentManager.discordMuteUser(event.getGuild().block(), event.getMember().getId().asLong());
            }
        }

        DatabaseLoader.closeConnectionIfOpen();

        return Mono.empty();
    }
}
