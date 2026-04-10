package com.example.immigrationconsultingfirm_project_cse213.Client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    @FXML
    public void initialize() {
        messageLabel.setText("");
    }

    @FXML
    public void loginOnClickButton(ActionEvent actionEvent) {
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please enter username and password!");
            return;
        }

        if (username.equals("admin") && password.equals("1234")) {
            messageLabel.setText("Login Successful!");
        } else {
            messageLabel.setText("Invalid Username or Password!");
        }
    }
}
