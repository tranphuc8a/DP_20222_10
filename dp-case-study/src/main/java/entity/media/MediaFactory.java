package entity.media;
import java.sql.SQLException;

/**
 * The general media class, for another media it can be done by inheriting this
 * class
 * 
 * @author nguyenlm
 */
public class MediaFactory {

    private MediaFactory() {
    }

    public static final Media getMedia(MediaType mediaType) throws SQLException {
        switch (mediaType) {
            case Book:
                return new Book();
            case CD:
                return new CD();
            case DVD:
                return new DVD();
            default:
                throw new IllegalArgumentException("This media type is unsupported");
        }
    }
}