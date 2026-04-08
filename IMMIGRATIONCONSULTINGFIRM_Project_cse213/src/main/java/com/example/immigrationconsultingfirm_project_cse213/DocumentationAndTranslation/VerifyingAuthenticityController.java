package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;

public class VerifyingAuthenticityController
{
    @FXML
    private TextField inputField;

    @FXML
    private TableColumn<VerifyingDocumentData, String> nameColumn;

    @FXML
    private TableColumn<VerifyingDocumentData, String> typeColumn;

    @FXML
    private TableColumn<VerifyingDocumentData, String> statusColumn;

    @FXML
    private TableView<VerifyingDocumentData> tableView;

    @FXML
    private Label statusLabel;

    private ObservableList<VerifyingDocumentData> documents = FXCollections.observableArrayList();

    private boolean issueFlag = false;


    @FXML
    public void initialize() {

        nameColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));

        typeColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getType()));

        statusColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getStatus()));

        statusLabel.setText("Ready for verification");
    }


    @FXML
    public void handleSelect(ActionEvent actionEvent) {

        String name = inputField.getText();

        if (name.isEmpty()) {
            statusLabel.setText("Enter document name");
            return;
        }

        boolean formatValid = true;

        if (formatValid == true) {
            documents.clear();
            documents.add(new VerifyingDocumentData(name, "passport", "Selected"));
            tableView.setItems(documents);

            statusLabel.setText("Preview opened, format valid");
        }
    }


    @FXML
    public void handleClarity(ActionEvent actionEvent) {

        boolean readable = true;

        if (readable == true) {
            statusLabel.setText("Text readable → Passed");
        } else {
            statusLabel.setText("Request new upload");
            issueFlag = true;
        }
    }


    @FXML
    public void handleType(ActionEvent actionEvent) {

        boolean match = true;

        if (match == true) {
            statusLabel.setText("Document type valid");
        } else {
            statusLabel.setText("Invalid document type");
            issueFlag = true;
        }
    }


    @FXML
    public void handlePages(ActionEvent actionEvent) {

        int pages = 2;
        int required = 3;

        if (pages < required) {
            statusLabel.setText("Missing pages → Incomplete");
            issueFlag = true;
        } else {
            statusLabel.setText("All pages present");
        }
    }


    @FXML
    public void handleVerifyInfo(ActionEvent actionEvent) {

        boolean match = true;

        if (match == true) {
            statusLabel.setText("Client info matched → Valid");
        } else {
            statusLabel.setText("Mismatch found");
            issueFlag = true;
        }
    }


    @FXML
    public void handleFlag(ActionEvent actionEvent) {

        if (issueFlag == true) {
            statusLabel.setText("Issue Flag = TRUE");
        } else {
            statusLabel.setText("No issues found");
        }
    }


    @FXML
    public void handleUpdateStatus(ActionEvent actionEvent) {

        if (issueFlag == true) {
            statusLabel.setText("Status: Rejected");
        } else {
            statusLabel.setText("Status: Verified");
        }
    }
}
