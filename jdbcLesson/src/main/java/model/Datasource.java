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
    public void close() throws Exception {
        try {
            if (!this.conn.isClosed()) {
                this.conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Artist> queryArtists(OrderByType order) {
        StringBuilder stringQuery = new StringBuilder("SELECT * FROM ");
        stringQuery.append(TABLE_ARTISTS);

        if (order != OrderByType.NONE) {
            stringQuery.append(" ORDER BY ");
            stringQuery.append(COLUMN_ARTIST_NAME);
            stringQuery.append(" COLLATE NOCASE ");

            switch (order) {
                case ASC:
                    stringQuery.append("ASC");
                    break;
                case DESC:
                    stringQuery.append("DESC");
                    break;
                default:
                    break;
            }
        }
        System.out.println(stringQuery.toString());
        try (Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(stringQuery.toString())) {

            List<Artist> artists = new ArrayList<>();
            while (result.next()) {
                Artist artist = new Artist(result.getInt(INDEX_ARTISTS_ID), result.getString(INDEX_ARTISTS_NAME));
                artists.add(artist);
            }

            return artists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
