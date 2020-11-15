import model.Artist;
import model.Datasource;
import model.OrderByType;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {


        try (Datasource datasource = new Datasource()) {
            datasource.openConn();

            List<Artist> artists = Optional.ofNullable(datasource.queryArtists(OrderByType.ASC))
                    .orElseThrow(NoArtistsException::new);

//            List<Artist> artists = datasource.queryArtists();
//            if (artists == null) {
//                System.out.println("No artists");
//                return;
//            }

            for (Artist artist : artists) {
                System.out.println(artist);
//                System.out.println();
            }

            if (!datasource.openConn()) {
                System.out.println("Can`t open datasource");
            }
        } catch (NoArtistsException e) {
            System.out.println("No artists");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
