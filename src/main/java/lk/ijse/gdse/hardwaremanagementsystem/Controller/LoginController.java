package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private AnchorPane body; // AnchorPane from Login.fxml root

    // 👉 Login button action
    @FXML
    void btnLogin(ActionEvent event) {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if (checkUser(email, password)) {
            showAlert("Login Successful", "Welcome " + email, Alert.AlertType.INFORMATION);
            openDashboard();
            clearFields();
        } else {
            showAlert("Login Failed", "Invalid email or password!", Alert.AlertType.ERROR);
        }
    }

    // 👉 SignUp button action
    @FXML
    void signup(ActionEvent event) {
        showAlert("Sign Up", "Sign Up button clicked!", Alert.AlertType.INFORMATION);
        // Optional: load SignUp.fxml if you have it
        // openSignUpForm();
    }

    // 👉 Check user from database
    private boolean checkUser(String email, String password) {
        String url = "jdbc:mysql://localhost:3306/hardwaredb";
        String user = "root";
        String pass = "1234"; // replace with your actual MySQL password

        String sql = "SELECT * FROM users WHERE email=? AND password=?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 👉 Helper methods
    private void clearFields() {
        txtEmail.clear();
        txtPassword.clear();
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void openDashboard() {
        try {
            AnchorPane dashboard = FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
            body.getChildren().setAll(dashboard);

            Stage stage = (Stage) body.getScene().getWindow();
            stage.setTitle("Hardware Management System - Dashboard");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load Dashboard!", Alert.AlertType.ERROR);
        }
    }

    // Optional: load signup form
    private void openSignUpForm() {
        try {
            AnchorPane signupForm = FXMLLoader.load(getClass().getResource("/view/SignUp.fxml"));
            body.getChildren().setAll(signupForm);

            Stage stage = (Stage) body.getScene().getWindow();
            stage.setTitle("Hardware Management System - Sign Up");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load SignUp form!", Alert.AlertType.ERROR);
        }
    }
}