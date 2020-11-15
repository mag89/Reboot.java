package model.exceptions;

public class NoAlbumsForArtistException extends RuntimeException {
    public NoAlbumsForArtistException(String m) {
        super(m);
    }

    public NoAlbumsForArtistException() {
    }
}
