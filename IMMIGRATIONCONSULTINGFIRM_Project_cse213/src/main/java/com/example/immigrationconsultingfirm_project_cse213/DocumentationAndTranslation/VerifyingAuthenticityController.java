package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;

public class VerifyingAuthenticityController {

    @FXML
    private Label titleLabel;

    @FXML
    private TextField documentField;

    @FXML
    private Label statusLabel;

    @FXML
    private TableView<DocumentData> tableGoal2;

    @FXML
    private TableColumn<DocumentData, String> eventCol;

    @FXML
    private TableColumn<DocumentData, String> descCol;

    @FXML
    private TableColumn<DocumentData, String> typeCol;


    private boolean documentSelected = false;

    @FXML
    public void initialize() {

        statusLabel.setText("Status: Waiting");


        eventCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getEvent()));

        descCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDescription()));

        typeCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getType()));


        tableGoal2.getItems().addAll(
                new DocumentData("event-1", "Select document for verification", "UIE"),
                new DocumentData("event-2", "Check document clarity (readable or not)", "OP"),
                new DocumentData("event-3", "Validate document type (passport/certificate)", "UID"),
                new DocumentData("event-4", "Check all required pages", "OP"),
                new DocumentData("event-5", "Verify personal information correctness", "DP"),
                new DocumentData("event-6", "Update verification status", "UID")
        );
    }

    @FXML
    public void handleSelectDoc(ActionEvent actionEvent) {

        String doc = documentField.getText();

        if(doc == null || doc.isEmpty()) {
            statusLabel.setText("Please enter document name");
            documentSelected = false;
        } else {
            documentSelected = true;
            statusLabel.setText("Document Selected: " + doc);
        }
    }

    private boolean checkDocument() {
        if(!documentSelected) {
            statusLabel.setText("Select document first");
            return false;
        }
        return true;
    }


    @FXML
    public void handleClarity(ActionEvent actionEvent) {
        if(checkDocument()) {
            statusLabel.setText("Document is clear and readable");
        }
    }


    @FXML
    public void handleType(ActionEvent actionEvent) {
        if(checkDocument()) {
            statusLabel.setText("Valid document type confirmed");
        }
    }


    @FXML
    public void handlePages(ActionEvent actionEvent) {
        if(checkDocument()) {
            statusLabel.setText("All required pages are present");
        }
    }


    @FXML
    public void handleInfo(ActionEvent actionEvent) {
        if(checkDocument()) {
            statusLabel.setText("Information verified successfully");
        }
    }


    @FXML
    public void handleUpdate(ActionEvent actionEvent) {
        if(checkDocument()) {
            statusLabel.setText("Verification Completed");
        }
    }
}



