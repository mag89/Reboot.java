import model.Datasource;

public class Main {
    public static void main(String[] args) {


        try (Datasource datasource = new Datasource()) {
            if (!datasource.openConn()) {
                System.out.println("Can`t open datasource");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     }

}
