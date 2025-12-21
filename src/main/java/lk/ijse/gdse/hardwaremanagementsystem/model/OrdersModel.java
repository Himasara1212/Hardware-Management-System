package lk.ijse.gdse.hardwaremanagementsystem.model;

import lk.ijse.gdse.hardwaremanagementsystem.db.DBConnection;
import lk.ijse.gdse.hardwaremanagementsystem.dto.OrdersDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdersModel {

//    public boolean saveOrder(OrdersDto dto) throws SQLException {
////        Connection connection = DBConnection.getInstance().getConnection();
////        String sql = "INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?, ?)";
////        PreparedStatement ps = connection.prepareStatement(sql);
////        ps.setString(1, dto.getOrderId());
////        ps.setString(2, dto.getCustomerId());
////        ps.setDate(3, java.sql.Date.valueOf(String.valueOf(dto.getOrderDate())));
////        ps.setDouble(4, dto.getTotalAmount());
////        ps.setString(5, dto.getStatus());
////        ps.setString(6, dto.getPaymentStatus());
////        ps.setString(7, dto.getDeliveryStatus());
////        return ps.executeUpdate() > 0;
//    }
}