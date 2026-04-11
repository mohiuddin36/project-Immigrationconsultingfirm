package com.example.tonnidemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientLoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    public void handleLogin(ActionEvent event) {

        String email = emailField.getText().trim();
        String pass = passwordField.getText().trim();

        if (email.isEmpty() || pass.isEmpty()) {
            messageLabel.setText("Fill all fields!");
            return;
        }

        // ✅ REAL LOGIN CHECK (REGISTERED USERS)
        boolean ok = UserStore.validateUser(email, pass);

        if (ok) {
            messageLabel.setText("Login Success!");
            switchScene("/com/example/tonnidemo/client_dashboard.fxml", event);
        } else {
            messageLabel.setText("Invalid Credentials!");
        }
    }

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