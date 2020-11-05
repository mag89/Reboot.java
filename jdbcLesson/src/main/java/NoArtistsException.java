import java.util.function.Supplier;

public class NoArtistsException extends RuntimeException {
    public NoArtistsException(String s) {
        super(s);
    }

    public NoArtistsException() {
    }
}
