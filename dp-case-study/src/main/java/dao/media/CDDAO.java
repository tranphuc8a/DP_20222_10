package dao.media;

import entity.db.AIMSDB;
import entity.media.CD;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author
 */
public class CDDAO extends DAO {
    @Override
    public String setUpQueryAll() {
        // will develop later
        return null;
    }

    @Override
    public List<CD> readDataAll(ResultSet res) throws SQLException {
        // will develop later
        return null;
    }

    @Override
    public String setUpQueryById(int id) {
        return "SELECT * FROM "+
                "aims.CD " +
                "INNER JOIN aims.Media " +
                "ON Media.id = CD.id " +
                "where Media.id = " + id + ";";
    }

    @Override
    public CD readDataById(ResultSet res, int id) throws SQLException {
        if(res.next()) {

            // from media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from CD table
            String artist = res.getString("artist");
            String recordLabel = res.getString("recordLabel");
            String musicType = res.getString("musicType");
            Date releasedDate = res.getDate("releasedDate");

            return new CD(id, title, category, price, quantity, type,
                    artist, recordLabel, musicType, releasedDate);

        } else {
            throw new SQLException();
        }
    }

    @Override
    public String setUpQueryUpdateById(int id, String field, Object value) {
        // will develop later
        return null;
    }
    //LSP: method getMediaById() thay đổi hành vi của lớp cha
//    @Override
//    public Media getMediaById(int id) throws SQLException {
//        String sql = "SELECT * FROM "+
//                "aims.CD " +
//                "INNER JOIN aims.Media " +
//                "ON Media.id = CD.id " +
//                "where Media.id = " + id + ";";
//
//        ResultSet res = AIMSDB.getConnection().createStatement().executeQuery(sql);
//        if(res.next()) {
//
//            // from media table
//            String title = "";
//            String type = res.getString("type");
//            int price = res.getInt("price");
//            String category = res.getString("category");
//            int quantity = res.getInt("quantity");
//
//            // from CD table
//            String artist = res.getString("artist");
//            String recordLabel = res.getString("recordLabel");
//            String musicType = res.getString("musicType");
//            Date releasedDate = res.getDate("releasedDate");
//
//            return new CD(id, title, category, price, quantity, type,
//                    artist, recordLabel, musicType, releasedDate);
//
//        } else {
//            throw new SQLException();
//        }
//    }
}
