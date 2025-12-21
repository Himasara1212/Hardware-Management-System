package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.gdse.hardwaremanagementsystem.dto.OrdersDto;
import lk.ijse.gdse.hardwaremanagementsystem.model.OrdersModel;

import java.sql.SQLException;
import java.time.LocalDate;

public class OrdersController {

    @FXML
    private TextField txtOrderId;
    @FXML
    private TextField txtCustomerId;
    @FXML
    private TextField txtTotalAmount;

    private final OrdersModel ordersModel = new OrdersModel();

    @FXML
    void btnSaveOrder(ActionEvent event) {
//        try {
//            OrdersDto dto = new OrdersDto(
//                    txtOrderId.getText(),
//                    txtCustomerId.getText(),
//                    LocalDate.now().atStartOfDay(),
//                    Double.parseDouble(txtTotalAmount.getText()),
//                    "Pending",       // default status
//                    "Unpaid",        // default payment status
//                    "Not Delivered"  // default delivery status
//            );
//
//            boolean isSaved = ordersModel.saveOrder(dto);
//            if (isSaved) {
//                new Alert(Alert.AlertType.CONFIRMATION, "Order Saved Successfully!").show();
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Failed to Save Order!").show();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            new Alert(Alert.AlertType.ERROR, "Database Error!").show();
//        }
    }
}