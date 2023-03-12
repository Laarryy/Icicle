/*
 * This file is generated by jOOQ.
 */
package dev.laarryy.atropos.jooq;


import dev.laarryy.atropos.jooq.tables.Permissions;
import dev.laarryy.atropos.jooq.tables.Punishments;
import dev.laarryy.atropos.jooq.tables.ServerBlacklist;
import dev.laarryy.atropos.jooq.tables.ServerCommandUses;
import dev.laarryy.atropos.jooq.tables.ServerMessages;
import dev.laarryy.atropos.jooq.tables.ServerProperties;
import dev.laarryy.atropos.jooq.tables.ServerRolePermissions;
import dev.laarryy.atropos.jooq.tables.ServerUser;
import dev.laarryy.atropos.jooq.tables.Servers;
import dev.laarryy.atropos.jooq.tables.Users;
import dev.laarryy.atropos.jooq.tables.records.PermissionsRecord;
import dev.laarryy.atropos.jooq.tables.records.PunishmentsRecord;
import dev.laarryy.atropos.jooq.tables.records.ServerBlacklistRecord;
import dev.laarryy.atropos.jooq.tables.records.ServerCommandUsesRecord;
import dev.laarryy.atropos.jooq.tables.records.ServerMessagesRecord;
import dev.laarryy.atropos.jooq.tables.records.ServerPropertiesRecord;
import dev.laarryy.atropos.jooq.tables.records.ServerRolePermissionsRecord;
import dev.laarryy.atropos.jooq.tables.records.ServerUserRecord;
import dev.laarryy.atropos.jooq.tables.records.ServersRecord;
import dev.laarryy.atropos.jooq.tables.records.UsersRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<PermissionsRecord> KEY_PERMISSIONS_PERMISSION = Internal.createUniqueKey(Permissions.PERMISSIONS, DSL.name("KEY_permissions_permission"), new TableField[] { Permissions.PERMISSIONS.PERMISSION }, true);
    public static final UniqueKey<PermissionsRecord> KEY_PERMISSIONS_PRIMARY = Internal.createUniqueKey(Permissions.PERMISSIONS, DSL.name("KEY_permissions_PRIMARY"), new TableField[] { Permissions.PERMISSIONS.ID }, true);
    public static final UniqueKey<PunishmentsRecord> KEY_PUNISHMENTS_ID = Internal.createUniqueKey(Punishments.PUNISHMENTS, DSL.name("KEY_punishments_id"), new TableField[] { Punishments.PUNISHMENTS.ID }, true);
    public static final UniqueKey<PunishmentsRecord> KEY_PUNISHMENTS_PRIMARY = Internal.createUniqueKey(Punishments.PUNISHMENTS, DSL.name("KEY_punishments_PRIMARY"), new TableField[] { Punishments.PUNISHMENTS.ID }, true);
    public static final UniqueKey<ServerBlacklistRecord> KEY_SERVER_BLACKLIST_PRIMARY = Internal.createUniqueKey(ServerBlacklist.SERVER_BLACKLIST, DSL.name("KEY_server_blacklist_PRIMARY"), new TableField[] { ServerBlacklist.SERVER_BLACKLIST.ID }, true);
    public static final UniqueKey<ServerCommandUsesRecord> KEY_SERVER_COMMAND_USES_PRIMARY = Internal.createUniqueKey(ServerCommandUses.SERVER_COMMAND_USES, DSL.name("KEY_server_command_uses_PRIMARY"), new TableField[] { ServerCommandUses.SERVER_COMMAND_USES.ID }, true);
    public static final UniqueKey<ServerCommandUsesRecord> KEY_SERVER_COMMAND_USES_SERVER_COMMAND_USES_ID_UINDEX = Internal.createUniqueKey(ServerCommandUses.SERVER_COMMAND_USES, DSL.name("KEY_server_command_uses_server_command_uses_id_uindex"), new TableField[] { ServerCommandUses.SERVER_COMMAND_USES.ID }, true);
    public static final UniqueKey<ServerMessagesRecord> KEY_SERVER_MESSAGES_PRIMARY = Internal.createUniqueKey(ServerMessages.SERVER_MESSAGES, DSL.name("KEY_server_messages_PRIMARY"), new TableField[] { ServerMessages.SERVER_MESSAGES.ID }, true);
    public static final UniqueKey<ServerMessagesRecord> KEY_SERVER_MESSAGES_SERVER_MESSAGES_ID_UINDEX = Internal.createUniqueKey(ServerMessages.SERVER_MESSAGES, DSL.name("KEY_server_messages_server_messages_id_uindex"), new TableField[] { ServerMessages.SERVER_MESSAGES.ID }, true);
    public static final UniqueKey<ServerPropertiesRecord> KEY_SERVER_PROPERTIES_ID = Internal.createUniqueKey(ServerProperties.SERVER_PROPERTIES, DSL.name("KEY_server_properties_id"), new TableField[] { ServerProperties.SERVER_PROPERTIES.ID }, true);
    public static final UniqueKey<ServerPropertiesRecord> KEY_SERVER_PROPERTIES_PRIMARY = Internal.createUniqueKey(ServerProperties.SERVER_PROPERTIES, DSL.name("KEY_server_properties_PRIMARY"), new TableField[] { ServerProperties.SERVER_PROPERTIES.ID }, true);
    public static final UniqueKey<ServerRolePermissionsRecord> KEY_SERVER_ROLE_PERMISSIONS_PRIMARY = Internal.createUniqueKey(ServerRolePermissions.SERVER_ROLE_PERMISSIONS, DSL.name("KEY_server_role_permissions_PRIMARY"), new TableField[] { ServerRolePermissions.SERVER_ROLE_PERMISSIONS.ID }, true);
    public static final UniqueKey<ServerUserRecord> KEY_SERVER_USER_ID = Internal.createUniqueKey(ServerUser.SERVER_USER, DSL.name("KEY_server_user_id"), new TableField[] { ServerUser.SERVER_USER.ID }, true);
    public static final UniqueKey<ServerUserRecord> KEY_SERVER_USER_PRIMARY = Internal.createUniqueKey(ServerUser.SERVER_USER, DSL.name("KEY_server_user_PRIMARY"), new TableField[] { ServerUser.SERVER_USER.ID }, true);
    public static final UniqueKey<ServersRecord> KEY_SERVERS_PRIMARY = Internal.createUniqueKey(Servers.SERVERS, DSL.name("KEY_servers_PRIMARY"), new TableField[] { Servers.SERVERS.ID }, true);
    public static final UniqueKey<ServersRecord> KEY_SERVERS_SERVERS_SERVER_ID_UINDEX = Internal.createUniqueKey(Servers.SERVERS, DSL.name("KEY_servers_servers_server_id_uindex"), new TableField[] { Servers.SERVERS.SERVER_ID }, true);
    public static final UniqueKey<UsersRecord> KEY_USERS_ID_UNIQUE = Internal.createUniqueKey(Users.USERS, DSL.name("KEY_users_id_UNIQUE"), new TableField[] { Users.USERS.ID }, true);
    public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = Internal.createUniqueKey(Users.USERS, DSL.name("KEY_users_PRIMARY"), new TableField[] { Users.USERS.ID }, true);
    public static final UniqueKey<UsersRecord> KEY_USERS_USER_ID_UNIQUE = Internal.createUniqueKey(Users.USERS, DSL.name("KEY_users_user_id_UNIQUE"), new TableField[] { Users.USERS.USER_ID_SNOWFLAKE }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<PunishmentsRecord, UsersRecord> PUNISHMENTS_IBFK_1 = Internal.createForeignKey(Punishments.PUNISHMENTS, DSL.name("punishments_ibfk_1"), new TableField[] { Punishments.PUNISHMENTS.USER_ID_PUNISHED }, Keys.KEY_USERS_PRIMARY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<PunishmentsRecord, ServersRecord> PUNISHMENTS_IBFK_2 = Internal.createForeignKey(Punishments.PUNISHMENTS, DSL.name("punishments_ibfk_2"), new TableField[] { Punishments.PUNISHMENTS.SERVER_ID }, Keys.KEY_SERVERS_PRIMARY, new TableField[] { Servers.SERVERS.ID }, true);
    public static final ForeignKey<PunishmentsRecord, UsersRecord> PUNISHMENTS_USERS_ID_FK = Internal.createForeignKey(Punishments.PUNISHMENTS, DSL.name("punishments_users_id_fk"), new TableField[] { Punishments.PUNISHMENTS.USER_ID_PUNISHER }, Keys.KEY_USERS_PRIMARY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ServerBlacklistRecord, ServersRecord> SERVER_BLACKLIST_IBFK_1 = Internal.createForeignKey(ServerBlacklist.SERVER_BLACKLIST, DSL.name("server_blacklist_ibfk_1"), new TableField[] { ServerBlacklist.SERVER_BLACKLIST.SERVER_ID }, Keys.KEY_SERVERS_PRIMARY, new TableField[] { Servers.SERVERS.ID }, true);
    public static final ForeignKey<ServerCommandUsesRecord, ServersRecord> SERVER_COMMAND_USES_SERVERS_ID_FK = Internal.createForeignKey(ServerCommandUses.SERVER_COMMAND_USES, DSL.name("server_command_uses_servers_id_fk"), new TableField[] { ServerCommandUses.SERVER_COMMAND_USES.SERVER_ID }, Keys.KEY_SERVERS_PRIMARY, new TableField[] { Servers.SERVERS.ID }, true);
    public static final ForeignKey<ServerCommandUsesRecord, UsersRecord> SERVER_COMMAND_USES_USERS_ID_FK = Internal.createForeignKey(ServerCommandUses.SERVER_COMMAND_USES, DSL.name("server_command_uses_users_id_fk"), new TableField[] { ServerCommandUses.SERVER_COMMAND_USES.COMMAND_USER_ID }, Keys.KEY_USERS_PRIMARY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ServerMessagesRecord, ServersRecord> SERVER_MESSAGES_SERVERS_ID_FK = Internal.createForeignKey(ServerMessages.SERVER_MESSAGES, DSL.name("server_messages_servers_id_fk"), new TableField[] { ServerMessages.SERVER_MESSAGES.SERVER_ID }, Keys.KEY_SERVERS_PRIMARY, new TableField[] { Servers.SERVERS.ID }, true);
    public static final ForeignKey<ServerMessagesRecord, UsersRecord> SERVER_MESSAGES_USERS_ID_FK = Internal.createForeignKey(ServerMessages.SERVER_MESSAGES, DSL.name("server_messages_users_id_fk"), new TableField[] { ServerMessages.SERVER_MESSAGES.USER_ID }, Keys.KEY_USERS_PRIMARY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ServerPropertiesRecord, ServersRecord> SERVER_PROPERTIES_SERVERS_ID_FK = Internal.createForeignKey(ServerProperties.SERVER_PROPERTIES, DSL.name("server_properties_servers_id_fk"), new TableField[] { ServerProperties.SERVER_PROPERTIES.SERVER_ID }, Keys.KEY_SERVERS_PRIMARY, new TableField[] { Servers.SERVERS.ID }, true);
    public static final ForeignKey<ServerRolePermissionsRecord, ServersRecord> SERVER_ROLE_PERMISSIONS_IBFK_1 = Internal.createForeignKey(ServerRolePermissions.SERVER_ROLE_PERMISSIONS, DSL.name("server_role_permissions_ibfk_1"), new TableField[] { ServerRolePermissions.SERVER_ROLE_PERMISSIONS.SERVER_ID }, Keys.KEY_SERVERS_PRIMARY, new TableField[] { Servers.SERVERS.ID }, true);
    public static final ForeignKey<ServerRolePermissionsRecord, PermissionsRecord> SERVER_ROLE_PERMISSIONS_IBFK_2 = Internal.createForeignKey(ServerRolePermissions.SERVER_ROLE_PERMISSIONS, DSL.name("server_role_permissions_ibfk_2"), new TableField[] { ServerRolePermissions.SERVER_ROLE_PERMISSIONS.PERMISSION_ID }, Keys.KEY_PERMISSIONS_PRIMARY, new TableField[] { Permissions.PERMISSIONS.ID }, true);
    public static final ForeignKey<ServerUserRecord, UsersRecord> SERVER_USER_IBFK_1 = Internal.createForeignKey(ServerUser.SERVER_USER, DSL.name("server_user_ibfk_1"), new TableField[] { ServerUser.SERVER_USER.USER_ID }, Keys.KEY_USERS_PRIMARY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ServerUserRecord, ServersRecord> SERVER_USER_IBFK_2 = Internal.createForeignKey(ServerUser.SERVER_USER, DSL.name("server_user_ibfk_2"), new TableField[] { ServerUser.SERVER_USER.SERVER_ID }, Keys.KEY_SERVERS_PRIMARY, new TableField[] { Servers.SERVERS.ID }, true);
}
