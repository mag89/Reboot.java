import java.sql.*;

public class Main {
    public static final String DB_NAME = "test.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement()
        ) {
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    " (" +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_PHONE + " INTEGER, " +
                    COLUMN_EMAIL + " TEXT" +
                    ")");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" +
                    COLUMN_NAME + ", " +
                    COLUMN_PHONE + ", " +
                    COLUMN_EMAIL +
                    ") " +
                    "VALUES ('Artur', 9191044681052, 'tyr-84249@mail.ru')");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" +
                    COLUMN_NAME + ", " +
                    COLUMN_PHONE + ", " +
                    COLUMN_EMAIL +
                    ") " +
                    "VALUES ('Julia', 9153333405, 'julkaTsap@yandex.ru')");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" +
                    COLUMN_NAME + ", " +
                    COLUMN_PHONE + ", " +
                    COLUMN_EMAIL +
                    ") " +
                    "VALUES ('del', 6546864354387, 'qwerty@yandex.ru')");

            statement.execute("UPDATE " + TABLE_CONTACTS +
                    " SET " +
                    COLUMN_EMAIL + "='Artur@email.com' WHERE " +
                    COLUMN_NAME + "='Artur'");

//            statement.execute("delete from " +
//                    "contacts " +
//                    "where " +
//                    "name='del'");

            statement.execute("DELETE FROM " +
                    TABLE_CONTACTS +
                    " WHERE " +
                    COLUMN_EMAIL + " like 'qwerty%'");

            ResultSet results = statement.executeQuery("select * from " + TABLE_CONTACTS);

            while (results.next()) {
                System.out.printf("%s %s %s",
                        results.getString(COLUMN_NAME),
                        results.getInt(COLUMN_PHONE),
                        results.getString(COLUMN_EMAIL));
                System.out.println();
            }
            results.close(); // resultSet это ресурс, после использования нужно закрыть

        } catch (SQLException e) {
            System.out.println("something went wrong with DB connection: " + e.getMessage());
        }
    }
}
