package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource implements AutoCloseable {
    private static final String DB_NAME = "music.db";
    private static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    private static final String TABLE_ALBUMS = "albums";
    private static final String COLUMN_ALBUM_ID = "_id";
    private static final String COLUMN_ALBUM_NAME = "name";
    private static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    private static final String TABLE_ARTISTS = "artists";
    private static final String COLUMN_ARTIST_ID = "_id";
    private static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTISTS_ID = 1;
    public static final int INDEX_ARTISTS_NAME = 2;

    private static final String TABLE_SINGS = "songs";
    public static final String COLUMN_ID = "_id";
    private static final String COLUMN_SONG_TRACK = "track";
    private static final String COLUMN_SONG_TITLE = "title";
    private static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 3;

    private Connection conn;

    public boolean openConn() {
        try {
            this.conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void close() {
        try {
            if (!this.conn.isClosed()) {
                this.conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Artist> queryArtists(OrderByType order) {
        List<Artist> artists = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(generatePlainSelectQuery(TABLE_ARTISTS, COLUMN_ARTIST_NAME,
                     order))) {

            while (result.next()) {
                Artist artist = new Artist(result.getInt(INDEX_ARTISTS_ID), result.getString(INDEX_ARTISTS_NAME));
                artists.add(artist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artists;
    }

//select albums.name from albums join artists on albums.artist=artists._id where albums.name='Carole King' ORDER BY albums.name COLLATE NOCASE ASC
    public List<String> queryAlbumsForArtist(String artistName, OrderByType order) {
        List<String> albumsForArtist = new ArrayList<>();

        StringBuilder joinString = new StringBuilder("select ");
        joinString.append(TABLE_ALBUMS);
        joinString.append(".");
        joinString.append(COLUMN_ALBUM_NAME);
        joinString.append(" from ");
        joinString.append(TABLE_ALBUMS);
        joinString.append(" join ");
        joinString.append(TABLE_ARTISTS);
        joinString.append(" on ");
        joinString.append(TABLE_ALBUMS);
        joinString.append(".");
        joinString.append(COLUMN_ALBUM_ARTIST);
        joinString.append("=");
        joinString.append(TABLE_ARTISTS);
        joinString.append(".");
        joinString.append(COLUMN_ARTIST_ID);
        joinString.append(" where ");
        joinString.append(TABLE_ARTISTS);
        joinString.append(".");
        joinString.append(COLUMN_ARTIST_NAME);
        joinString.append("=");
        joinString.append("'");
        joinString.append(artistName);
        joinString.append("'");
        joinString.append(sortOrder(TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME, order));

        try (Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(joinString.toString())) {

            while (result.next()) {
                albumsForArtist.add(result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return albumsForArtist;
    }

    public String generatePlainSelectQuery(String tableName, String columnName, OrderByType order) {
        StringBuilder plainSelect = new StringBuilder("SELECT * FROM ");
        plainSelect.append(tableName);
        plainSelect.append(sortOrder(columnName, order));

        return plainSelect.toString();
    }

    public String sortOrder(String columnName, OrderByType order) {
        StringBuilder orderBy = new StringBuilder();

        if (order != OrderByType.NONE) {
            orderBy.append(" ORDER BY ");
            orderBy.append(columnName);
            orderBy.append(" COLLATE NOCASE ");

            switch (order) {
                case ASC:
                    orderBy.append("ASC");
                    break;
                case DESC:
                    orderBy.append("DESC");
                    break;
                default:
                    break;
            }
        }
        return orderBy.toString();
    }
}
