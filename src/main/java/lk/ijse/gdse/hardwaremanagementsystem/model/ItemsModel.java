package lk.ijse.gdse.hardwaremanagementsystem.model;

import lk.ijse.gdse.hardwaremanagementsystem.db.DBConnection;
import lk.ijse.gdse.hardwaremanagementsystem.dto.Tm.ItemTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemsModel {

    /* -------------------- GET NEXT ITEM ID -------------------- */

    public String getNextItemId() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT item_id FROM items ORDER BY item_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();

        if (rst.next()) {
            String lastId = rst.getString("item_id"); // I005
            int num = Integer.parseInt(lastId.substring(1));
            return String.format("I%03d", ++num);
        }
        return "I001";
    }

    /* -------------------- SAVE ITEM -------------------- */

    public boolean saveItem(
            String itemId,
            String supplierId,
            String categoryId,
            String name,
            double price
    ) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO items (item_id, supplier_id, category_id, name, price) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, itemId);
        pstm.setString(2, supplierId);
        pstm.setString(3, categoryId);
        pstm.setString(4, name);
        pstm.setDouble(5, price);

        return pstm.executeUpdate() > 0;
    }

    /* -------------------- GET ALL ITEMS -------------------- */

    public ArrayList<ItemTm> getAllItems() throws Exception {

        ArrayList<ItemTm> list = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();

        String sql = """
                SELECT i.item_id,
                       i.name,
                       i.price,
                       s.supplier_id,
                       s.name AS supplier_name
                FROM items i
                JOIN suppliers s ON i.supplier_id = s.supplier_id
                """;

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();

        while (rst.next()) {
            list.add(new ItemTm(
                    rst.getString("itemId"),
                    rst.getString("name"),
                    (int) rst.getDouble("price"),// methana error ekak aawa eeka hadanna int ekak damma.
                    rst.getInt("qty"),
                    rst.getString("supId"),
                    rst.getString("supName")
            ));
        }
        return list;
    }

    /* -------------------- UPDATE ITEM -------------------- */

    public boolean updateItem(
            String itemId,
            String supplierId,
            String categoryId,
            String name,
            double price
    ) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = """
                UPDATE items
                SET supplier_id = ?, category_id = ?, name = ?, price = ?
                WHERE item_id = ?
                """;

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, supplierId);
        pstm.setString(2, categoryId);
        pstm.setString(3, name);
        pstm.setDouble(4, price);
        pstm.setString(5, itemId);

        return pstm.executeUpdate() > 0;
    }

    /* -------------------- DELETE ITEM -------------------- */

    public boolean deleteItem(String itemId) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM items WHERE item_id = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, itemId);

        return pstm.executeUpdate() > 0;
    }
}
