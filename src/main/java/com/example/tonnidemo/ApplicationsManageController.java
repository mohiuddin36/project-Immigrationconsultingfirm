package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ApplicationsManageController {

    @FXML
    private TableView<Application> applicationTable;

    @FXML
    private TableColumn<Application, String> colAppId;

    @FXML
    private TableColumn<Application, String> colClientName;

    @FXML
    private TableColumn<Application, String> colVisaType;

    @FXML
    private TableColumn<Application, String> colCountry;

    @FXML
    private TableColumn<Application, String> colDate;

    @FXML
    private TableColumn<Application, String> colStatus;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private TextField officerField;

    @FXML
    private Label detailLabel;

    private List<Application> applicationList = new ArrayList<>();
    private ObservableList<Application> tableData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colAppId.setCellValueFactory(new PropertyValueFactory<>("appId"));
        colClientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        colVisaType.setCellValueFactory(new PropertyValueFactory<>("visaType"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        statusComboBox.setItems(FXCollections.observableArrayList(
                "Pending", "Approved", "Rejected", "In Progress"
        ));

        // SAMPLE DATA (FIXED ORDER)
        applicationList.add(new Application("A-101", "Rahim", "Visa", "Bangladesh", "2026-04-10", "Morning", "Pending"));
        applicationList.add(new Application("A-102", "Karim", "Study Visa", "Canada", "2026-04-11", "Evening", "Pending"));

        loadTable();

        applicationTable.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> showDetails(newVal)
        );
    }

    private void loadTable() {
        tableData.clear();
        tableData.addAll(applicationList);
        applicationTable.setItems(tableData);
    }

    @FXML
    public void handleUpdate(ActionEvent actionEvent) {

        Application selected = applicationTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select an application!");
            return;
        }

        String status = statusComboBox.getValue();
        String officer = officerField.getText();

        if (status == null || status.isEmpty()) {
            showAlert("Error", "Select status!");
            return;
        }

        selected.setStatus(status);
        selected.setOfficer(officer);

        loadTable();

        showAlert("Success", "Application updated!");
    }

    @FXML
    public void handleViewDetails(ActionEvent actionEvent) {
        Application selected = applicationTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select an application!");
            return;
        }

        showDetails(selected);
    }

    private void showDetails(Application app) {
        if (app != null) {
            detailLabel.setText(
                    "ID: " + app.getAppId() +
                            "\nClient: " + app.getClientName() +
                            "\nVisa: " + app.getVisaType() +
                            "\nCountry: " + app.getCountry() +
                            "\nDate: " + app.getDate() +
                            "\nStatus: " + app.getStatus() +
                            "\nOfficer: " + app.getOfficer()
            );
        }
    }

    @FXML
    public void handleRefresh(ActionEvent actionEvent) {
        loadTable();
        showAlert("Info", "Refreshed!");
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}