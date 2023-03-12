/*
 * This file is generated by jOOQ.
 */
package dev.laarryy.atropos.jooq.tables;


import dev.laarryy.atropos.jooq.Converters;
import dev.laarryy.atropos.jooq.Keys;
import dev.laarryy.atropos.jooq.tables.records.UsersRecord;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import discord4j.common.util.Snowflake;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Users extends TableImpl<UsersRecord> {

    private static final long serialVersionUID = 1L;

    public static final Users USERS = new Users();

    @Override
    @NonNull
    public Class<UsersRecord> getRecordType() {
        return UsersRecord.class;
    }

    public final TableField<UsersRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    public final TableField<UsersRecord, Snowflake> USER_ID_SNOWFLAKE = createField(DSL.name("user_id_snowflake"), SQLDataType.BIGINT.nullable(false).defaultValue(DSL.field("0", SQLDataType.BIGINT)).asConvertedDataType(Converters.SNOWFLAKE), this, "");

    public final TableField<UsersRecord, Instant> DATE = createField(DSL.name("date"), SQLDataType.BIGINT.nullable(false).defaultValue(DSL.field("0", SQLDataType.BIGINT)).asConvertedDataType(Converters.INSTANT), this, "");

    private Users(Name alias, Table<UsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Users(Name alias, Table<UsersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public Users(String alias) {
        this(DSL.name(alias), USERS);
    }

    public Users(Name alias) {
        this(alias, USERS);
    }

    public Users() {
        this(DSL.name("users"), null);
    }

    public <O extends Record> Users(Table<O> child, ForeignKey<O, UsersRecord> key) {
        super(child, key, USERS);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return null;
    }

    @Override
    @NonNull
    public Identity<UsersRecord, Integer> getIdentity() {
        return (Identity<UsersRecord, Integer>) super.getIdentity();
    }

    @Override
    @NonNull
    public UniqueKey<UsersRecord> getPrimaryKey() {
        return Keys.KEY_USERS_PRIMARY;
    }

    @Override
    @NonNull
    public List<UniqueKey<UsersRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_USERS_ID_UNIQUE, Keys.KEY_USERS_USER_ID_UNIQUE);
    }

    @Override
    @NonNull
    public Users as(String alias) {
        return new Users(DSL.name(alias), this);
    }

    @Override
    @NonNull
    public Users as(Name alias) {
        return new Users(alias, this);
    }

    @Override
    @NonNull
    public Users as(Table<?> alias) {
        return new Users(alias.getQualifiedName(), this);
    }

    @Override
    @NonNull
    public Users rename(String name) {
        return new Users(DSL.name(name), null);
    }

    @Override
    @NonNull
    public Users rename(Name name) {
        return new Users(name, null);
    }

    @Override
    @NonNull
    public Users rename(Table<?> name) {
        return new Users(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    @NonNull
    public Row3<Integer, Snowflake, Instant> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    public <U> SelectField<U> mapping(Function3<? super Integer, ? super Snowflake, ? super Instant, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Integer, ? super Snowflake, ? super Instant, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
