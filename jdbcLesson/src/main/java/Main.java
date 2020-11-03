import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
             Statement statement = conn.createStatement()
        ) {
//            conn.setAutoCommit(false); // отключаем авокомит по умолчанию
//
//            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
//                    "(name TEXT, phone INTEGER, email TEXT)");
//
//            statement.execute("DELETE FROM contacts");
//
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    "VALUES ('artur', 9191041052, 'tyr-89@mail.ru')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    "VALUES ('Julia', 9153333405, 'julkaTsap@yandex.ru')");
//
//            statement.execute("UPDATE contacts SET email='superArturEmail.com' " +
//                                 "WHERE name='artur'");
//
//            conn.commit();

            statement.execute("select * from contacts");
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                System.out.printf("%s %s %s", result.getString("name"), result.getInt("phone"),
                        result.getString("email"));
                System.out.println();
            }
            result.close(); // resultSet это ресурс, после использования нужно закрыть

        } catch (SQLException e) {
            System.out.println("something went wrong with DB connection: " + e.getMessage());
        }
    }
}
