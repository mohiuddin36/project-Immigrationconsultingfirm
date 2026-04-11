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

public class PaymentController {

    @FXML private TableView<Booking> paymentTable;

    @FXML private TableColumn<Booking, String> nameColumn;
    @FXML private TableColumn<Booking, String> phoneColumn;
    @FXML private TableColumn<Booking, String> serviceColumn;
    @FXML private TableColumn<Booking, String> dateColumn;
    @FXML private TableColumn<Booking, String> timeColumn;

    @FXML private TextField amountField;

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

        paymentTable.setItems(BookingStorage.bookings);
    }

    // 💳 PAYMENT ACTION (FIXED)
    @FXML
    private void makePayment() {

        Booking selected = paymentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            System.out.println("⚠ Select a booking first!");
            return;
        }

        String amountText = amountField.getText();

        if (amountText == null || amountText.isBlank()) {
            System.out.println("⚠ Enter amount!");
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);

            // ❌ prevent double payment
            if ("Paid".equals(selected.getPaymentStatus())) {
                System.out.println("⚠ Already Paid!");
                return;
            }

            // ✅ FIX: store as STRING (because Booking uses String)
            selected.setAmount(String.valueOf(amount));
            selected.setPaymentStatus("Paid");

            paymentTable.refresh();

            System.out.println("✅ Payment Successful!");
            System.out.println("Customer: " + selected.getName());
            System.out.println("Amount: " + amount);

            amountField.clear();

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid amount!");
        }
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
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}