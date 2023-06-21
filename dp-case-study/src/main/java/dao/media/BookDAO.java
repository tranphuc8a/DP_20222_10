package dao.media;

import entity.db.AIMSDB;
import entity.media.Book;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 */
<<<<<<< HEAD
// Communicational cohesion
public class BookDAO extends MediaDAO {
    //LSP: method getMediaById() change the behavior of MediaDao
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM "+
                "aims.Book " +
                "INNER JOIN aims.Media " +
=======
public class BookDAO extends DAO {
    @Override
    public String setUpQueryAll() {
        // will develop later
        return null;
    }

    @Override
    public List<Book> readDataAll(ResultSet res) throws SQLException {
        // will develop later
        return null;
    }

    @Override
    public String setUpQueryById(int id) {
//        return  "SELECT * FROM Book, Media Where Book.id = Media.id And Book.id = 38";
        return "SELECT * FROM "+
                "Book " +
                "INNER JOIN Media " +
>>>>>>> 16366f343deff7759ed748047943d6e0bde4dbf6
                "ON Media.id = Book.id " +
                "where Media.id = " + id + ";";
    }

    @Override
    public Book readDataById(ResultSet res, int id) throws SQLException{
        if(res.next()) {

            // from Media table
            String title = res.getString("title");
            String type = res.getString("type");
            int price = res.getInt("price");
            String category = res.getString("category");
            String url = res.getString("imageUrl");
            int quantity = res.getInt("quantity");

            // from Book table
            String author = res.getString("author");
            String coverType = res.getString("coverType");
            String publisher = res.getString("publisher");
//            Date publishDate = res.getDate("publishDate");
            Date publishDate = new Date();
            int numOfPages = res.getInt("numOfPages");
            String language = res.getString("language");
            String bookCategory = res.getString("bookCategory");

            return new Book(id, title, category, url, price, quantity, type,
                    author, coverType, publisher, publishDate, numOfPages, language, bookCategory);

        } else {
            throw new SQLException();
        }
    }

    @Override
    public String setUpQueryUpdateById(int id, String type, String field, Object value) {
        // will develop later
        return null;
    }
}
