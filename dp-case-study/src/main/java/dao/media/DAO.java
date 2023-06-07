package dao.media;

import entity.db.AIMSDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

abstract public class DAO {

    public List getAll() throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        String query = setUpQueryAll();
        ResultSet res = stm.executeQuery(query);
        return readDataAll(res);
    }

    abstract public String setUpQueryAll();

    // factory method
    abstract public List<?> readDataAll(ResultSet res) throws SQLException;

    public Object getById(int id) throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        String query = setUpQueryById(id);
        ResultSet res = stm.executeQuery(query);
        return readDataById(res, id);
    }

    abstract public String setUpQueryById(int id);

    // factory method
    abstract public Object readDataById(ResultSet res, int id) throws SQLException;

    public void updateFieldById(int id, String field, Object value) throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        String query = setUpQueryUpdateById(id, field, value);
        stm.executeUpdate(query);
    }
    abstract public String setUpQueryUpdateById(int id, String field, Object value);

}

