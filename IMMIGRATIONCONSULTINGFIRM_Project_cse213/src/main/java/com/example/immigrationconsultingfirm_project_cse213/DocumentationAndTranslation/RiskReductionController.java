package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class RiskReductionController
{
    @FXML
    private TableColumn<VerifyingDocumentData, String> statusColumn;

    @FXML
    private TableColumn<VerifyingDocumentData, String> docNameColumn;

    @FXML
    private TableColumn<VerifyingDocumentData, String> riskLevelColumn;

    @FXML
    private TextArea messageArea;

    @FXML
    private TableView<VerifyingDocumentData> tableView;

    @FXML
    private Label statusLabel;

    private ObservableList<VerifyingDocumentData> documents = FXCollections.observableArrayList();

    private boolean correctedUploaded = false;

    @FXML
    public void initialize() {

        docNameColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));

        statusColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));

        riskLevelColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getType())); // using type as riskLevel

        // Sample data
        documents.add(new VerifyingDocumentData("Passport.pdf", "Low", "Verified"));
        documents.add(new VerifyingDocumentData("VisaForm.docx", "Low", "Pending"));

        tableView.setItems(documents);

        statusLabel.setText("Ready to scan documents");
    }


    @FXML
    public void handleScanDocuments(ActionEvent actionEvent) {
        messageArea.setText("Scanning documents for mismatched data...");
        statusLabel.setText("Scan completed");
    }


    @FXML
    public void handleIdentifyRisks(ActionEvent actionEvent) {
        for (VerifyingDocumentData doc : documents) {
            boolean mismatch = doc.getName().contains("Visa"); // simulate condition
            if (mismatch) {
                doc.setType("High"); // risk_level = high
            }
        }
        tableView.refresh();
        statusLabel.setText("Risk factors identified");
    }


    @FXML
    public void handleFlagDocuments(ActionEvent actionEvent) {
        for (VerifyingDocumentData doc : documents) {
            if (doc.getType().equals("High")) {
                doc.setStatus("Flagged");
            }
        }
        tableView.refresh();
        statusLabel.setText("Risky documents flagged");
    }


    @FXML
    public void handleRequestCorrections(ActionEvent actionEvent) {
        VerifyingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            messageArea.setText("Correction request sent for " + selected.getName());
            statusLabel.setText("Client notified for correction");
        } else {
            statusLabel.setText("Select a document first");
        }
    }


    @FXML
    public void handleWaitForUpload(ActionEvent actionEvent) {
        if (!correctedUploaded) {
            messageArea.setText("Waiting for corrected document upload...");
            statusLabel.setText("Waiting...");
        } else {
            statusLabel.setText("Corrected document received");
        }
    }


    @FXML
    public void handleRecheckDocument(ActionEvent actionEvent) {
        VerifyingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            correctedUploaded = true;
            selected.setType("Low"); // risk resolved
            selected.setStatus("Rechecked");
            tableView.refresh();
            statusLabel.setText("Document re-checked successfully");
        } else {
            statusLabel.setText("Select a document first");
        }
    }


    @FXML
    public void handleApproveDocument(ActionEvent actionEvent) {
        VerifyingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null && correctedUploaded) {
            selected.setStatus("Approved");
            tableView.refresh();
            statusLabel.setText("Document approved → forwarded to consultant");
        } else {
            statusLabel.setText("Re-check document before approval");
        }
    }
}
