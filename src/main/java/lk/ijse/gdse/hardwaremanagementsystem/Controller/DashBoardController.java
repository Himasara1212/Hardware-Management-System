package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.gdse.hardwaremanagementsystem.dto.UserDto;
import lk.ijse.gdse.hardwaremanagementsystem.model.UserModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
    public static String email;
    public static void setEmail(String email){
        DashBoardController.email = email;
    }

    @FXML
    private AnchorPane body;

    @FXML
    private Text lblUserEmail;

    @FXML
    private Text lblUserName;

    private UserModel userModel = new UserModel();

    //Here use initialize methord when go to the dsahboard fristly call this method as the constructor (Bu the fxml Application)
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            pageReset();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void pageReset() throws SQLException {
        //set user Email ---
        lblUserEmail.setText(email + " ");

        //Here getting the User Data from database
        UserDto user = userModel.getUser(email);
        lblUserName.setText(user.getUsername());
    }

    @FXML
    void btnAddNewUser(ActionEvent event) {

    }

    @FXML
    void btnLogOut(ActionEvent event) {

    }

    @FXML
    void navigateToDelivary(ActionEvent event) {

    }

    @FXML
    void navigateToGmail(ActionEvent event) {

    }

    @FXML
    void navigateToHome(ActionEvent event) {

    }

    @FXML
    void navigateToItem(ActionEvent event) {

    }

    @FXML
    void navigateToOrder(ActionEvent event) {

    }

    @FXML
    void navigateToPayment(ActionEvent event) {

    }

    @FXML
    void navigateToSettings(ActionEvent event) {

    }
}
