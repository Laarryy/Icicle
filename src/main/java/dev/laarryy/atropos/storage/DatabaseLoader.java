package dev.laarryy.atropos.storage;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dev.laarryy.atropos.config.ConfigManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javalite.activejdbc.Base;

public class DatabaseLoader {

    private static final Logger logger = LogManager.getLogger(DatabaseLoader.class);

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
            config.setJdbcUrl(ConfigManager.getAddress());
            config.setUsername(ConfigManager.getUsername());
            config.setPassword(ConfigManager.getPassword());
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            config.addDataSourceProperty("autoReconnect", true);
            ds = new HikariDataSource(config);
    }

    public static void openConnection() {
        Base.open(ds);
    }

    public static void openConnectionIfClosed() {
        if (!Base.hasConnection()) {
            openConnection();
        }
    }

    public static void closeConnectionIfOpen() {
        if (Base.hasConnection()) {
            Base.close();
        }
    }
}
