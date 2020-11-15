import model.Artist;
import model.Datasource;
import model.OrderByType;
import model.exceptions.NoAlbumsForArtistException;
import model.exceptions.NoArtistsException;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {


        try (Datasource datasource = new Datasource()) {
            datasource.openConn();

            List<Artist> artists = Optional.ofNullable(datasource.queryArtists(OrderByType.ASC))
                    .orElseThrow(NoArtistsException::new);

            for (Artist artist : artists) {
                System.out.println(artist);
            }

            List<String> albumsForArtists = Optional.ofNullable(datasource
                    .queryAlbumsForArtist("Pink Floyd", OrderByType.ASC))
                    .orElseThrow(NoAlbumsForArtistException::new);

            System.out.println(albumsForArtists);

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
