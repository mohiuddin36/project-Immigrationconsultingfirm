package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;

public class TranslatingController
{
    @FXML
    private TextArea translationArea;

    @FXML
    private TableColumn<TranslatingDocumentData, String> statusColumn;

    @FXML
    private TableColumn<TranslatingDocumentData, String> docNameColumn;

    @FXML
    private TableView<TranslatingDocumentData> tableView;

    @FXML
    private TableColumn<TranslatingDocumentData, String> languageColumn;

    @FXML
    private Label statusLabel;

    private ObservableList<TranslatingDocumentData> documents = FXCollections.observableArrayList();
    private boolean approvalFlag = false;

    @FXML
    public void initialize() {

        // Map table columns to data
        docNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        languageColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLanguage()));
        statusColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));

        statusLabel.setText("Status: Ready");

        // Populate table with example documents
        documents.add(new TranslatingDocumentData("ClientPassport.pdf", "French", "N/A", "Pending"));
        documents.add(new TranslatingDocumentData("BirthCert.docx", "Spanish", "N/A", "Pending"));
        tableView.setItems(documents);
    }

    @FXML
    public void handleIdentifyDocuments(ActionEvent actionEvent) {
        // Scan document language, add non-English to translation queue
        ObservableList<TranslatingDocumentData> queue = FXCollections.observableArrayList();
        for (TranslatingDocumentData doc : documents) {
            if (!doc.getLanguage().equalsIgnoreCase("English")) {
                queue.add(doc);
            }
        }
        tableView.setItems(queue);
        statusLabel.setText("Non-English documents added to translation queue");
    }

    @FXML
    public void handleOpenWorkspace(ActionEvent actionEvent) {
        TranslatingDocumentData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            translationArea.setText("Original content of " + selected.getName());
            statusLabel.setText("Workspace opened for " + selected.getName());
        } else {
            statusLabel.setText("Select a document first");
        }
    }

    @FXML
    public void handleTranslateText(ActionEvent actionEvent) {
        String text = translationArea.getText();
        if (!text.isEmpty()) {
            translationArea.setText("[Translated to English] " + text);
            statusLabel.setText("Document translated");
        } else {
            statusLabel.setText("No text to translate");
        }
    }

    @FXML
    public void handlePreserveFormat(ActionEvent actionEvent) {
        // Simulate format preservation
        statusLabel.setText("Original format preserved");
    }

    @FXML
    public void handleReviewTranslation(ActionEvent actionEvent) {
        // Simulate grammar/meaning check
        boolean meaningIncorrect = false;
        if (meaningIncorrect) {
            statusLabel.setText("Meaning incorrect → Edit translation");
        } else {
            statusLabel.setText("Translation reviewed: correct");
        }
    }

    @FXML
    public void handleApproveTranslation(ActionEvent actionEvent) {
        approvalFlag = true;
        statusLabel.setText("Translation approved");
    }

    @FXML
    public void handleUploadDocument(ActionEvent actionEvent) {
        if (approvalFlag) {
            statusLabel.setText("Translated document uploaded successfully");
        } else {
            statusLabel.setText("Approve translation before uploading");
        }
    }
}