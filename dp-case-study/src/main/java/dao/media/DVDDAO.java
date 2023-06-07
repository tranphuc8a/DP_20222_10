package dao.media;

import entity.db.AIMSDB;
import entity.media.DVD;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author
 */
public class DVDDAO extends DAO {
    @Override
    public String setUpQueryAll() {
        // will develop later
        return null;
    }

    @Override
    public List<DVD> readDataAll(ResultSet res) throws SQLException {
        // will develop later
        return null;
    }

    @Override
    public String setUpQueryById(int id) {
        return "SELECT * FROM "+
                "aims.DVD " +
                "INNER JOIN aims.Media " +
                "ON Media.id = DVD.id " +
                "where Media.id = " + id + ";";
    }

    @Override
    public DVD readDataById(ResultSet res, int id) throws SQLException {
        if(res.next()) {

            // from media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from DVD table
            String discType = res.getString("discType");
            String director = res.getString("director");
            int runtime = res.getInt("runtime");
            String studio = res.getString("studio");
            String subtitles = res.getString("subtitle");
            Date releasedDate = res.getDate("releasedDate");
            String filmType = res.getString("filmType");

            return new DVD(id, title, category, price, quantity, type, discType, director, runtime, studio, subtitles, releasedDate, filmType);

        } else {
            throw new SQLException();
        }
    }

    @Override
    public String setUpQueryUpdateById(int id, String field, Object value) {
        // will develop later
        return null;
    }
}
