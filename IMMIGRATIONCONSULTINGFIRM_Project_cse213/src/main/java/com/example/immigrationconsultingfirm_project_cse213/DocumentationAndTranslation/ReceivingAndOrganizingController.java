package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;

public class ReceivingAndOrganizingController {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private TextField searchField;

    @FXML private Label statusLabel;
    @FXML private Label titleLabel;

    @FXML private TableView<DocumentData> tableView;
    @FXML private TableColumn<DocumentData, String> fileNameColumn;
    @FXML private TableColumn<DocumentData, String> fileTypeColumn;

    private boolean isLoggedIn = false;

    private ObservableList<DocumentData> documents = FXCollections.observableArrayList();


    @FXML
    public void initialize() {

        statusLabel.setText("Status: Not Logged In");


        fileNameColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getFileName()));

        fileTypeColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getFileType()));
    }


    @FXML
    public void handleLogin(ActionEvent actionEvent) {

        String user = usernameField.getText();
        String pass = passwordField.getText();

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
    public void handleAccess(ActionEvent actionEvent) {

        if(isLoggedIn == true) {
            documents.clear();

            documents.add(new DocumentData("passport1", "passport"));
            documents.add(new DocumentData("certificate1", "certificate"));

            tableView.setItems(documents);

            statusLabel.setText("Client files loaded");
        } else {
            statusLabel.setText("Access Denied");
        }
    }


    @FXML
    public void handleView(ActionEvent actionEvent) {
        if(checkLogin()) {
            tableView.setItems(documents);
            statusLabel.setText("Viewing documents");
        }
    }


    @FXML
    public void handleDownload(ActionEvent actionEvent) {

        if(!checkLogin()) return;

        String search = searchField.getText();
        boolean found = false;

        for(DocumentData doc : documents) {
            if(doc.getFileName().equals(search)) {
                found = true;
                break;
            }
        }

        if(found == true) {
            statusLabel.setText("Download successful");
        } else {
            statusLabel.setText("Error: File not found");
        }
    }


    @FXML
    public void handleCategorize(ActionEvent actionEvent) {

        if(!checkLogin()) return;

        for(DocumentData doc : documents) {

            if(doc.getFileType().equals("passport")) {
                statusLabel.setText("Stored in passport folder");
            }
            else if(doc.getFileType().equals("certificate")) {
                statusLabel.setText("Stored in education folder");
            }
        }
    }


    @FXML
    public void handleRename(ActionEvent actionEvent) {

        if(!checkLogin()) return;

        for(int i = 0; i < documents.size(); i++) {
            DocumentData doc = documents.get(i);
            int count = 1;

            for(int j = 0; j < documents.size(); j++) {

                if(i != j &&
                        documents.get(j).getFileName().equals(doc.getFileName())) {

                    while(documents.get(j).getFileName().equals(doc.getFileName())) {
                        doc.setFileName(doc.getFileName() + count);
                        count++;
                    }
                }
            }
        }

        tableView.refresh();
        statusLabel.setText("Renaming completed");
    }


    @FXML
    public void handleUpdateStatus(ActionEvent actionEvent) {

        if(!checkLogin()) return;

        statusLabel.setText("Status: Completed");
    }
}
