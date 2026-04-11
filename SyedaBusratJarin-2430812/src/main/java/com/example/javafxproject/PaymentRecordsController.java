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

public class PaymentRecordsController {

    @FXML private TableView<Booking> table;

    @FXML private TableColumn<Booking, String> usernameCol;
    @FXML private TableColumn<Booking, String> nameCol;
    @FXML private TableColumn<Booking, String> serviceCol;
    @FXML private TableColumn<Booking, String> amountCol;
    @FXML private TableColumn<Booking, String> statusCol;

    @FXML
    public void initialize() {

        // ✅ USERNAME
        usernameCol.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getUsername()));

        // ✅ NAME
        nameCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));

        // ✅ SERVICE
        serviceCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getService()));

        // ✅ AMOUNT
        amountCol.setCellValueFactory(data ->
                new SimpleStringProperty(
                        String.valueOf(data.getValue().getAmount())
                )
        );

        // ✅ PAYMENT STATUS
        statusCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getPaymentStatus()));

        // ✅ LOAD ALL BOOKINGS
        table.setItems(BookingStorage.getAllBookings());
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