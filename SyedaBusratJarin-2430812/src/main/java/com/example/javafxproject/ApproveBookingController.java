package com.example.javafxproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ApproveBookingController {

    @FXML private TableView<Booking> table;

    @FXML private TableColumn<Booking, String> nameCol;
    @FXML private TableColumn<Booking, String> serviceCol;
    @FXML private TableColumn<Booking, String> dateCol;
    @FXML private TableColumn<Booking, String> statusCol;

    @FXML
    public void initialize() {

        // ✅ Bind columns
        nameCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));

        serviceCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getService()));

        dateCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDate()));

        statusCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getStatus()));

        // ✅ OPTIONAL: Show only pending bookings
        FilteredList<Booking> pendingBookings = new FilteredList<>(
                BookingStorage.bookings,
                b -> b.getStatus().equals("Pending")
        );

        table.setItems(pendingBookings);
    }

    // ✅ APPROVE BUTTON
    @FXML
    private void approveBooking() {

        Booking selected = table.getSelectionModel().getSelectedItem();

        if (selected != null) {

            // ✅ Use centralized method
            BookingStorage.updateStatus(selected, "Approved");

            table.refresh();

            System.out.println("Booking Approved!");

        } else {
            showAlert("Please select a booking first!");
        }
    }

    // ✅ ALERT (better UX)
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(msg);
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