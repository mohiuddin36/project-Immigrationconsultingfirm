package com.example.tonnidemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RoleSelectionController {

    @FXML
    public void openClient(ActionEvent event) {
        // 👉 Client goes to Register page first
        switchScene("/com/example/tonnidemo/Register.fxml", event);
    }

    @FXML
    public void openStaff(ActionEvent event) {
        // 👉 Staff goes directly to login page
        switchScene("/com/example/tonnidemo/staff_login.fxml", event);
    }

    // 🔁 COMMON SCENE SWITCH METHOD
    private void switchScene(String fxml, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene()
                    .getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}