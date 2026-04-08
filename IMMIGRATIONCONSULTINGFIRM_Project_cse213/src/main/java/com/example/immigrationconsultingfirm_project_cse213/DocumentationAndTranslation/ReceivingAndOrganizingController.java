package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;

public class ReceivingAndOrganizingController {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordTF;
    @FXML
    private Label statusLabel;
    @FXML
    private Label titleLabel;

    @FXML
    private TableView<DocumentData> tableGoal1;
    @FXML
    private TableColumn<DocumentData, String> eventCol;
    @FXML
    private TableColumn<DocumentData, String> descCol;
    @FXML
    private TableColumn<DocumentData, String> typeCol;


    private boolean isLoggedIn = false;

    @FXML
    public void initialize() {


        statusLabel.setText("Status: Not Logged In");

        // Connect table columns with model
        eventCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getEvent()));

        descCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDescription()));

        typeCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getType()));

        // Add data (same as your image)
        tableGoal1.getItems().addAll(
                new DocumentData("event-1", "Access client case (login required)", "UIE"),
                new DocumentData("event-2", "View uploaded documents", "OP"),
                new DocumentData("event-3", "Download document (if exists)", "UIE"),
                new DocumentData("event-4", "Categorize (passport/certificate)", "UID"),
                new DocumentData("event-5", "Rename (avoid duplicate names)", "DP"),
                new DocumentData("event-6", "Update status to completed", "UID")
        );
    }


    @FXML
    public void handleLogin(ActionEvent actionEvent) {

        String user = usernameField.getText();
        String pass = passwordTF.getText();

        if(user.equals("admin") && pass.equals("123")) {
            isLoggedIn = true;
            statusLabel.setText("Access Granted");
        } else {
            isLoggedIn = false;
            statusLabel.setText("Access Denied");
        }
    }


    private boolean checkLogin() {
        if(!isLoggedIn) {
            statusLabel.setText("Please login first");
            return false;
        }
        return true;
    }


    @FXML
    public void handleView(ActionEvent actionEvent) {
        if(checkLogin()) {
            statusLabel.setText("Viewing documents...");
        }
    }


    @FXML
    public void handleDownload(ActionEvent actionEvent) {
        if(checkLogin()) {
            statusLabel.setText("Downloading document...");
        }
    }


    @FXML
    public void handleCategorize(ActionEvent actionEvent) {
        if(checkLogin()) {
            statusLabel.setText("Categorizing documents...");
        }
    }


    @FXML
    public void handleRename(ActionEvent actionEvent) {
        if(checkLogin()) {
            statusLabel.setText("Renaming document...");
        }
    }


    @FXML
    public void handleUpdate(ActionEvent actionEvent) {
        if(checkLogin()) {
            statusLabel.setText("Status Updated to Completed");
        }
    }
}