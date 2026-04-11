package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class CancelBookingController {

    @FXML private TableView<Booking> bookingTable;

    @FXML private TableColumn<Booking, String> nameColumn;
    @FXML private TableColumn<Booking, String> phoneColumn;
    @FXML private TableColumn<Booking, String> serviceColumn;
    @FXML private TableColumn<Booking, String> dateColumn;
    @FXML private TableColumn<Booking, String> timeColumn;

    @FXML
    public void initialize() {

        nameColumn.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getName()));

        phoneColumn.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getPhone()));

        serviceColumn.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getService()));

        dateColumn.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getDate()));

        timeColumn.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getTime()));

        bookingTable.setItems(BookingStorage.bookings);
    }

    // CANCEL SELECTED BOOKING
    @FXML
    private void cancelBooking() {

        Booking selected = bookingTable.getSelectionModel().getSelectedItem();

        if (selected != null) {
            BookingStorage.bookings.remove(selected);
            System.out.println("Booking Cancelled!");
        } else {
            System.out.println("Please select a booking first!");
        }
    }

    // GO BACK BUTTON
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