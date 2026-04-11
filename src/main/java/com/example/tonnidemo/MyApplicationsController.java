package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class MyApplicationsController {

    @FXML
    private TableView<Application> applicationTable;

    @FXML
    private TableColumn<Application, String> colId;

    @FXML
    private TableColumn<Application, String> colStatus;

    private List<Application> list = new ArrayList<>();
    private ObservableList<Application> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("appId"));
        colStatus.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("status"));

        list.add(new Application("A-1", "Rahim", "Visa", "Canada", "2026-04-10", "Morning", "Pending"));
        list.add(new Application("A-2", "Karim", "Study", "UK", "2026-04-11", "Evening", "Pending"));

        load();
    }

    private void load() {
        data.clear();
        data.addAll(list);
        applicationTable.setItems(data);
    }

    @FXML
    public void handleWithdraw() {
        Application selected = applicationTable.getSelectionModel().getSelectedItem();

        if (selected == null) return;

        list.remove(selected);
        load();
    }

    @FXML
    public void handleUpdate() {
        Application selected = applicationTable.getSelectionModel().getSelectedItem();

        if (selected != null) {
            selected.setStatus("Updated");
            load();
        }
    }
}