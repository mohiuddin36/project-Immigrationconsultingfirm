package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class ClientApprovalController {

    @FXML private TableView<Client> clientTable;

    @FXML private TableColumn<Client, String> colClientId;
    @FXML private TableColumn<Client, String> colName;
    @FXML private TableColumn<Client, String> colBirthDate;
    @FXML private TableColumn<Client, String> colAddress;
    @FXML private TableColumn<Client, String> colPhone;
    @FXML private TableColumn<Client, String> colEmail;

    @FXML private Label messageLabel;

    private List<Client> clientList = new ArrayList<>();
    private ObservableList<Client> tableData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // ✅ MUST MATCH PROPERTY NAMES (GETTERS)
        colClientId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("clientId"));
        colName.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("name"));
        colBirthDate.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("birthDate"));
        colAddress.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("address"));
        colPhone.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("email"));

        // SAMPLE DATA
        clientList.add(new Client("C-101", "Rahim", "1999-01-10", "Dhaka", "01711111111", "rahim@gmail.com"));
        clientList.add(new Client("C-102", "Karim", "2000-05-22", "Chittagong", "01822222222", "karim@gmail.com"));

        loadTable();
    }

    private void loadTable() {
        tableData.clear();
        tableData.addAll(clientList);
        clientTable.setItems(tableData);
    }

    @FXML
    public void handleApprove() {

        Client selected = clientTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setText("Select a client first!");
            return;
        }

        messageLabel.setText("Approved: " + selected.getName());
    }

    @FXML
    public void handleReject() {

        Client selected = clientTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setText("Select a client first!");
            return;
        }

        clientList.remove(selected);
        loadTable();

        messageLabel.setText("Client Rejected!");
    }

    @FXML
    public void handleRefresh() {
        loadTable();
        messageLabel.setText("Refreshed!");
    }
}