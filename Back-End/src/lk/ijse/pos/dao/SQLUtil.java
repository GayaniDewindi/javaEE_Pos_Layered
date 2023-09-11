package lk.ijse.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {
    private static PreparedStatement getPreparedStatement(Connection connection, String sql , Object...parms) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i =0 ; i<parms.length;i++){
            pstm.setObject((i+1),parms[i]);
        }
        return pstm;
    }
    public static boolean executeUpdate(Connection connection, String sql, Object... params) throws SQLException, ClassNotFoundException {
        return getPreparedStatement(connection, sql, params).executeUpdate() > 0;
    }

    public static ResultSet executeQuery(Connection connection, String sql, Object... params) throws SQLException, ClassNotFoundException {
        return getPreparedStatement(connection, sql, params).executeQuery();
    }
}
