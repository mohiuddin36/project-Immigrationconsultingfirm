module com.example.tonnidemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tonnidemo to javafx.fxml;
    exports com.example.tonnidemo;
}