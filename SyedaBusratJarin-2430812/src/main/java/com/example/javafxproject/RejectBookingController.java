package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class RejectBookingController {

    @FXML private TableView<Booking> table;

    @FXML private TableColumn<Booking, String> nameCol;
    @FXML private TableColumn<Booking, String> serviceCol;
    @FXML private TableColumn<Booking, String> dateCol;
    @FXML private TableColumn<Booking, String> statusCol;

    @FXML
    public void initialize() {

        // ✅ Bind columns
        nameCol.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getName()));

        serviceCol.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getService()));

        dateCol.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getDate()));

        statusCol.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getStatus()));

        // ✅ Load shared booking list
        table.setItems(BookingStorage.getAllBookings());
    }

    // ✅ REJECT BUTTON
    @FXML
    private void rejectBooking() {

        Booking selected = table.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Please select a booking first!");
            return;
        }

        // ❗ Prevent duplicate actions
        if (selected.getStatus().equals("Rejected")) {
            showAlert("This booking is already rejected!");
            return;
        }

        if (selected.getStatus().equals("Approved")) {
            showAlert("This booking is already approved!");
            return;
        }

        // ✅ Update status using storage
        BookingStorage.updateStatus(selected, "Rejected");

        table.refresh(); // refresh UI

        showAlert("Booking Rejected Successfully!");
    }

    // ✅ ALERT METHOD
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Booking Status");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // 🔙 PREVIOUS BUTTON
    @FXML
    private void goBack(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/receptionist_dashboard.fxml")
            );

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Receptionist Dashboard");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}