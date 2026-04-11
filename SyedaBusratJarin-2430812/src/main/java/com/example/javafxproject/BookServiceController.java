package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BookServiceController {

    @FXML private TextField nameField;
    @FXML private TextField phoneField;
    @FXML private ComboBox<String> serviceCombo;
    @FXML private DatePicker datePicker;
    @FXML private TextField timeField;
    @FXML private TextArea addressArea;

    @FXML
    public void initialize() {
        serviceCombo.getItems().addAll(
                "Cleaning",
                "Repair",
                "Plumbing",
                "Electrical",
                "AC Service"
        );
    }

    // ✅ SUBMIT BUTTON
    @FXML
    private void handleSubmit(ActionEvent event) {

        String name = nameField.getText();
        String phone = phoneField.getText();
        String service = serviceCombo.getValue();
        String date = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "";
        String time = timeField.getText();

        // 🔴 VALIDATION
        if (name.isEmpty() || phone.isEmpty() || service == null || date.isEmpty() || time.isEmpty()) {
            showAlert("Error", "Please fill all fields!");
            return;
        }

        // ⭐ GET LOGGED IN USERNAME (IMPORTANT FIX)
        String username = (UserStorage.currentUser != null)
                ? UserStorage.currentUser.getUsername()
                : "Unknown";

        // ✅ CREATE BOOKING (FIXED)
        Booking booking = new Booking(
                username,
                name,
                phone,
                service,
                date,
                time
        );

        // ✅ SAVE
        BookingStorage.bookings.add(booking);

        // ✅ SUCCESS MESSAGE
        showAlert("Success", "Booking Submitted Successfully!");

        // ✅ CLEAR FORM
        nameField.clear();
        phoneField.clear();
        serviceCombo.setValue(null);
        datePicker.setValue(null);
        timeField.clear();
        addressArea.clear();

        System.out.println("Booking Saved by: " + username);
    }

    // ✅ ALERT METHOD
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // 🔙 BACK BUTTON
    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/client_dashboard.fxml")
            );

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Client Dashboard");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}