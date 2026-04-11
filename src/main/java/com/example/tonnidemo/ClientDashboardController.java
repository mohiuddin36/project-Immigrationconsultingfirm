package com.example.tonnidemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientDashboardController {

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    public void openHelpdesk(ActionEvent actionEvent) {
        switchScene("helpdesk.fxml", actionEvent);
    }

    @FXML
    public void openNotifications(ActionEvent actionEvent) {
        switchScene("notifications.fxml", actionEvent);
    }

    @FXML
    public void openAppointment(ActionEvent actionEvent) {
        switchScene("appointment.fxml", actionEvent);
    }

    @FXML
    public void openDocument(ActionEvent actionEvent) {
        switchScene("document_upload.fxml", actionEvent);
    }

    @FXML
    public void openApplication(ActionEvent actionEvent) {
        switchScene("application.fxml", actionEvent);
    }

    @FXML
    public void openPayment(ActionEvent actionEvent) {
        switchScene("payment.fxml", actionEvent);
    }

    // SCENE SWITCH METHOD
    private void switchScene(String fxml, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene()
                    .getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            showAlert("Error", "Cannot load page!");
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}