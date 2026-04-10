package com.example.immigrationconsultingfirm_project_cse213.Client.controllers;

import com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes.Notification;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.UUID;

public class NotificationController {

    @FXML private TableView<Notification> NotificationTableView;
    @FXML private TableColumn<Notification,String> colMessage;
    @FXML private TableColumn<Notification,String> colStatus;
    @FXML private Label MessageLabel;

    private ObservableList<Notification> notifications = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        NotificationTableView.setItems(notifications);

        // ✅ Demo notification to check
        notifications.add(new Notification(UUID.randomUUID().toString(), "Your appointment is pending.", "Unread"));
    }

    @FXML
    public void AddNotificationOnClick(ActionEvent event) {
        Notification newNote = new Notification(
                UUID.randomUUID().toString(),
                "New document uploaded.",
                "Unread"
        );
        notifications.add(newNote);
        MessageLabel.setText("Notification added!");
    }

    @FXML
    public void MarkAsReadOnClick(ActionEvent event) {
        Notification selected = NotificationTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Read");
            NotificationTableView.refresh();
            MessageLabel.setText("Notification marked as read.");
        } else {
            MessageLabel.setText("Please select a notification.");
        }
    }
}




