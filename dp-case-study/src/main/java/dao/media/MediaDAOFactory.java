package dao.media;

import java.sql.SQLException;

/**
 * The general media class, for another media it can be done by inheriting this
 * class
 * 
 * @author nguyenlm
 */
public class MediaDAOFactory {

    private MediaDAOFactory() {
    }

    public static final MediaDAO getMediaDAO(MediaType mediaType) throws SQLException {
        switch (mediaType) {
            case Book:
                return new BookDAO();
            case CD:
                return new CDDAO();
            case DVD:
                return new DVDDAO();
            default:
                throw new IllegalArgumentException("This media type is unsupported");
        }
    }
}