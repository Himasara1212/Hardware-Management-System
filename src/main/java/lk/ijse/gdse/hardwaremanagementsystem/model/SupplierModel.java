package lk.ijse.gdse.hardwaremanagementsystem.model;

import lk.ijse.gdse.hardwaremanagementsystem.db.DBConnection;
import lk.ijse.gdse.hardwaremanagementsystem.dto.SupplierDto;

import java.sql.*;

public class SupplierModel {

    public static boolean saveSupplier(SupplierDto dto) throws SQLException {
        String sql = "INSERT INTO supplier VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        stm.setString(1, dto.getSupplierId());
        stm.setString(2, dto.getName());
        stm.setString(3, dto.getContact());
        stm.setString(4, dto.getAddress());
        stm.setString(5, dto.getEmail());
        return stm.executeUpdate() > 0;
    }

    public static boolean updateSupplier(SupplierDto dto) throws SQLException {
        String sql = "UPDATE supplier SET name=?, contact=?, address=?, email=? WHERE supplier_id=?";
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        stm.setString(1, dto.getName());
        stm.setString(2, dto.getContact());
        stm.setString(3, dto.getAddress());
        stm.setString(4, dto.getEmail());
        stm.setString(5, dto.getSupplierId());
        return stm.executeUpdate() > 0;
    }

    public static boolean deleteSupplier(String id) throws SQLException {
        String sql = "DELETE FROM supplier WHERE supplier_id=?";
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        stm.setString(1, id);
        return stm.executeUpdate() > 0;
    }

    public SupplierDto getSupplier(String supplierId) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();

        String sql = "SELECT * FROM supplier WHERE supplier_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, supplierId);

        ResultSet resultSet = preparedStatement.executeQuery();

        SupplierDto supplierDto = null;

        if (resultSet.next()) {
            supplierDto = new SupplierDto();

            supplierDto.setSupplierId(resultSet.getString("supplier_id"));
            supplierDto.setName(resultSet.getString("name"));
            supplierDto.setContact(resultSet.getString("contact"));
            supplierDto.setAddress(resultSet.getString("address"));
            supplierDto.setEmail(resultSet.getString("email"));
        }
        return supplierDto;
    }
}


