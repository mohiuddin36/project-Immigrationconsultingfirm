package com.example.immigrationconsultingfirm_project_cse213.Documentation;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ViewClientController
{
    @javafx.fxml.FXML
    private TableView <Client> clientTable;
    @javafx.fxml.FXML
    private TableColumn <Client, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn <Client,String> docTypeTC;
    @javafx.fxml.FXML
    private TableColumn <Client,String> idTC;
    @javafx.fxml.FXML
    private TableColumn <Client,LocalDate>dateTC;

    @javafx.fxml.FXML
    public void initialize() {
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        docTypeTC.setCellValueFactory(new PropertyValueFactory<>("docType"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void loadDataOA(ActionEvent actionEvent) {
        clientTable.getItems().clear();


        clientTable.getItems().addAll(DataStore.clientList);

        System.out.println("Data loaded (latest version)");
    }
}