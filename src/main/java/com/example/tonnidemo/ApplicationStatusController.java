package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationStatusController {

    @FXML private TableView<Application> applicationTable;

    @FXML private TableColumn<Application, String> colAppId;
    @FXML private TableColumn<Application, String> colClientName;
    @FXML private TableColumn<Application, String> colVisaType;
    @FXML private TableColumn<Application, String> colCountry;
    @FXML private TableColumn<Application, String> colDate;
    @FXML private TableColumn<Application, String> colStatus;

    @FXML private Label detailLabel;

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

        // FIXED DATA (NO ERROR)
        applicationList.add(new Application("A-201","Rahim","Visa","Bangladesh","2026-04-10","Morning","Pending"));
        applicationList.add(new Application("A-202","Karim","Study Visa","Canada","2026-04-11","Evening","Processing"));
        applicationList.add(new Application("A-203","Sumi","Work Visa","UK","2026-04-12","Morning","Approved"));

        loadTable();
    }

    private void loadTable() {
        tableData.setAll(applicationList);
        applicationTable.setItems(tableData);
    }

    @FXML
    public void handleViewDetails() {

        Application a = applicationTable.getSelectionModel().getSelectedItem();

        if (a == null) return;

        detailLabel.setText(
                "ID: " + a.getAppId() +
                        "\nName: " + a.getClientName() +
                        "\nVisa: " + a.getVisaType() +
                        "\nCountry: " + a.getCountry() +
                        "\nDate: " + a.getDate() +
                        "\nStatus: " + a.getStatus()
        );
    }

    @FXML
    public void handleRefresh() {
        loadTable();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("client_dashboard.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}