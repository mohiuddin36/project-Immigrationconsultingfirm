package com.example.immigrationconsultingfirm_project_cse213.Client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
        // Default setup
        messageLabel.setText(""); // start e blank rakha
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

        // Empty field check
        if(fullname.isEmpty() || email.isEmpty() || phone.isEmpty() || passport.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
            messageLabel.setText("Please fill all fields.");
        }
        // Email format check
        else if(!email.contains("@") || !email.contains(".")) {
            messageLabel.setText("Invalid email format.");
        }
        // Phone digits only check
        else if(!phone.matches("\\d+")) {
            messageLabel.setText("Phone number must contain digits only.");
        }
        // Password length check
        else if(pass.length() < 6) {
            messageLabel.setText("Password must be at least 6 characters.");
        }
        // Password match check
        else if(!pass.equals(confirm)) {
            messageLabel.setText("Passwords do not match.");
        }
        else {
            messageLabel.setText("Registration Successful!");
            // TODO: save user info to file or database here
            FullnameTextField.clear();
            EmailTextField.clear();
            PhoneNumTextField.clear();
            PassportNumTextField.clear();
            PasswordField.clear();
            ConfirmPasswordField.clear();
        }
    }
}