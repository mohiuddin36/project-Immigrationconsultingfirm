package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClientBookingsController {

    @FXML
    private TableView<Booking> table;

    // ✅ PAY BUTTON ACTION
    @FXML
    private void payNow() {

        // 1. get selected booking
        Booking selected = table.getSelectionModel().getSelectedItem();

        // 2. check selection
        if (selected == null) {
            System.out.println("❌ Please select a booking first!");
            return;
        }

        // 3. already paid check
        if ("Paid".equals(selected.getPaymentStatus())) {
            System.out.println("⚠ Already Paid!");
            return;
        }

        // 4. update payment info (FIXED)
        selected.setPaymentStatus("Paid");
        selected.setAmount("500"); // ✅ FIX: must be String

        // 5. refresh UI
        table.refresh();

        System.out.println("✅ Payment Successful for: " + selected.getName());
    }
}