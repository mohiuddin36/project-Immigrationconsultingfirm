package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;

public class TerminologyAccuracyController
{
    @FXML
    private TableView<TranslatingDocumentData> tableView;

    @FXML
    private TableColumn<TranslatingDocumentData, String> docNameColumn;

    @FXML
    private TableColumn<TranslatingDocumentData, String> statusColumn;

    @FXML
    private TableColumn<TranslatingDocumentData, String> termColumn;

    @FXML
    private TextArea reviewArea;

    @FXML
    private Label statusLabel;

    private ObservableList<TranslatingDocumentData> documents = FXCollections.observableArrayList();
    private boolean formattingCorrect = false;
    private boolean termsValid = true;

    @FXML
    public void initialize() {
        docNameColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));

        statusColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getStatus()));

        termColumn.setCellValueFactory(data ->
                new SimpleStringProperty("Pending"));

        statusLabel.setText("Status: Ready");

        // Populate table with example documents
        documents.add(new TranslatingDocumentData("ClientPassport.pdf", "English", "Pending"));
        documents.add(new TranslatingDocumentData("VisaApplication.docx", "English", "Pending"));
        tableView.setItems(documents);
    }

    @FXML
    public void handleReviewTerminology(ActionEvent actionEvent) {
        TranslatingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            reviewArea.setText("Reviewing terminology for: " + selected.getName());
            if (!termsValid) {
                statusLabel.setText("Error found: word not in glossary");
            } else {
                statusLabel.setText("All keywords valid");
            }
        } else {
            statusLabel.setText("Select a document first");
        }
    }

    @FXML
    public void handleVerifyTerms(ActionEvent actionEvent) {
        TranslatingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            termColumn.setCellValueFactory(data ->
                    new SimpleStringProperty("Verified"));
            statusLabel.setText("Official terms verified for " + selected.getName());
        } else {
            statusLabel.setText("Select a document first");
        }
    }

    @FXML
    public void handleCheckLayout(ActionEvent actionEvent) {
        boolean layoutMismatch = false; // simulate layout check
        if (layoutMismatch) {
            statusLabel.setText("Layout mismatch → Adjusting formatting");
        } else {
            statusLabel.setText("Layout matches original");
        }
    }

    @FXML
    public void handleValidateStamps(ActionEvent actionEvent) {
        boolean stampMissing = false; // simulate stamp validation
        if (stampMissing) {
            statusLabel.setText("Stamp missing → Document incomplete");
        } else {
            statusLabel.setText("All stamps present");
        }
    }

    @FXML
    public void handleCorrectFormatting(ActionEvent actionEvent) {
        formattingCorrect = true; // simulate correcting formatting
        statusLabel.setText("Formatting errors corrected");
    }

    @FXML
    public void handleApproveDocument(ActionEvent actionEvent) {
        if (formattingCorrect) {
            statusLabel.setText("Document approved");
        } else {
            statusLabel.setText("Correct formatting before approval");
        }
    }

    @FXML
    public void handleSaveDocument(ActionEvent actionEvent) {
        if (formattingCorrect) {
            statusLabel.setText("Final document saved in system");
        } else {
            statusLabel.setText("Cannot save: formatting not approved");
        }
    }
}