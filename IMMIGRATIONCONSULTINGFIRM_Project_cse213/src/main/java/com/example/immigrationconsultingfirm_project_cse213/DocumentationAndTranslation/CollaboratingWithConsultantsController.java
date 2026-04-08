package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CollaboratingWithConsultantsController
{
    @FXML
    private TableColumn<VerifyingDocumentData, String> statusColumn;

    @FXML
    private TableColumn<VerifyingDocumentData, String> docNameColumn;

    @FXML
    private TextArea messageArea;

    @FXML
    private TableView<VerifyingDocumentData> tableView;

    @FXML
    private Label statusLabel;

    private ObservableList<VerifyingDocumentData> documents = FXCollections.observableArrayList();

    private boolean workDoneFlag = false;

    @FXML
    public void initialize() {
        // Initialize table columns
        docNameColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        statusColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));

        // Example documents
        documents.add(new VerifyingDocumentData("ClientPassport.pdf", "Document", "Pending"));
        documents.add(new VerifyingDocumentData("BirthCert.docx", "Document", "Pending"));

        tableView.setItems(documents);

        statusLabel.setText("Ready to collaborate");
    }

    @FXML
    public void handleReceiveRequest(ActionEvent actionEvent) {
        VerifyingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            messageArea.setText("Consultant request received for " + selected.getName());
            statusLabel.setText("Request opened");
        } else {
            statusLabel.setText("Select a document first");
        }
    }

    @FXML
    public void handleReviewCase(ActionEvent actionEvent) {
        VerifyingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            messageArea.setText("Reviewing case details for " + selected.getName());
            statusLabel.setText("Case loaded");
        } else {
            statusLabel.setText("Select a document first");
        }
    }

    @FXML
    public void handleRespondFeedback(ActionEvent actionEvent) {
        String feedback = messageArea.getText();
        VerifyingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null && !feedback.isEmpty()) {
            statusLabel.setText("Feedback sent for " + selected.getName());
        } else {
            statusLabel.setText("Enter feedback and select a document");
        }
    }

    @FXML
    public void handleRequestMissingDocs(ActionEvent actionEvent) {
        VerifyingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            statusLabel.setText("Missing documents requested for " + selected.getName());
            messageArea.setText("Notify client to upload missing documents for " + selected.getName());
        } else {
            statusLabel.setText("Select a document first");
        }
    }

    @FXML
    public void handleUpdateNotes(ActionEvent actionEvent) {
        String notes = messageArea.getText();
        VerifyingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null && !notes.isEmpty()) {
            statusLabel.setText("Notes updated for " + selected.getName());
        } else {
            statusLabel.setText("Enter notes and select a document");
        }
    }

    @FXML
    public void handleUpdateStatus(ActionEvent actionEvent) {
        VerifyingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("In Progress");
            tableView.refresh();
            statusLabel.setText("Document status updated to In Progress");
        } else {
            statusLabel.setText("Select a document first");
        }
    }

    @FXML
    public void handleConfirmCompletion(ActionEvent actionEvent) {
        VerifyingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            workDoneFlag = true;
            selected.setStatus("Completed");
            tableView.refresh();
            statusLabel.setText("Work confirmed completed for " + selected.getName());
        } else {
            statusLabel.setText("Select a document first");
        }
    }
}


