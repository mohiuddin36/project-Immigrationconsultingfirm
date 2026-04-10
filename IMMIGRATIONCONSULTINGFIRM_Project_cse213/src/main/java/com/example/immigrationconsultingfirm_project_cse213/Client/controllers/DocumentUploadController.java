package com.example.immigrationconsultingfirm_project_cse213.Client.controllers;

import com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes.Document;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.print.Doc;

public class DocumentUploadController
{
    @javafx.fxml.FXML
    private TableColumn<Document,String> colDocumentType;
    @javafx.fxml.FXML
    private Label MessageLabel;
    @javafx.fxml.FXML
    private ComboBox<String> DocumentTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Document,String> colUploadDate;
    @javafx.fxml.FXML
    private TableView<Document> DocumentTableView;
    @javafx.fxml.FXML
    private TableColumn<Document,String> colFileName;
    @javafx.fxml.FXML
    private TableColumn<Document,String> colStatus;

    @javafx.fxml.FXML
    public void initialize() {
        DocumentTypeComboBox.getItems().addAll("Passport Copy", "Educational Certificates", "Work Experience Letter", "Photograph");

        // Bind columns to Document model fields
        colDocumentType.setCellValueFactory(new PropertyValueFactory<>("documentType"));
        colFileName.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        colUploadDate.setCellValueFactory(new PropertyValueFactory<>("uploadDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void UploadDocumentOnClick(ActionEvent actionEvent) {
        MessageLabel.setText("Upload button clicked! (Add file chooser logic here)");
    }
}