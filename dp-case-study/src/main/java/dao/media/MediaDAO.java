package dao.media;

import entity.db.AIMSDB;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
public class MediaDAO extends DAO{
    @Override
    public String setUpQueryAll() {
        return "select * from Media";
    }

    @Override
    public List<Media> readDataAll(ResultSet res) throws SQLException {
        ArrayList medium = new ArrayList<>();
        while (res.next()) {
            Media media = new Media(
                    res.getInt("id"),
                    res.getString("title"),
                    res.getInt("quantity"),
                    res.getString("category"),
                    res.getString("imageUrl"),
                    res.getInt("price"),
                    res.getString("type"));
            medium.add(media);
        }
        return medium;
    }

    @Override
    public String setUpQueryById(int id) {
        // will develop later
        return "SELECT * FROM Media ;";
    }

    @Override
    public Media readDataById(ResultSet res, int id) throws SQLException {
        if (res.next()) {
            return new Media(
                    res.getInt("id"),
                    res.getString("title"),
                    res.getInt("quantity"),
                    res.getString("category"),
                    res.getString("imageUrl"),
                    res.getInt("price"),
                    res.getString("type"));
        }
        return null;
    }

    @Override
    public String setUpQueryUpdateById(int id, String field, Object value) {
        if (value instanceof String){
            value = "\"" + value + "\"";
        }
        return " update Media set" + " "
                + field + "=" + value + " "
                + "where id=" + id + ";";
    }
//    public List getAllMedia() throws SQLException {
//        Statement stm = AIMSDB.getConnection().createStatement();
//        ResultSet res = stm.executeQuery("select * from Media");
//        ArrayList medium = new ArrayList<>();
//        while (res.next()) {
//            Media media = new Media(
//                    res.getInt("id"),
//                    res.getString("title"),
//                    res.getInt("quantity"),
//                    res.getString("category"),
//                    res.getString("imageUrl"),
//                    res.getInt("price"),
//                    res.getString("type"));
//            medium.add(media);
//        }
//        return medium;
//    }
//
//    public Media getMediaById(int id) throws SQLException {
//        String sql = "SELECT * FROM Media ;";
//        Statement stm = AIMSDB.getConnection().createStatement();
//        ResultSet res = stm.executeQuery(sql);
//
//        if (res.next()) {
//            return new Media(
//                    res.getInt("id"),
//                    res.getString("title"),
//                    res.getInt("quantity"),
//                    res.getString("category"),
//                    res.getString("imageUrl"),
//                    res.getInt("price"),
//                    res.getString("type"));
//        }
//        return null;
//    }
//
//
//    public void updateMediaFieldById(String tbname, int id, String field, Object value) throws SQLException {
//        //biến tbname vi phạm stamp coupling
//        Statement stm = AIMSDB.getConnection().createStatement();
//        if (value instanceof String){
//            value = "\"" + value + "\"";
//        }
//        stm.executeUpdate(" update Media set" + " "
//                + field + "=" + value + " "
//                + "where id=" + id + ";");
//    }
}
