module lk.ijse.gdse.hardwaremanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    //MYSQL eka add kara
    requires java.sql;
    requires mysql.connector.j;

    // Lombok eka add kala
    requires static lombok;




    opens lk.ijse.gdse.hardwaremanagementsystem.Controller to javafx.fxml;
    exports lk.ijse.gdse.hardwaremanagementsystem;
}