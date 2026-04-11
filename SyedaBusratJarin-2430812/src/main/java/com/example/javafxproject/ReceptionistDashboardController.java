package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReceptionistDashboardController {

    // ✅ OPEN ANY PAGE METHOD
    private void openPage(String fxmlFile, String title) {
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

    // =========================
    // BUTTON ACTIONS
    // =========================

    @FXML
    public void viewBookings() {
        openPage("view_bookings.fxml", "View Bookings");
    }

    @FXML
    public void approveBooking() {
        openPage("approve_booking.fxml", "Approve Booking");
    }

    @FXML
    public void rejectBooking() {
        openPage("reject_booking.fxml", "Reject Booking");
    }

    @FXML
    public void assignTime() {
        openPage("assign_time.fxml", "Assign Time");
    }

    @FXML
    public void clientList() {
        openPage("client_list.fxml", "Client List");
    }

    @FXML
    public void paymentRecords() {
        openPage("payment_records.fxml", "Payment Records");
    }

    @FXML
    public void messages() {
        openPage("messages_receptionist.fxml", "Messages");
    }

    // OPTIONAL LOGOUT
    @FXML
    public void logout() {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/login.fxml")
            );

            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}