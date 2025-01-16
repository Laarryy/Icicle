/*
 * This file is generated by jOOQ.
 */
package dev.laarryy.atropos.jooq.tables;


import dev.laarryy.atropos.jooq.Atropos;
import dev.laarryy.atropos.jooq.Indexes;
import dev.laarryy.atropos.jooq.Keys;
import dev.laarryy.atropos.jooq.tables.Permissions.PermissionsPath;
import dev.laarryy.atropos.jooq.tables.Servers.ServersPath;
import dev.laarryy.atropos.jooq.tables.records.ServerRolePermissionsRecord;
import dev.laarryy.atropos.utils.converters.LongToSnowflakeConverter;
import discord4j.common.util.Snowflake;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ServerRolePermissions extends TableImpl<ServerRolePermissionsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>atropos.server_role_permissions</code>
     */
    public static final ServerRolePermissions SERVER_ROLE_PERMISSIONS = new ServerRolePermissions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ServerRolePermissionsRecord> getRecordType() {
        return ServerRolePermissionsRecord.class;
    }

    /**
     * The column <code>atropos.server_role_permissions.id</code>.
     */
    public final TableField<ServerRolePermissionsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>atropos.server_role_permissions.server_id</code>.
     */
    public final TableField<ServerRolePermissionsRecord, Integer> SERVER_ID = createField(DSL.name("server_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>atropos.server_role_permissions.permission_id</code>.
     */
    public final TableField<ServerRolePermissionsRecord, Integer> PERMISSION_ID = createField(DSL.name("permission_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column
     * <code>atropos.server_role_permissions.role_id_snowflake</code>.
     */
    public final TableField<ServerRolePermissionsRecord, Snowflake> ROLE_ID_SNOWFLAKE = createField(DSL.name("role_id_snowflake"), SQLDataType.BIGINT.nullable(false).defaultValue(DSL.field(DSL.raw("0"), SQLDataType.BIGINT)), this, "", new LongToSnowflakeConverter());

    private ServerRolePermissions(Name alias, Table<ServerRolePermissionsRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private ServerRolePermissions(Name alias, Table<ServerRolePermissionsRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>atropos.server_role_permissions</code> table
     * reference
     */
    public ServerRolePermissions(String alias) {
        this(DSL.name(alias), SERVER_ROLE_PERMISSIONS);
    }

    /**
     * Create an aliased <code>atropos.server_role_permissions</code> table
     * reference
     */
    public ServerRolePermissions(Name alias) {
        this(alias, SERVER_ROLE_PERMISSIONS);
    }

    /**
     * Create a <code>atropos.server_role_permissions</code> table reference
     */
    public ServerRolePermissions() {
        this(DSL.name("server_role_permissions"), null);
    }

    public <O extends Record> ServerRolePermissions(Table<O> path, ForeignKey<O, ServerRolePermissionsRecord> childPath, InverseForeignKey<O, ServerRolePermissionsRecord> parentPath) {
        super(path, childPath, parentPath, SERVER_ROLE_PERMISSIONS);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class ServerRolePermissionsPath extends ServerRolePermissions implements Path<ServerRolePermissionsRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> ServerRolePermissionsPath(Table<O> path, ForeignKey<O, ServerRolePermissionsRecord> childPath, InverseForeignKey<O, ServerRolePermissionsRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private ServerRolePermissionsPath(Name alias, Table<ServerRolePermissionsRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public ServerRolePermissionsPath as(String alias) {
            return new ServerRolePermissionsPath(DSL.name(alias), this);
        }

        @Override
        public ServerRolePermissionsPath as(Name alias) {
            return new ServerRolePermissionsPath(alias, this);
        }

        @Override
        public ServerRolePermissionsPath as(Table<?> alias) {
            return new ServerRolePermissionsPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Atropos.ATROPOS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.SERVER_ROLE_PERMISSIONS_PERMISSION_ID, Indexes.SERVER_ROLE_PERMISSIONS_SERVER_ID);
    }

    @Override
    public Identity<ServerRolePermissionsRecord, Integer> getIdentity() {
        return (Identity<ServerRolePermissionsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<ServerRolePermissionsRecord> getPrimaryKey() {
        return Keys.KEY_SERVER_ROLE_PERMISSIONS_PRIMARY;
    }

    @Override
    public List<ForeignKey<ServerRolePermissionsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.SERVER_ROLE_PERMISSIONS_IBFK_1, Keys.SERVER_ROLE_PERMISSIONS_IBFK_2);
    }

    private transient ServersPath _servers;

    /**
     * Get the implicit join path to the <code>atropos.servers</code> table.
     */
    public ServersPath servers() {
        if (_servers == null)
            _servers = new ServersPath(this, Keys.SERVER_ROLE_PERMISSIONS_IBFK_1, null);

        return _servers;
    }

    private transient PermissionsPath _permissions;

    /**
     * Get the implicit join path to the <code>atropos.permissions</code> table.
     */
    public PermissionsPath permissions() {
        if (_permissions == null)
            _permissions = new PermissionsPath(this, Keys.SERVER_ROLE_PERMISSIONS_IBFK_2, null);

        return _permissions;
    }

    @Override
    public ServerRolePermissions as(String alias) {
        return new ServerRolePermissions(DSL.name(alias), this);
    }

    @Override
    public ServerRolePermissions as(Name alias) {
        return new ServerRolePermissions(alias, this);
    }

    @Override
    public ServerRolePermissions as(Table<?> alias) {
        return new ServerRolePermissions(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public ServerRolePermissions rename(String name) {
        return new ServerRolePermissions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ServerRolePermissions rename(Name name) {
        return new ServerRolePermissions(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public ServerRolePermissions rename(Table<?> name) {
        return new ServerRolePermissions(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerRolePermissions where(Condition condition) {
        return new ServerRolePermissions(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerRolePermissions where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerRolePermissions where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerRolePermissions where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ServerRolePermissions where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ServerRolePermissions where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ServerRolePermissions where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ServerRolePermissions where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerRolePermissions whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerRolePermissions whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
