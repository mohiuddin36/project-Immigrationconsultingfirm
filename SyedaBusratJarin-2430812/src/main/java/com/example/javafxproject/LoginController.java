package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML
    public void initialize() {
        System.out.println("Login page loaded");
    }

    // =========================
    // LOGIN AS CLIENT
    // =========================
    @FXML
    public void loginClient() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Please enter username & password!");
            return;
        }

        if (!UserStorage.users.containsKey(username)) {
            System.out.println("User not registered!");
            return;
        }

        User user = UserStorage.users.get(username);

        if (!user.getPassword().equals(password)) {
            System.out.println("Wrong password!");
            return;
        }

        if (!user.getRole().equals("Client")) {
            System.out.println("This is not a client account!");
            return;
        }

        // 👉 SET CURRENT USER
        UserStorage.currentUser = user;

        openWindow("client_dashboard.fxml", "Client Dashboard");
    }

    // =========================
    // LOGIN AS RECEPTIONIST
    // =========================
    @FXML
    public void loginReceptionist() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Please enter username & password!");
            return;
        }

        if (!UserStorage.users.containsKey(username)) {
            System.out.println("User not registered!");
            return;
        }

        User user = UserStorage.users.get(username);

        if (!user.getPassword().equals(password)) {
            System.out.println("Wrong password!");
            return;
        }

        if (!user.getRole().equals("Receptionist")) {
            System.out.println("This is not a receptionist account!");
            return;
        }

        // 👉 SET CURRENT USER
        UserStorage.currentUser = user;

        openWindow("receptionist_dashboard.fxml", "Receptionist Dashboard");
    }

    // =========================
    // OPEN REGISTER PAGE
    // =========================
    @FXML
    public void openRegister() {
        openWindow("register.fxml", "Register");
    }

    // =========================
    // COMMON WINDOW LOADER
    // =========================
    private void openWindow(String fxmlFile, String title) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/" + fxmlFile)
            );

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}