package dao.media;

import entity.db.AIMSDB;
import entity.media.Media;
import views.screen.popup.ErrorPopupScreen;
import entity.media.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @author
 */
public class MediaDAO extends DAO{
    public static HashMap<String, String> classNameMap = new HashMap<>();

    static {
        ArrayList<String> listClassName = new ArrayList<String>(Arrays.asList("Book", "CD", "DVD"));
        ArrayList<String> type = new ArrayList<String>(Arrays.asList("book", "cd", "dvd"));

        for (int i = 0; i < listClassName.size(); i++) {
            classNameMap.put(type.get(i), listClassName.get(i));
        }
    }

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

            // reflection
//            String type = res.getString("type");
//            String classNameDAO = "dao.media." + classNameMap.get(type) + "DAO";
//            try {
//                Class<?> clazz = Class.forName(classNameDAO);
//                Constructor<?> constructor = clazz.getConstructor();
//                DAO dao = (DAO) constructor.newInstance();
//                Media media = (Media) dao.getById(id);
//                medium.add(media);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
        }
        return medium;
    }

    @Override
    public String setUpQueryById(int id) {
        // will develop later
        return "SELECT * FROM Media WHERE id = " + id + ";";
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

        // reflection
//        if (res.next()) {
//            String type = res.getString("type");
//            String classNameDAO = "dao.media." + classNameMap.get(type) + "DAO";
//            try {
//                Class<?> clazz = Class.forName(classNameDAO);
//                Constructor<?> constructor = clazz.getConstructor();
//                DAO dao = (DAO) constructor.newInstance();
//                Media media = (Media) dao.getById(id);
//                return media;
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                return null;
//            }
//        }

        return null;
    }


    @Override
    public String setUpQueryUpdateById(int id, String type, String field, Object value) {
//        if (value instanceof String){
//            value = "\"" + value + "\"";
//        }
//        return " update Media set" + " "
//                + field + "=" + value + " "
//                + "where id=" + id + ";";
        // reflection
        String classNameDAO = "dao.media." + classNameMap.get(type) + "DAO";
        try {
            Class<?> clazz = Class.forName(classNameDAO);
            Constructor<?> constructor = clazz.getConstructor();
            DAO dao = (DAO) constructor.newInstance();
            return dao.setUpQueryUpdateById(id, type, field, value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
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
