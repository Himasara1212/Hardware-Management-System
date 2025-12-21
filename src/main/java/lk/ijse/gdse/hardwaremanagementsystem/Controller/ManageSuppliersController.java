package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ManageSuppliersController {

    @FXML
    private Button BtnAddItem;

    @FXML
    private AnchorPane body;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGetAllReport;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> columnAddress;

    @FXML
    private TableColumn<?, ?> columnContact;

    @FXML
    private TableColumn<?, ?> columnEmail;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnSupplierId;

    @FXML
    private TableColumn<?, ?> columnTempCategoryId;

    @FXML
    private TableColumn<?, ?> columnTempItemId;

    @FXML
    private TableColumn<?, ?> columnTempName;

    @FXML
    private TableColumn<?, ?> columnTempPrice;

    @FXML
    private TableColumn<?, ?> columnTempQty;

    @FXML
    private ComboBox<?> comboItemId;

    @FXML
    private Label lblItemName;

    @FXML
    private Label lblSupplierId;

    @FXML
    private TableView<?> tableSupplier;

    @FXML
    private TableView<?> tempItemTable;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtemail;

    @FXML
    void UpdateSupplier(ActionEvent event) {

    }

    @FXML
    void deleteSupplier(ActionEvent event) {

    }

    @FXML
    void getAllRepoet(ActionEvent event) {

    }

    @FXML
    void getDataOnClick(MouseEvent event) {

    }

    @FXML
    void getmemActivityReport(ActionEvent event) {

    }

    @FXML
    void getsupReport(ActionEvent event) {

    }

    @FXML
    void gotoManageItem(ActionEvent event) {

    }

    @FXML
    void onClickCombo(ActionEvent event) {

    }

    @FXML
    void resetthePage(ActionEvent event) {

    }

    @FXML
    void saveSupplier(ActionEvent event) {

    }

}
