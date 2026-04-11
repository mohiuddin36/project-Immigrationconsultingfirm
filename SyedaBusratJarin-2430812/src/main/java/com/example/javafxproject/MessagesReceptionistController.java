package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

public class MessagesReceptionistController {

    @FXML private ListView<String> clientList;
    @FXML private TextArea chatArea;
    @FXML private TextField messageField;

    private String selectedClient = null;

    @FXML
    public void initialize() {
        loadClients();

        clientList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            selectedClient = newVal;
            loadChat();
        });
    }

    // ✅ LOAD UNIQUE CLIENT NAMES
    private void loadClients() {

        Set<String> clients = new HashSet<>();

        for (Message m : MessageStorage.messages) {

            if (m.getReceiver().equals("Receptionist")) {
                clients.add(m.getSender());
            }

            if (m.getSender().equals("Receptionist")) {
                clients.add(m.getReceiver());
            }
        }

        clientList.getItems().setAll(clients);
    }

    // ✅ LOAD CHAT FOR SELECTED CLIENT
    private void loadChat() {

        if (selectedClient == null) return;

        StringBuilder sb = new StringBuilder();

        for (Message m : MessageStorage.messages) {

            if (
                    (m.getSender().equals(selectedClient) && m.getReceiver().equals("Receptionist")) ||
                            (m.getSender().equals("Receptionist") && m.getReceiver().equals(selectedClient))
            ) {
                sb.append(m.getSender())
                        .append(": ")
                        .append(m.getText())
                        .append("\n");
            }
        }

        chatArea.setText(sb.toString());
    }

    // ✅ SEND REPLY
    @FXML
    private void sendReply() {

        String msg = messageField.getText();

        if (msg == null || msg.isBlank() || selectedClient == null) return;

        MessageStorage.messages.add(
                new Message("Receptionist", selectedClient, msg)
        );

        messageField.clear();
        loadChat();
    }

    // ✅ BACK BUTTON (IMPORTANT FIX)
    @FXML
    private void goBack() {

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/receptionist_dashboard.fxml")
            );

            Stage stage = (Stage) chatArea.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Receptionist Dashboard");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}