package ru.lesson.hiber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializerSqliteDb {
    private final String DB_NAME = "pc_accessories";
    private final String TABLE_CPU = "cpu";
    private final String COLUMN_CPU_ID = "id";
    private final String COLUMN_CPU_PROVIDER = "provider";
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

    public String getCOLUMN_CPU_PROVIDER() {
        return COLUMN_CPU_PROVIDER;
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
