package lk.ijse.gdse.hardwaremanagementsystem.util;

import lk.ijse.gdse.hardwaremanagementsystem.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudUtil {
    public static <T> T execute(String sql, Object...args)throws SQLException {
        Connection conn  = DBConnection.getInstance().getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        if(sql.startsWith("SELECT") || sql.startsWith("select")){
            return (T) pstmt.executeQuery();
        } else {
            return (T) (Boolean)(pstmt.executeUpdate()>0);
        }
    }
}
