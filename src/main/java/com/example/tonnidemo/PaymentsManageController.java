package com.example.tonnidemo;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PaymentsManageController {

    @FXML
    private TableView<String> paymentTable;

    @FXML
    public void initialize() {}

    @FXML
    public void handleConfirm() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Payment Confirmed");
        a.showAndWait();
    }

    @FXML
    public void handleReject() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Payment Rejected");
        a.showAndWait();
    }
}