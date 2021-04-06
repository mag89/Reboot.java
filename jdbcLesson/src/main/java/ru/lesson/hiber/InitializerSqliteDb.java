package ru.lesson.hiber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializerSqliteDb {
    private final String DB_NAME = "pc_accessories";
    private final String TABLE_CPU = "cpu";
    private final String COLUMN_CPU_ID = "id";
    private final String COLUMN_CPU_PROVIDER_ID = "provider_id";
    private final String COLUMN_CPU_MODEL = "model";
    private final String COLUMN_CPU_CORE_QUANTITY = "coresQuantity";
    private final String COLUMN_CPU_CORE_FREQUENCY = "coreFrequency";
    private final String COLUMN_CPU_CORE_SOCKET = "socket";

    private final String TABLE_PROVIDER = "socket";
    private final String COLUMN_PROVIDER_ID = "id";
    private final String COLUMN_PROVIDER_NAME = "name";

    private final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;
    private final String drop_table = "DROP TABLE IF EXISTS ";


    public InitializerSqliteDb() {
    }

    public void initializeDb() {
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
            Statement statement = conn.createStatement();
            statement.execute(drop_table + TABLE_CPU);
            statement.execute(drop_table + TABLE_PROVIDER);

            statement.execute("PRAGMA foreign_keys=on");
//            statement.execute("CREATE TABLE IF NOT EXIST " + TABLE_CPU + "(" +
//                    COLUMN_CPU_ID + " INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, " +
//                    COLUMN_CPU_PROVIDER + " INTEGER, " +
//                    COLUMN_CPU_MODEL + " TEXT, " +
//                    COLUMN_CPU_CORE_QUANTITY + " INTEGER, " +
//                    COLUMN_CPU_CORE_FREQUENCY + " INTEGER, " +
//                    COLUMN_CPU_CORE_SOCKET + " TEXT" +
//                    ")");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_PROVIDER + "(" +
                    COLUMN_PROVIDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , " +
                    COLUMN_PROVIDER_NAME + " TEXT" +
                    ")"
            );

            statement.execute(String.format("CREATE TABLE IF NOT EXISTS %s" +
                            "(%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                            "%s INTEGER, %s TEXT, %s INTEGER, %s INTEGER, %s TEXT, " +
                            "FOREIGN KEY (%s) REFERENCES %s(%s))", // you must enable sqlite> PRAGMA foreign_keys = ON;
                    TABLE_CPU,
                    COLUMN_CPU_ID,
                    COLUMN_CPU_PROVIDER_ID,
                    COLUMN_CPU_MODEL,
                    COLUMN_CPU_CORE_QUANTITY,
                    COLUMN_CPU_CORE_FREQUENCY,
                    COLUMN_CPU_CORE_SOCKET,
                    COLUMN_CPU_PROVIDER_ID,
                    TABLE_PROVIDER,
                    COLUMN_PROVIDER_ID));

//            statement.execute(String.format("CREATE TABLE IF NOT EXIST %s" +
//                            "(%s FOREIGN KEY ("+ TABLE_CPU +") REFERENCES "+ Col+"(id) NOT NULL AUTOINCREMENT, " +
//                            "%s TEXT)",
//                    COLUMN_PROVIDER_ID,
//                    COLUMN_PROVIDER_NAME));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getDB_NAME() {
        return DB_NAME;
    }

    public String getTABLE_CPU() {
        return TABLE_CPU;
    }

    public String getCOLUMN_CPU_ID() {
        return COLUMN_CPU_ID;
    }

    public String getCOLUMN_CPU_PROVIDER_ID() {
        return COLUMN_CPU_PROVIDER_ID;
    }

    public String getCOLUMN_CPU_MODEL() {
        return COLUMN_CPU_MODEL;
    }

    public String getCOLUMN_CPU_CORE_QUANTITY() {
        return COLUMN_CPU_CORE_QUANTITY;
    }

    public String getCOLUMN_CPU_CORE_FREQUENCY() {
        return COLUMN_CPU_CORE_FREQUENCY;
    }

    public String getCOLUMN_CPU_CORE_SOCKET() {
        return COLUMN_CPU_CORE_SOCKET;
    }

    public String getTABLE_PROVIDER() {
        return TABLE_PROVIDER;
    }

    public String getCOLUMN_PROVIDER_ID() {
        return COLUMN_PROVIDER_ID;
    }

    public String getCOLUMN_PROVIDER_NAME() {
        return COLUMN_PROVIDER_NAME;
    }
}
