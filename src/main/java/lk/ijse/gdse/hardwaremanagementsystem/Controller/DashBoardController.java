package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.gdse.hardwaremanagementsystem.dto.UserDto;
import lk.ijse.gdse.hardwaremanagementsystem.model.UserModel;

import java.io.IOException;
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
    private AnchorPane sBody;

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
    void btnAddNewUser(ActionEvent event)  {
        try{
            Parent load = FXMLLoader.load(getClass().getResource("/view/CreateAccount.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.setTitle("Create Account");
            stage.show();
        }catch (IOException e1){
            System.out.println("Unable to create Account page");
            e1.printStackTrace();
        }

    }

    @FXML
    void btnLogOut(ActionEvent event)  {
        try{
            sBody.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            sBody.getChildren().add(load);
            Stage stage = (Stage) sBody.getScene().getWindow();
            stage.setTitle("Log in");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void navigateToDelivary(ActionEvent event) throws IOException {
        sBody.getChildren().clear();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/delivary.fxml"));
        AnchorPane load = loader.load();

        sBody.getChildren().add(load);

    }

    @FXML
    void navigateToGmail(ActionEvent event) throws IOException {
        sBody.getChildren().clear();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gmail.fxml"));
        AnchorPane load = loader.load();

        sBody.getChildren().add(load);

    }

    @FXML
    void navigateToHome(ActionEvent event) throws IOException {
        sBody.getChildren().clear();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/home.fxml"));
        AnchorPane load = loader.load();

        sBody.getChildren().add(load);
    }

    @FXML
    void navigateToItem(ActionEvent event) throws IOException {
        sBody.getChildren().clear();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/item.fxml"));
        AnchorPane load = loader.load();

        sBody.getChildren().add(load);

    }

    @FXML
    void navigateToOrder(ActionEvent event) throws IOException {
        sBody.getChildren().clear();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/order.fxml"));
        AnchorPane load = loader.load();

        sBody.getChildren().add(load);
    }

    @FXML
    void navigateToPayment(ActionEvent event) throws IOException {
        sBody.getChildren().clear();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/payment.fxml"));
        AnchorPane load = loader.load();

        sBody.getChildren().add(load);

    }

    @FXML
    void navigateToSettings(ActionEvent event) throws IOException {
        sBody.getChildren().clear();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/settings.fxml"));
        AnchorPane load = loader.load();

        sBody.getChildren().add(load);
    }
}