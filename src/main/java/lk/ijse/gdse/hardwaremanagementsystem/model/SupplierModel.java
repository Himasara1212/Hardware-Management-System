package lk.ijse.gdse.hardwaremanagementsystem.model;

import lk.ijse.gdse.hardwaremanagementsystem.db.DBConnection;
import lk.ijse.gdse.hardwaremanagementsystem.dto.SupplierDto;

import java.sql.*;
import java.util.ArrayList;

public class SupplierModel {
    public ArrayList<SupplierDto> getAllSuppliers() throws Exception {

        ArrayList<SupplierDto> supplierList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM supplier";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();

        while (rst.next()) {
            SupplierDto dto = new SupplierDto(
                    rst.getString("supplier_id"),
                    rst.getString("name"),
                    rst.getString("contact"),
                    rst.getString("email"),
                    rst.getString("address")
            );

            supplierList.add(dto);
        }

        return supplierList;
    }

}