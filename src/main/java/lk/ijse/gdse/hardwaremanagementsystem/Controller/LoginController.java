package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.gdse.hardwaremanagementsystem.dto.UserDto;
import lk.ijse.gdse.hardwaremanagementsystem.model.UserModel;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    @FXML
    private AnchorPane body;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    private UserModel userModel = new UserModel();

    @FXML
    void btnSignUp(ActionEvent event) throws SQLException, IOException {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if(userModel.isEmailExist(email)){
            UserDto userDto = userModel.getUser(email);

            if(userDto.getPassword().equals(password)){
                new Alert(Alert.AlertType.CONFIRMATION, "Login Successfully!").showAndWait();

                //HERE NEED TO SEND LOGED EMAIL TO DASHBOARD
                DashBoardController.setEmail(email); //here set the email on dashboard controller

                //Here need to load the Dashboard
                navigateToDashBoard();

            }else {
                new Alert(Alert.AlertType.ERROR, "Password incorrect").show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "email is invalid").show();
        }
    }

    private void navigateToDashBoard() throws IOException {
        body.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
        body.getChildren().add(load);
        Stage stage = (Stage) body.getScene().getWindow();
        stage.setTitle("Hardware Management System");
    }
}

