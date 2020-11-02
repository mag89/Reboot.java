import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
             Statement statement = conn.createStatement()
        ) {
//            conn.setAutoCommit(false);
            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
                    "(name TEXT, phone INTEGER, email TEXT)");

            statement.execute("DELETE FROM contacts WHERE name='artur'");

            statement.execute("INSERT INTO contacts (name, phone, email) " +
                    "VALUES ('artur', 9191041052, 'tyr-89@mail.ru')");

            statement.execute("UPDATE contacts SET email='superEmail.com' WHERE name='artur'");

        } catch (SQLException e) {
            System.out.println("something went wrong with DB connection: " + e.getMessage());
        }
    }
}
