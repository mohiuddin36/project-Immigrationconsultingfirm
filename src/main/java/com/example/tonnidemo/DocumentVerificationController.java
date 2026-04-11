package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class DocumentVerificationController {

    @FXML
    private TableView<Document> documentTable;

    @FXML
    private TableColumn<Document, String> colDocId;

    @FXML
    private TableColumn<Document, String> colClient;

    @FXML
    private TableColumn<Document, String> colType;

    @FXML
    private TableColumn<Document, String> colStatus;

    @FXML
    private Label messageLabel;

    private List<Document> documentList = new ArrayList<>();
    private ObservableList<Document> tableData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colDocId.setCellValueFactory(new PropertyValueFactory<>("docId"));
        colClient.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        colType.setCellValueFactory(new PropertyValueFactory<>("docType"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        documentList.add(new Document("D-101", "Rahim", "Passport", "Pending"));
        documentList.add(new Document("D-102", "Karim", "Photo", "Pending"));

        loadTable();
    }

    private void loadTable() {
        tableData.clear();
        tableData.addAll(documentList);
        documentTable.setItems(tableData);
    }

    @FXML
    public void handleVerify() {

        Document selected = documentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showMsg("Select a document!");
            return;
        }

        selected.setStatus("Verified");
        loadTable();

        messageLabel.setText("Document Verified!");
    }

    @FXML
    public void handleReject() {

        Document selected = documentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showMsg("Select a document!");
            return;
        }

        selected.setStatus("Rejected");
        loadTable();

        messageLabel.setText("Document Rejected!");
    }

    @FXML
    public void handleRefresh() {
        loadTable();
        messageLabel.setText("Refreshed!");
    }

    private void showMsg(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}