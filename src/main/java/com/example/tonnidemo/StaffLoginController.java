package com.example.tonnidemo;

import com.example.tonnidemo.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StaffLoginController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    @FXML
    public void handleLogin(ActionEvent event) {

        String email = emailField.getText();
        String pass = passwordField.getText();

        if (email == null || pass == null ||
                email.trim().isEmpty() || pass.trim().isEmpty()) {

            messageLabel.setText("Fill all fields!");
            return;
        }

        // 🔥 ANY LOGIN ACCEPT (NO FIXED CHECK)
        messageLabel.setText("Login Success!");

        SceneSwitcher.switchScene(event, "staff_dashboard.fxml");
    }
}