package com.example.tonnidemo;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class NotificationsSendController {

    @FXML
    private TextField targetField;

    @FXML
    private TextArea messageArea;

    @FXML
    private TextField subjectField;

    private List<String> sent = new ArrayList<>();

    @FXML
    public void initialize() {}

    @FXML
    public void handleSend() {

        String target = targetField.getText();
        String msg = messageArea.getText();
        String subject = subjectField.getText();

        if (target.isEmpty() || msg.isEmpty() || subject.isEmpty()) return;

        sent.add(subject + " -> " + target);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Notification Sent!");
        alert.showAndWait();

        targetField.clear();
        messageArea.clear();
        subjectField.clear();
    }
}