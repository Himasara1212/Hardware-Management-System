package lk.ijse.gdse.hardwaremanagementsystem.model;

import lk.ijse.gdse.hardwaremanagementsystem.db.DBConnection;
import lk.ijse.gdse.hardwaremanagementsystem.dto.ItemsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemsModel {

    /* -------------------- SAVE ITEM -------------------- */
    public boolean saveItem(ItemsDto item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO items (item_id, sup_id, category_id, name, price, qty) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, item.getItemId());
        pstm.setString(2, item.getSupId());
        pstm.setString(3, item.getCategoryId());
        pstm.setString(4, item.getName());
        pstm.setDouble(5, item.getPrice());
        pstm.setInt(6, item.getQty());

        return pstm.executeUpdate() > 0;
    }

    /* -------------------- GET NEXT ITEM ID -------------------- */
    public String getNextItemId() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        // Get the last inserted item_id
        String sql = "SELECT item_id FROM items ORDER BY item_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();

        if (rst.next()) {
            String lastId = rst.getString("item_id"); // e.g., "I005"
            int num = Integer.parseInt(lastId.substring(1)); // remove "I" and parse number
            num++; // next number
            return String.format("I%03d", num); // format as I001, I002...
        }

        // If no items exist, start with I001
        return "I001";
    }
}
