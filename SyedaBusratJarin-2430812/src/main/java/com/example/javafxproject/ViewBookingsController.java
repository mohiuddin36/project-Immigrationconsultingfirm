package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ViewBookingsController {

    @FXML private TableView<Booking> table;
    @FXML private TableColumn<Booking, String> nameCol;
    @FXML private TableColumn<Booking, String> serviceCol;
    @FXML private TableColumn<Booking, String> dateCol;
    @FXML private TableColumn<Booking, String> statusCol;

    @FXML
    public void initialize() {

        nameCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));

        serviceCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getService()));

        dateCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDate()));

        statusCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getStatus()));

        table.setItems(BookingStorage.bookings);
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