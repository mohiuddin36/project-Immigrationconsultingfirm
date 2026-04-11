package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MessagesController {

    @FXML private TextArea chatArea;
    @FXML private TextField messageField;

    private final String receiver = "Receptionist"; // ✅ always send to receptionist

    @FXML
    public void initialize() {
        loadChat();
    }

    // ✅ SEND MESSAGE TO RECEPTIONIST
    @FXML
    private void sendMessage() {

        String msg = messageField.getText();
        if (msg == null || msg.isBlank()) return;

        String senderName;

        if (UserStorage.currentUser != null && UserStorage.currentUser.getName() != null) {
            senderName = UserStorage.currentUser.getName();
        } else {
            senderName = "Client";
        }

        MessageStorage.messages.add(
                new Message(senderName, receiver, msg)
        );

        messageField.clear();
        loadChat();
    }

    // ✅ LOAD ONLY THIS CLIENT'S CHAT
    private void loadChat() {

        StringBuilder sb = new StringBuilder();

        String currentUser = UserStorage.currentUser.getName();

        for (Message m : MessageStorage.messages) {

            if (
                    (m.getSender().equals(currentUser) && m.getReceiver().equals("Receptionist")) ||
                            (m.getSender().equals("Receptionist") && m.getReceiver().equals(currentUser))
            ) {
                sb.append(m.getSender())
                        .append(": ")
                        .append(m.getText())
                        .append("\n");
            }
        }

        chatArea.setText(sb.toString());
    }

    // ✅ CLEAR CHAT (ONLY THIS CLIENT)
    @FXML
    private void clearChat() {

        String currentUser = UserStorage.currentUser.getName();

        MessageStorage.messages.removeIf(
                m ->
                        (m.getSender().equals(currentUser) && m.getReceiver().equals("Receptionist")) ||
                                (m.getSender().equals("Receptionist") && m.getReceiver().equals(currentUser))
        );

        loadChat();
    }

    // ✅ BACK BUTTON (CLIENT ONLY)
    @FXML
    private void goBack() {

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/client_dashboard.fxml")
            );

            Stage stage = (Stage) chatArea.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Client Dashboard");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}