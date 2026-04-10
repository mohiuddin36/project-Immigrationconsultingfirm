package com.example.immigrationconsultingfirm_project_cse213.Client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class PaymentController {

    @FXML private TextField ApplicationIDTextField;
    @FXML private DatePicker ExpiryDateDatePicker;
    @FXML private TextField CVVTextField;
    @FXML private ComboBox<String> PaymentTypeComboBox;
    @FXML private Label messageLabel;
    @FXML private TextField CardNumTextField;

    @FXML
    public void initialize() {
        messageLabel.setText("");

        PaymentTypeComboBox.getItems().addAll("Visa", "MasterCard", "bKash", "Nagad", "Rocket");
        PaymentTypeComboBox.setPromptText("Select Payment Type");
        ExpiryDateDatePicker.setPromptText("Select Expiry Date");
    }

    @FXML
    public void PayOnClickButton(ActionEvent actionEvent) {

        try {
            String appId = ApplicationIDTextField.getText();
            String cardNum = CardNumTextField.getText();
            LocalDate expiry = ExpiryDateDatePicker.getValue();
            String cvv = CVVTextField.getText();
            String type = PaymentTypeComboBox.getValue();

            // EMPTY CHECK
            if (appId.isEmpty() || cardNum.isEmpty() || expiry == null || cvv.isEmpty() || type == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please fill all fields.");
                return;
            }

            // NUMBER VALIDATION (EXCEPTION HANDLING PART)
            Long.parseLong(cardNum);
            Integer.parseInt(cvv);

            // LENGTH CHECK
            if (cardNum.length() < 12 || cvv.length() < 3) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid card or CVV.");
                return;
            }

            // SUCCESS
            showAlert(Alert.AlertType.INFORMATION, "Success",
                    "Payment Successful via " + type + "!");

            messageLabel.setText("Payment Done!");

            // CLEAR FIELDS
            ApplicationIDTextField.clear();
            CardNumTextField.clear();
            CVVTextField.clear();
            ExpiryDateDatePicker.setValue(null);
            PaymentTypeComboBox.setValue(null);

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Card number and CVV must be numeric!");
        }
    }

    // ALERT METHOD
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}