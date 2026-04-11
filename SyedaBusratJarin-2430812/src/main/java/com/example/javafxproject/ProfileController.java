package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ProfileController {

    @FXML private TextField usernameField;
    @FXML private TextField nameField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;
    @FXML private TextArea addressField;
    @FXML private PasswordField passwordField;

    // =========================
    // LOAD CURRENT USER DATA
    // =========================
    @FXML
    public void initialize() {

        User user = UserStorage.currentUser;

        if (user != null) {
            usernameField.setText(user.getUsername());
            nameField.setText(user.getName());
            phoneField.setText(user.getPhone());
            emailField.setText(user.getEmail());
            addressField.setText(user.getAddress());
            passwordField.setText(user.getPassword());
        }
    }

    // =========================
    // UPDATE PROFILE
    // =========================
    @FXML
    private void updateProfile() {

        User oldUser = UserStorage.currentUser;

        if (oldUser == null) return;

        String newUsername = usernameField.getText();

        // If username changed, remove old entry
        if (!oldUser.getUsername().equals(newUsername)) {
            UserStorage.users.remove(oldUser.getUsername());
        }

        User updatedUser = new User(
                newUsername,
                nameField.getText(),
                phoneField.getText(),
                emailField.getText(),
                addressField.getText(),
                passwordField.getText(),
                oldUser.getRole()
        );

        UserStorage.users.put(newUsername, updatedUser);
        UserStorage.currentUser = updatedUser;

        System.out.println("Profile Updated Successfully!");
    }

    // =========================
    // LOGOUT
    // =========================
    @FXML
    private void logout(ActionEvent event) {

        UserStorage.currentUser = null;

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

    // =========================
    // BACK TO DASHBOARD
    // =========================
    @FXML
    private void goBack(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/client_dashboard.fxml")
            );

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Client Dashboard");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}