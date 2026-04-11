package com.example.tonnidemo;

import com.example.tonnidemo.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StaffDashboardController {

    @FXML
    public void openAppointments(ActionEvent event) {
        SceneSwitcher.switchScene(event, "appointments_manage.fxml");
    }

    @FXML
    public void openDocuments(ActionEvent event) {
        SceneSwitcher.switchScene(event, "document_verification.fxml");
    }

    @FXML
    public void openPayments(ActionEvent event) {
        SceneSwitcher.switchScene(event, "payments_manage.fxml");
    }

    @FXML
    public void openClients(ActionEvent event) {
        SceneSwitcher.switchScene(event, "client_approval.fxml");
    }

    @FXML
    public void openNotifications(ActionEvent event) {
        SceneSwitcher.switchScene(event, "notifications_send.fxml");
    }

    @FXML
    public void goBack(ActionEvent event) {
        SceneSwitcher.switchScene(event, "staff_login.fxml");
    }
}