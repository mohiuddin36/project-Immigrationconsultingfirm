package com.example.javafxproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ClientDashboardController {

    private void openPage(String fxml, String title) {
        try {
            String path = "/com/example/javafxproject/" + fxml;

            System.out.println("Loading FXML: " + path);

            Parent root = FXMLLoader.load(
                    Objects.requireNonNull(
                            getClass().getResource(path),
                            "FXML file not found: " + path
                    )
            );

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bookService() {
        openPage("book_service.fxml", "Book Service");
    }

    public void viewAppointments() {
        openPage("appointments.fxml", "Appointments");
    }

    public void cancelBooking() {
        openPage("cancel_booking.fxml", "Cancel Booking");
    }

    public void payment() {
        openPage("payment.fxml", "Payment");
    }

    public void profile() {
        openPage("profile.fxml", "Profile");
    }

    public void messages() {
        openPage("messages.fxml", "Messages");
    }

    public void history() {
        openPage("history.fxml", "History");
    }

    public void feedback() {
        openPage("feedback.fxml", "Feedback");
    }
}