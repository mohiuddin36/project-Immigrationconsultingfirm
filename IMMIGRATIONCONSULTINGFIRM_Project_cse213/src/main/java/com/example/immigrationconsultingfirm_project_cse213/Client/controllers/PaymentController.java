package com.example.immigrationconsultingfirm_project_cse213.Client.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class PaymentController
{
    @javafx.fxml.FXML
    private TextField ApplicationIDTextField;
    @javafx.fxml.FXML
    private DatePicker ExpiryDateDatePicker;
    @javafx.fxml.FXML
    private TextField CVVTextField;
    @javafx.fxml.FXML
    private ComboBox<String> PaymentTypeComboBox;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TextField CardNumTextField;

    @javafx.fxml.FXML
    public void initialize() {
        messageLabel.setText("");
        PaymentTypeComboBox.getItems().addAll("Visa", "MasterCard", "bKash", "Nagad", "Rocket");
        PaymentTypeComboBox.setPromptText("Select Payment Type");
        ExpiryDateDatePicker.setPromptText("Select Expiry Date");
    }

    @javafx.fxml.FXML
    public void PayOnClickButton(ActionEvent actionEvent) {
        String appId = ApplicationIDTextField.getText();
        String cardNum = CardNumTextField.getText();
        LocalDate expiry = ExpiryDateDatePicker.getValue();
        String cvv = CVVTextField.getText();
        String type = PaymentTypeComboBox.getValue();

        if(appId.isEmpty() || cardNum.isEmpty() || expiry == null || cvv.isEmpty() || type == null) {
            messageLabel.setText("Please fill all fields.");
        }
        else if(cardNum.length() < 12 || cvv.length() < 3) {
            messageLabel.setText("Invalid card or CVV.");
        }
        else {
            messageLabel.setText("Payment Successful via " + type + "!");
            ApplicationIDTextField.clear();
            CardNumTextField.clear();
            CVVTextField.clear();
            ExpiryDateDatePicker.setValue(null);
            PaymentTypeComboBox.setValue(null);
            }
    }
}