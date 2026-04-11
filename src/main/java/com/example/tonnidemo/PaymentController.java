package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;

public class PaymentController {

    @FXML private TextField appIdField;
    @FXML private TextField amountField;
    @FXML private ComboBox<String> methodBox;
    @FXML private TextField cardField;
    @FXML private TextField cvvField;

    @FXML private Label msgLabel;

    @FXML private TableView<Payment> paymentTable;
    @FXML private TableColumn<Payment, String> colId;
    @FXML private TableColumn<Payment, String> colApp;
    @FXML private TableColumn<Payment, Double> colAmount;
    @FXML private TableColumn<Payment, String> colMethod;
    @FXML private TableColumn<Payment, String> colStatus;

    private ObservableList<Payment> paymentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // Payment methods
        methodBox.setItems(FXCollections.observableArrayList(
                "Cash",
                "bKash",
                "Nagad",
                "Rocket",
                "Visa Card",
                "MasterCard"
        ));

        // Table mapping
        colId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colApp.setCellValueFactory(new PropertyValueFactory<>("applicationId"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colMethod.setCellValueFactory(new PropertyValueFactory<>("method"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        paymentTable.setItems(paymentList);

        methodBox.setOnAction(e -> toggleFields());
        toggleFields();
    }

    private void toggleFields() {
        String method = methodBox.getValue();

        boolean isCard = method != null &&
                (method.equals("Visa Card") || method.equals("MasterCard"));

        cardField.setDisable(!isCard);
        cvvField.setDisable(!isCard);
    }

    @FXML
    public void handlePay(ActionEvent event) {

        String appId = appIdField.getText();
        String amountText = amountField.getText();
        String method = methodBox.getValue();

        if (appId.isEmpty() || amountText.isEmpty() || method == null) {
            msgLabel.setText("❌ Fill all fields!");
            return;
        }

        double amount = Double.parseDouble(amountText);

        // Card validation
        if (method.contains("Card")) {
            if (cardField.getText().length() != 16 || cvvField.getText().length() != 3) {
                msgLabel.setText("❌ Invalid Card Details!");
                return;
            }
        }

        String paymentId = "PAY-" + UUID.randomUUID().toString().substring(0, 6);

        Payment payment = new Payment(paymentId, appId, amount, method);
        payment.setStatus("SUCCESS");

        paymentList.add(payment);

        msgLabel.setText("✅ Payment Successful! ID: " + paymentId);

        clearFields();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("client_dashboard.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void clearFields() {
        appIdField.clear();
        amountField.clear();
        cardField.clear();
        cvvField.clear();
        methodBox.getSelectionModel().clearSelection();
    }
}