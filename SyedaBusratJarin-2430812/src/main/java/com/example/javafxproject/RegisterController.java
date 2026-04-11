package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private TextField nameField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;
    @FXML private TextArea addressField;
    @FXML private PasswordField passwordField;
    @FXML private ComboBox<String> roleCombo;

    @FXML
    public void initialize() {
        roleCombo.getItems().addAll("Client", "Receptionist");
    }

    @FXML
    private void registerUser(ActionEvent event) {

        String username = usernameField.getText();
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String password = passwordField.getText();
        String role = roleCombo.getValue();

        if (username.isEmpty() || name.isEmpty() || phone.isEmpty() ||
                email.isEmpty() || address.isEmpty() ||
                password.isEmpty() || role == null) {

            System.out.println("Please fill all fields!");
            return;
        }

        if (UserStorage.users.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }

        User user = new User(username, name, phone, email, address, password, role);
        UserStorage.users.put(username, user);

        System.out.println("Registration Successful!");

        goToLogin(event);
    }

    @FXML
    private void goBack(ActionEvent event) {
        goToLogin(event);
    }

    private void goToLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/login.fxml")
            );

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}