package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.sql.*;
import java.time.LocalDate;

public class HomeController {

    @FXML
    private Label lblEmail1, lblEmail2, lblEmail3, lblEmail4, lblEmail5;
    @FXML
    private Label lblItem1, lblItem2, lblItem3, lblItem4, lblItem5;
    @FXML
    private Label lblItemQty1, lblItemQty2, lblItemQty3, lblItemQty4, lblItemQty5;
    @FXML
    private Label lblSup1, lblSup2, lblSup3, lblSup4, lblSup5;
    @FXML
    private Label lblTodayIR, lblTodayIi, lblcashOnHand, lblwellcome1;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private PieChart pieChart;

    private Connection connection;

    public void initialize() {
        connectDatabase();
        loadCashOnHand();
        loadTodayItems();
        loadHighDemandItems();
        loadBestSuppliers();
        loadPieChart();
        loadLineChart();
    }

    private void connectDatabase() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HMS",
                    "root", ""); // change password if any
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadCashOnHand() {
        try {
            LocalDate today = LocalDate.now();
            String sql = "SELECT SUM(total_amount) FROM payments WHERE payment_date = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setDate(1, Date.valueOf(today));
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double total = rs.getDouble(1);
                lblcashOnHand.setText("Rs." + total + "/=");
            } else {
                lblcashOnHand.setText("Rs.0/=");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTodayItems() {
        try {
            LocalDate today = LocalDate.now();

            String issuedSql = "SELECT COUNT(*) FROM orders WHERE order_date = ?";
            PreparedStatement pst1 = connection.prepareStatement(issuedSql);
            pst1.setDate(1, Date.valueOf(today));
            ResultSet rs1 = pst1.executeQuery();
            if (rs1.next()) {
                lblTodayIi.setText(String.valueOf(rs1.getInt(1)));
            }

            String returnedSql = "SELECT COUNT(*) FROM returns WHERE return_date = ?";
            PreparedStatement pst2 = connection.prepareStatement(returnedSql);
            pst2.setDate(1, Date.valueOf(today));
            ResultSet rs2 = pst2.executeQuery();
            if (rs2.next()) {
                lblTodayIR.setText(String.valueOf(rs2.getInt(1)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadHighDemandItems() {
        try {
            String sql = "SELECT i.name, SUM(o.qty) AS totalQty " +
                    "FROM items i JOIN orders o ON i.item_id = o.item_id " +
                    "GROUP BY i.name ORDER BY totalQty DESC LIMIT 5";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            Label[] itemLabels = {lblItem1, lblItem2, lblItem3, lblItem4, lblItem5};
            Label[] qtyLabels = {lblItemQty1, lblItemQty2, lblItemQty3, lblItemQty4, lblItemQty5};

            int i = 0;
            while (rs.next() && i < 5) {
                itemLabels[i].setText(rs.getString("name"));
                qtyLabels[i].setText(String.valueOf(rs.getInt("totalQty")));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadBestSuppliers() {
        try {
            String sql = "SELECT name, email FROM supplier LIMIT 5";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            Label[] supplierNames = {lblSup1, lblSup2, lblSup4, lblSup5};
            Label[] supplierEmails = {lblEmail1, lblEmail2, lblEmail3, lblEmail4, lblEmail5};

            int i = 0;
            while (rs.next() && i < 5) {
                if (i < supplierNames.length) {
                    supplierNames[i].setText(rs.getString("name"));
                }
                supplierEmails[i].setText(rs.getString("email"));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadPieChart() {
        try {
            String sql = "SELECT name, COUNT(*) AS qty FROM items GROUP BY name";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
            while (rs.next()) {
                pieChartData.add(new PieChart.Data(rs.getString("name"), rs.getInt("qty")));
            }
            pieChart.setData(pieChartData);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadLineChart() {
        try {
            String sql = "SELECT order_date, SUM(price*qty) AS total FROM orders GROUP BY order_date ORDER BY order_date ASC";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Sales");

            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(
                        rs.getDate("order_date").toString(),
                        rs.getDouble("total")
                ));
            }

            lineChart.getData().add(series);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
