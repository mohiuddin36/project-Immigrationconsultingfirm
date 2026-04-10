package com.example.immigrationconsultingfirm_project_cse213.Client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML private TextField PassportNumTextField;
    @FXML private TextField FullnameTextField;
    @FXML private PasswordField ConfirmPasswordField;
    @FXML private PasswordField PasswordField;
    @FXML private TextField PhoneNumTextField;
    @FXML private Label messageLabel;
    @FXML private TextField EmailTextField;

    @FXML
    public void initialize() {
        messageLabel.setText("");

        FullnameTextField.setPromptText("Enter full name");
        EmailTextField.setPromptText("Enter email");
        PhoneNumTextField.setPromptText("Enter phone number");
        PassportNumTextField.setPromptText("Enter passport number");
        PasswordField.setPromptText("Enter password");
        ConfirmPasswordField.setPromptText("Confirm password");
    }

    @FXML
    public void RegisterOnClickButton(ActionEvent actionEvent) {

        String fullname = FullnameTextField.getText();
        String email = EmailTextField.getText();
        String phone = PhoneNumTextField.getText();
        String passport = PassportNumTextField.getText();
        String pass = PasswordField.getText();
        String confirm = ConfirmPasswordField.getText();

        if (fullname.isEmpty() || email.isEmpty() || phone.isEmpty()
                || passport.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {

            showAlert("Error", "Please fill all fields!", Alert.AlertType.ERROR);
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            showAlert("Error", "Invalid email format!", Alert.AlertType.ERROR);
            return;
        }

        if (!phone.matches("\\d+")) {
            showAlert("Error", "Phone number must contain digits only!", Alert.AlertType.ERROR);
            return;
        }

        if (pass.length() < 6) {
            showAlert("Error", "Password must be at least 6 characters!", Alert.AlertType.ERROR);
            return;
        }

        if (!pass.equals(confirm)) {
            showAlert("Error", "Passwords do not match!", Alert.AlertType.ERROR);
            return;
        }

        // SUCCESS
        showAlert("Success", "Registration Successful!", Alert.AlertType.INFORMATION);
        messageLabel.setText("Registered Successfully!");

        FullnameTextField.clear();
        EmailTextField.clear();
        PhoneNumTextField.clear();
        PassportNumTextField.clear();
        PasswordField.clear();
        ConfirmPasswordField.clear();
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}