package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WarrentyController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSave1;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<?> cmbStatus;

    @FXML
    private TableColumn<?, ?> colEndDate;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colStartDate;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colWarrantyId;

    @FXML
    private DatePicker dpEndDate;

    @FXML
    private DatePicker dpStartDate;

    @FXML
    private Label lblWarrantyId;

    @FXML
    private TableView<?> tblWarranty;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextArea txtRemarks;

    @FXML
    void deleteWarranty(ActionEvent event) {

    }

    @FXML
    void saveWarranty(ActionEvent event) {

    }

    @FXML
    void updateWarranty(ActionEvent event) {

    }

}
