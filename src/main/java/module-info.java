module lk.ijse.gdse.hardwaremanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.gdse.hardwaremanagementsystem to javafx.fxml;
    exports lk.ijse.gdse.hardwaremanagementsystem;
}