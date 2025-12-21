package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DelevaryController {

    @FXML
    private AnchorPane body;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colDeliveryDate;

    @FXML
    private TableColumn<?, ?> colDeliveryId;

    @FXML
    private TableColumn<?, ?> colDeliveryPayment;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colReason;

    @FXML
    private ComboBox<?> comborderId;

    @FXML
    private DatePicker dpDeliveryDate;

    @FXML
    private Label lblDeliveryId;

    @FXML
    private TableView<?> tblDeliveries;

    @FXML
    private TextField txtDeliveryPayment;

    @FXML
    private TextField txtReason;

    @FXML
    void deleteDelivery(ActionEvent event) {

    }

    @FXML
    void deliverySave(ActionEvent event) {

    }

    @FXML
    void resetDelevery(ActionEvent event) {

    }

    @FXML
    void updateDelivery(ActionEvent event) {

    }

}
