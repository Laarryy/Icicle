package dev.laarryy.atropos.utils;

import dev.laarryy.atropos.exceptions.BotPermissionsException;
import dev.laarryy.atropos.exceptions.NullServerException;
import dev.laarryy.atropos.models.guilds.DiscordServer;
import dev.laarryy.atropos.models.guilds.permissions.ServerRolePermission;
import dev.laarryy.atropos.storage.DatabaseLoader;
import discord4j.common.util.Snowflake;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.User;
import discord4j.rest.util.Permission;
import discord4j.rest.util.PermissionSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class PermissionChecker {
    private final Logger logger = LogManager.getLogger(this);

    public Mono<Boolean> checkPermission(Guild guild, User user, String requestName) {
        Snowflake guildIdSnowflake = guild.getId();

        return Mono.from(user.asMember(guildIdSnowflake))
                .flatMap(member -> {
                    DatabaseLoader.openConnectionIfClosed();
                    dev.laarryy.atropos.models.guilds.permissions.Permission permission = dev.laarryy.atropos.models.guilds.permissions.Permission.findOrCreateIt("permission", requestName);
                    permission.save();
                    permission.refresh();
                    int permissionId = permission.getInteger("id");

                    logger.info("Permission check in progress - permission ID = " + permissionId);

                    return Mono.from(checkIsAdministrator(member)).flatMap(aBoolean -> {
                        if (aBoolean) {
                            return Mono.just(true);
                        }

                        int guildId = DiscordServer.findFirst("server_id = ?", guildIdSnowflake.asLong()).getInteger("id");

                        return Mono.from(
                                guild.getRoles()
                                .filter(role ->
                                        (ServerRolePermission.findFirst("server_id = ? and permission_id = ? and role_id_snowflake = ?", guildId, permissionId, role.getId().asLong()) != null)
                                                || (ServerRolePermission.findFirst("server_id = ? and permission_id = ? and role_id_snowflake = ?", guildId, 69, role.getId().asLong()) != null)
                                                || role.getPermissions().contains(Permission.ADMINISTRATOR))
                                .flatMap(role -> Mono.from(
                                                member.getRoles()
                                                        .mergeWith(guild.getEveryoneRole())
                                                        .any(memberRole -> memberRole.equals(role))
                                        )
                                        .flatMap(bool -> {
                                            return Mono.just(bool);
                                        }))
                                );
                    });
                });
    }

    public Mono<Boolean> checkIsAdministrator(Member member) {

        return member.getRoles()
                .map(Role::getPermissions)
                .mergeWith(member.getBasePermissions())
                .any(permissions -> permissions.contains(Permission.ADMINISTRATOR));
    }

    public Mono<Boolean> checkBotPermission(ChatInputInteractionEvent event) throws NullServerException, BotPermissionsException {

        return Mono.from(event.getInteraction().getGuild())
                .flatMap(guild -> {
                    if (guild == null) {
                        AuditLogger.addCommandToDB(event, false);
                        return Mono.error(new NullServerException("No Guild"));
                    }
                    return Mono.from(guild.getSelfMember()).flatMap(self -> Mono.from(self.getBasePermissions()).flatMap(basePerms -> {
                        if (basePerms.contains(Permission.ADMINISTRATOR)) {
                            return Mono.just(true);
                        }

                        PermissionSet requiredPermissions = PermissionSet.of(
                                Permission.VIEW_CHANNEL,
                                Permission.MANAGE_CHANNELS,
                                Permission.MANAGE_ROLES,
                                Permission.VIEW_AUDIT_LOG,
                                Permission.MANAGE_NICKNAMES,
                                //Permission.USE_PRIVATE_THREADS,
                                //Permission.USE_PUBLIC_THREADS,
                                Permission.KICK_MEMBERS,
                                Permission.BAN_MEMBERS,
                                Permission.SEND_MESSAGES,
                                Permission.USE_EXTERNAL_EMOJIS,
                                Permission.MANAGE_MESSAGES,
                                Permission.READ_MESSAGE_HISTORY,
                                Permission.MUTE_MEMBERS
                        );

                        return Mono.from(self.getBasePermissions()).flatMap(selfPermissions -> {
                            if (selfPermissions == null) {
                                AuditLogger.addCommandToDB(event, false);
                                return Mono.error(new BotPermissionsException("No Bot Permission"));
                            }
                            for (Permission permission : requiredPermissions) {
                                if (!selfPermissions.contains(permission)) {
                                    AuditLogger.addCommandToDB(event, false);
                                    return Mono.error(new BotPermissionsException("No Bot Permission"));
                                }
                            }
                            return Mono.just(true);
                        });
                    }));
                });
    }
}
