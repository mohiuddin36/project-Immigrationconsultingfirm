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

public class RegisterController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    public void handleRegister(ActionEvent event) {

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String pass = passwordField.getText().trim();

        if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            messageLabel.setText("❌ Fill all fields!");
            return;
        }

        if (!name.matches("[a-zA-Z ]+")) {
            messageLabel.setText("❌ Invalid name!");
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            messageLabel.setText("❌ Invalid email!");
            return;
        }

        // CREATE USER (IMPORTANT FIX)
        User user = new RegisteredUser(
                "U" + System.currentTimeMillis(),
                name,
                email,
                pass
        );

        UserStore.addUser(user);

        messageLabel.setText("✅ Registration Successful!");

        switchScene("/com/example/tonnidemo/client_login.fxml", event);
    }

    @FXML
    public void goToLogin(ActionEvent event) {
        switchScene("/com/example/tonnidemo/client_login.fxml", event);
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