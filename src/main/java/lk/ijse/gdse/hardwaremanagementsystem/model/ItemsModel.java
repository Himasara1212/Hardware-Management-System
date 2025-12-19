package lk.ijse.gdse.hardwaremanagementsystem.model;

import lk.ijse.gdse.hardwaremanagementsystem.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemsModel {

    public String getNextItemId() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT item_id FROM items ORDER BY item_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            String lastId = rst.getString("item_id"); // e.g. I005
            int number = Integer.parseInt(lastId.substring(1));
            number++;
            return String.format("I%03d", number);
        } else {
            return "I001";
        }
    }

    public boolean saveItem(String itemId, String supplierId, String categoryId, String name, double price) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO items (item_id, supplier_id, category_id, name, price) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, itemId);
        pstm.setString(2, supplierId);
        pstm.setString(3, categoryId);
        pstm.setString(4, name);
        pstm.setDouble(5, price);

        int affectedRows = pstm.executeUpdate();
        return affectedRows > 0;
    }
}
