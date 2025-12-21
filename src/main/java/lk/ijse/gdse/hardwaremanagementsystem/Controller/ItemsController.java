package lk.ijse.gdse.hardwaremanagementsystem.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.hardwaremanagementsystem.dto.CategoryDto;
import lk.ijse.gdse.hardwaremanagementsystem.dto.SupplierDto;
import lk.ijse.gdse.hardwaremanagementsystem.dto.Tm.ItemTm;
import lk.ijse.gdse.hardwaremanagementsystem.model.CategoryModel;
import lk.ijse.gdse.hardwaremanagementsystem.model.ItemsModel;
import lk.ijse.gdse.hardwaremanagementsystem.model.SupplierModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemsController implements Initializable {
    @FXML
    private AnchorPane body;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGenerateReport;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<ItemTm, String> colItemId;

    @FXML
    private TableColumn<ItemTm, String> colItemName;

    @FXML
    private TableColumn<ItemTm, Double> colPrice;

    @FXML
    private TableColumn<ItemTm, Integer> colQty;

    @FXML
    private TableColumn<ItemTm, String> colSupId;

    @FXML
    private TableColumn<ItemTm, String> colSupName;

    @FXML
    private Label lblItemId;

    @FXML
    private TableView<?> tblItems;

    @FXML
    private TextField txtCategoryId;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtSupplierId;

    @FXML
    private ComboBox<String> comboCateId;

    @FXML
    private ComboBox<String> comboSupId;

    private CategoryModel categoryModel = new CategoryModel();
    private SupplierModel supplierModel = new SupplierModel();
    private ItemsModel itemsModel =  new ItemsModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
            colItemName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            colSupId.setCellValueFactory(new PropertyValueFactory<>("supId"));
            colSupName.setCellValueFactory(new PropertyValueFactory<>("supName"));

            pageReset();
            loadItemTable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void pageReset() throws Exception {
        loadCategoryIds();
        loadSuplierIds();
        loadItemId();
    }

    private void loadItemId() throws Exception {
        String nextItemId = itemsModel.getNextItemId();
        lblItemId.setText(nextItemId);
    }

    private void loadSuplierIds() throws Exception {
        ArrayList<SupplierDto> allSuppliers = supplierModel.getAllSuppliers();

        ObservableList<String> supIds = FXCollections.observableArrayList();

        for (SupplierDto dto : allSuppliers) {
            supIds.add(dto.getSupplierId() + " | " +  dto.getName());
        }

        comboSupId.setItems(supIds);
    }

    private void loadCategoryIds() throws Exception {

        ArrayList<CategoryDto> allCategories = categoryModel.getAllCategories();

        ObservableList<String> categoryIds = FXCollections.observableArrayList();
        for (CategoryDto dto : allCategories) {
            categoryIds.add(dto.getCategoryId() + " | " +dto.getName());
        }
        comboCateId.setItems(categoryIds);
    }

    @FXML
    void itemSave(ActionEvent event) {
        try {
            String itemId = lblItemId.getText();

            // Get only the IDs from the ComboBox value
            String categoryId = comboCateId.getSelectionModel().getSelectedItem().split(" \\| ")[0];
            String supplierId = comboSupId.getSelectionModel().getSelectedItem().split(" \\| ")[0];

            String itemName = txtItemName.getText();
            double price = Double.parseDouble(txtPrice.getText());

            boolean isSaved = itemsModel.saveItem(itemId, supplierId, categoryId, itemName, price);
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Item saved successfully!").show();
                clearTextFields();
                pageReset();   // Reset for next item
                loadItemTable(); // Refresh table

            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save item!").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    private void loadItemTable() {

    }

    private void clearTextFields() {
        txtItemName.clear();
        txtPrice.clear();
        txtQty.clear();

        comboCateId.getSelectionModel().clearSelection();
        comboSupId.getSelectionModel().clearSelection();
    }

}
