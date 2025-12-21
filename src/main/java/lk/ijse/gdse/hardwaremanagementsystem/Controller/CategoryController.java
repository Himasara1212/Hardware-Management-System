package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CategoryController {

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
    private TableColumn<?, ?> colCategoryId;

    @FXML
    private TableColumn<?, ?> colCategoryName;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private ComboBox<?> comCatId;

    @FXML
    private Label lblCategoryId;

    @FXML
    private TableView<?> tblCategories;

    @FXML
    private TextField txtCategoryName;

    @FXML
    private TextField txtItemId;

    @FXML
    void deletecat(ActionEvent event) {

    }

    @FXML
    void resetCat(ActionEvent event) {

    }

    @FXML
    void saveCat(ActionEvent event) {

    }

    @FXML
    void updateCat(ActionEvent event) {

    }

}
