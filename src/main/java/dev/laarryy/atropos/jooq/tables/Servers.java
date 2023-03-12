/*
 * This file is generated by jOOQ.
 */
package dev.laarryy.atropos.jooq.tables;


import dev.laarryy.atropos.jooq.Converters;
import dev.laarryy.atropos.jooq.Keys;
import dev.laarryy.atropos.jooq.tables.records.ServersRecord;

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
public class Servers extends TableImpl<ServersRecord> {

    private static final long serialVersionUID = 1L;

    public static final Servers SERVERS = new Servers();

    @Override
    @NonNull
    public Class<ServersRecord> getRecordType() {
        return ServersRecord.class;
    }

    public final TableField<ServersRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    public final TableField<ServersRecord, Instant> DATE = createField(DSL.name("date"), SQLDataType.BIGINT.nullable(false).defaultValue(DSL.field("0", SQLDataType.BIGINT)).asConvertedDataType(Converters.INSTANT), this, "");

    public final TableField<ServersRecord, Snowflake> SERVER_ID = createField(DSL.name("server_id"), SQLDataType.BIGINT.nullable(false).asConvertedDataType(Converters.SNOWFLAKE), this, "");

    private Servers(Name alias, Table<ServersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Servers(Name alias, Table<ServersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public Servers(String alias) {
        this(DSL.name(alias), SERVERS);
    }

    public Servers(Name alias) {
        this(alias, SERVERS);
    }

    public Servers() {
        this(DSL.name("servers"), null);
    }

    public <O extends Record> Servers(Table<O> child, ForeignKey<O, ServersRecord> key) {
        super(child, key, SERVERS);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return null;
    }

    @Override
    @NonNull
    public Identity<ServersRecord, Integer> getIdentity() {
        return (Identity<ServersRecord, Integer>) super.getIdentity();
    }

    @Override
    @NonNull
    public UniqueKey<ServersRecord> getPrimaryKey() {
        return Keys.KEY_SERVERS_PRIMARY;
    }

    @Override
    @NonNull
    public List<UniqueKey<ServersRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_SERVERS_SERVERS_SERVER_ID_UINDEX);
    }

    @Override
    @NonNull
    public Servers as(String alias) {
        return new Servers(DSL.name(alias), this);
    }

    @Override
    @NonNull
    public Servers as(Name alias) {
        return new Servers(alias, this);
    }

    @Override
    @NonNull
    public Servers as(Table<?> alias) {
        return new Servers(alias.getQualifiedName(), this);
    }

    @Override
    @NonNull
    public Servers rename(String name) {
        return new Servers(DSL.name(name), null);
    }

    @Override
    @NonNull
    public Servers rename(Name name) {
        return new Servers(name, null);
    }

    @Override
    @NonNull
    public Servers rename(Table<?> name) {
        return new Servers(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    @NonNull
    public Row3<Integer, Instant, Snowflake> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    public <U> SelectField<U> mapping(Function3<? super Integer, ? super Instant, ? super Snowflake, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Integer, ? super Instant, ? super Snowflake, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
