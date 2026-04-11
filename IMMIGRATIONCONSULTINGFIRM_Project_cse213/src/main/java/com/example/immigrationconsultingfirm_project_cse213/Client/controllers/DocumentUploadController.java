package com.example.immigrationconsultingfirm_project_cse213.Client.controllers;

import com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes.Document;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DocumentUploadController {

    @FXML private ComboBox<String> DocumentTypeComboBox;
    @FXML private Label MessageLabel;

    @FXML private TableView<Document> DocumentTableView;
    @FXML private TableColumn<Document, String> colDocumentType;
    @FXML private TableColumn<Document, String> colFileName;
    @FXML private TableColumn<Document, String> colUploadDate;
    @FXML private TableColumn<Document, String> colStatus;

    private ObservableList<Document> documents = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        DocumentTypeComboBox.getItems().addAll(
                "Passport Copy",
                "Educational Certificates",
                "Work Experience Letter",
                "Photograph"
        );

        colDocumentType.setCellValueFactory(new PropertyValueFactory<>("documentType"));
        colFileName.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        colUploadDate.setCellValueFactory(new PropertyValueFactory<>("uploadDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        DocumentTableView.setItems(documents);
    }

    @FXML
    public void UploadDocumentOnClick() {

        String type = DocumentTypeComboBox.getValue();

        // ERROR ALERT
        if (type == null) {
            showAlert("Error", "Please select a document type!", Alert.AlertType.ERROR);
            return;
        }

        Document doc = new Document(
                type,
                "demoFile.pdf",
                "2026-04-10",
                "Pending"
        );

        documents.add(doc);

        showAlert("Success", "Document uploaded successfully!", Alert.AlertType.INFORMATION);

        DocumentTypeComboBox.setValue(null);
    }

    // ALERT METHOD
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}