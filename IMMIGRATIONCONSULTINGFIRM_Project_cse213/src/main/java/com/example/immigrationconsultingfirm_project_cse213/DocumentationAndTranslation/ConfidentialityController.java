package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;

public class ConfidentialityController

{
    @FXML
    private TableView<TranslatingDocumentData> tableView;

    @FXML
    private TableColumn<TranslatingDocumentData, String> docNameColumn;

    @FXML
    private TableColumn<TranslatingDocumentData, String> accessLevelColumn;

    @FXML
    private TableColumn<TranslatingDocumentData, String> statusColumn;

    @FXML
    private TextArea logArea;

    @FXML
    private Label statusLabel;

    private ObservableList<TranslatingDocumentData> documents = FXCollections.observableArrayList();

    // Simulation flags
    private boolean unauthorizedAccess = false;
    private boolean userBlocked = false;

    @FXML
    public void initialize() {
        // Map table columns
        docNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        accessLevelColumn.setCellValueFactory(data -> new SimpleStringProperty("General")); // default access
        statusColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));

        // Add some sample documents
        documents.add(new TranslatingDocumentData("Passport.pdf", "English", "Pending"));
        documents.add(new TranslatingDocumentData("VisaApplication.docx", "English", "Pending"));
        tableView.setItems(documents);

        statusLabel.setText("Status: Ready");
    }

    @FXML
    public void handleRestrictAccess(ActionEvent actionEvent) {
        TranslatingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String userRole = "guest"; // simulate user role
            if (!userRole.equals("authorized")) {
                accessLevelColumn.setCellValueFactory(data -> new SimpleStringProperty("Denied"));
                statusLabel.setText("Access denied for " + selected.getName());
                logArea.appendText("Access denied for user_role=" + userRole + " on " + selected.getName() + "\n");
            } else {
                accessLevelColumn.setCellValueFactory(data -> new SimpleStringProperty("Authorized"));
                statusLabel.setText("Access granted for " + selected.getName());
            }
        } else {
            statusLabel.setText("Select a document first");
        }
    }

    @FXML
    public void handleEncryptDocument(ActionEvent actionEvent) {
        TranslatingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            statusLabel.setText("Document encrypted: " + selected.getName());
            logArea.appendText("Encrypted document: " + selected.getName() + "\n");
        } else {
            statusLabel.setText("Select a document first");
        }
    }

    @FXML
    public void handleMonitorLogs(ActionEvent actionEvent) {
        statusLabel.setText("Monitoring access logs...");
        logArea.appendText("Access logs monitored.\n");
    }

    @FXML
    public void handleDetectUnauthorized(ActionEvent actionEvent) {
        unauthorizedAccess = true; // simulate detection
        if (unauthorizedAccess) {
            statusLabel.setText("Unauthorized access detected!");
            logArea.appendText("ALERT: Unauthorized access attempt detected!\n");
        } else {
            statusLabel.setText("No unauthorized access detected.");
        }
    }

    @FXML
    public void handleBlockUser(ActionEvent actionEvent) {
        if (unauthorizedAccess) {
            userBlocked = true;
            statusLabel.setText("Suspicious user blocked.");
            logArea.appendText("User access blocked due to unauthorized attempt.\n");
        } else {
            statusLabel.setText("No suspicious user to block.");
        }
    }

    @FXML
    public void handleNotifyAdmin(ActionEvent actionEvent) {
        if (unauthorizedAccess || userBlocked) {
            statusLabel.setText("Admin notified of security alert.");
            logArea.appendText("Admin notified of security incident.\n");
        } else {
            statusLabel.setText("No incidents to report.");
        }
    }

    @FXML
    public void handleRecordIncident(ActionEvent actionEvent) {
        if (unauthorizedAccess || userBlocked) {
            statusLabel.setText("Security incident recorded.");
            logArea.appendText("Security incident saved in system.\n");
        } else {
            statusLabel.setText("No incidents to record.");
        }
    }
}
