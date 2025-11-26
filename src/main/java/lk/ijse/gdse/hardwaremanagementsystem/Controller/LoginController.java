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
import lk.ijse.gdse.hardwaremanagementsystem.dto.UserDto;
import lk.ijse.gdse.hardwaremanagementsystem.model.UserModel;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    private UserModel userModel = new UserModel();

    @FXML
    void btnSignUp(ActionEvent event) throws SQLException {
        System.out.println("btn click");
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if(userModel.isEmailExist(email)){
            UserDto userDto = userModel.getUser(email);
            System.out.println("email exist");

            if(userDto.getPassword().equals(password)){
                System.out.println("Login successful");
            }else {
                System.out.println("Password incorrect");
            }
        }else {
            System.out.println("email is invalid");
        }
    }
}