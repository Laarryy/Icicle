/*
 * This file is generated by jOOQ.
 */
package dev.laarryy.atropos.jooq.tables;


import dev.laarryy.atropos.jooq.Atropos;
import dev.laarryy.atropos.jooq.Keys;
import dev.laarryy.atropos.jooq.tables.records.ServerCommandUsesRecord;
import jooq.tables.Servers.ServersPath;
import jooq.tables.Users.UsersPath;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ServerCommandUses extends TableImpl<ServerCommandUsesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>atropos.server_command_uses</code>
     */
    public static final ServerCommandUses SERVER_COMMAND_USES = new ServerCommandUses();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ServerCommandUsesRecord> getRecordType() {
        return ServerCommandUsesRecord.class;
    }

    /**
     * The column <code>atropos.server_command_uses.id</code>.
     */
    public final TableField<ServerCommandUsesRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>atropos.server_command_uses.server_id</code>.
     */
    public final TableField<ServerCommandUsesRecord, Integer> SERVER_ID = createField(DSL.name("server_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>atropos.server_command_uses.command_user_id</code>.
     */
    public final TableField<ServerCommandUsesRecord, Integer> COMMAND_USER_ID = createField(DSL.name("command_user_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>atropos.server_command_uses.command_contents</code>.
     */
    public final TableField<ServerCommandUsesRecord, String> COMMAND_CONTENTS = createField(DSL.name("command_contents"), SQLDataType.VARCHAR(4000).nullable(false), this, "");

    /**
     * The column <code>atropos.server_command_uses.date</code>.
     */
    public final TableField<ServerCommandUsesRecord, Instant> DATE = createField(DSL.name("date"), SQLDataType.INSTANT.defaultValue(DSL.field(DSL.raw("NULL"), SQLDataType.INSTANT)), this, "");

    /**
     * The column <code>atropos.server_command_uses.success</code>.
     */
    public final TableField<ServerCommandUsesRecord, Boolean> SUCCESS = createField(DSL.name("success"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field(DSL.raw("1"), SQLDataType.BOOLEAN)), this, "");

    private ServerCommandUses(Name alias, Table<ServerCommandUsesRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private ServerCommandUses(Name alias, Table<ServerCommandUsesRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>atropos.server_command_uses</code> table
     * reference
     */
    public ServerCommandUses(String alias) {
        this(DSL.name(alias), SERVER_COMMAND_USES);
    }

    /**
     * Create an aliased <code>atropos.server_command_uses</code> table
     * reference
     */
    public ServerCommandUses(Name alias) {
        this(alias, SERVER_COMMAND_USES);
    }

    /**
     * Create a <code>atropos.server_command_uses</code> table reference
     */
    public ServerCommandUses() {
        this(DSL.name("server_command_uses"), null);
    }

    public <O extends Record> ServerCommandUses(Table<O> path, ForeignKey<O, ServerCommandUsesRecord> childPath, InverseForeignKey<O, ServerCommandUsesRecord> parentPath) {
        super(path, childPath, parentPath, SERVER_COMMAND_USES);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class ServerCommandUsesPath extends ServerCommandUses implements Path<ServerCommandUsesRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> ServerCommandUsesPath(Table<O> path, ForeignKey<O, ServerCommandUsesRecord> childPath, InverseForeignKey<O, ServerCommandUsesRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private ServerCommandUsesPath(Name alias, Table<ServerCommandUsesRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public ServerCommandUsesPath as(String alias) {
            return new ServerCommandUsesPath(DSL.name(alias), this);
        }

        @Override
        public ServerCommandUsesPath as(Name alias) {
            return new ServerCommandUsesPath(alias, this);
        }

        @Override
        public ServerCommandUsesPath as(Table<?> alias) {
            return new ServerCommandUsesPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Atropos.ATROPOS;
    }

    @Override
    public Identity<ServerCommandUsesRecord, Integer> getIdentity() {
        return (Identity<ServerCommandUsesRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<ServerCommandUsesRecord> getPrimaryKey() {
        return Keys.KEY_SERVER_COMMAND_USES_PRIMARY;
    }

    @Override
    public List<UniqueKey<ServerCommandUsesRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_SERVER_COMMAND_USES_SERVER_COMMAND_USES_ID_UINDEX);
    }

    @Override
    public List<ForeignKey<ServerCommandUsesRecord, ?>> getReferences() {
        return Arrays.asList(Keys.SERVER_COMMAND_USES_SERVERS_ID_FK, Keys.SERVER_COMMAND_USES_USERS_ID_FK);
    }

    private transient ServersPath _servers;

    /**
     * Get the implicit join path to the <code>atropos.servers</code> table.
     */
    public ServersPath servers() {
        if (_servers == null)
            _servers = new ServersPath(this, Keys.SERVER_COMMAND_USES_SERVERS_ID_FK, null);

        return _servers;
    }

    private transient UsersPath _users;

    /**
     * Get the implicit join path to the <code>atropos.users</code> table.
     */
    public UsersPath users() {
        if (_users == null)
            _users = new UsersPath(this, Keys.SERVER_COMMAND_USES_USERS_ID_FK, null);

        return _users;
    }

    @Override
    public ServerCommandUses as(String alias) {
        return new ServerCommandUses(DSL.name(alias), this);
    }

    @Override
    public ServerCommandUses as(Name alias) {
        return new ServerCommandUses(alias, this);
    }

    @Override
    public ServerCommandUses as(Table<?> alias) {
        return new ServerCommandUses(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public ServerCommandUses rename(String name) {
        return new ServerCommandUses(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ServerCommandUses rename(Name name) {
        return new ServerCommandUses(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public ServerCommandUses rename(Table<?> name) {
        return new ServerCommandUses(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerCommandUses where(Condition condition) {
        return new ServerCommandUses(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerCommandUses where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerCommandUses where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerCommandUses where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ServerCommandUses where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ServerCommandUses where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ServerCommandUses where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ServerCommandUses where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerCommandUses whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ServerCommandUses whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}