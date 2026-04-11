package com.example.immigrationconsultingfirm_project_cse213.Documentation;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class SearchClientController
{
    @javafx.fxml.FXML
    private TableColumn <Client,String> nameTC;
    @javafx.fxml.FXML
    private TextField searchIdTF;
    @javafx.fxml.FXML
    private TableColumn <Client,String>docTypeTC;
    @javafx.fxml.FXML
    private TableColumn <Client,String>idTC;
    @javafx.fxml.FXML
    private TableColumn <Client,LocalDate>dateTC;
    @javafx.fxml.FXML
    private TableView <Client>searchTable;

    @javafx.fxml.FXML
    public void initialize() {
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        docTypeTC.setCellValueFactory(new PropertyValueFactory<>("docType"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    @javafx.fxml.FXML
    public void searchClientOA(ActionEvent actionEvent) {
        String id = searchIdTF.getText();

        // clear previous result
        searchTable.getItems().clear();

        // validation
        if (id == null || id.isEmpty()) {
            System.out.println("Please enter Client ID!");
            return;
        }

        boolean found = false;

        // search in shared list
        for (Client c : DataStore.clientList) {

            if (c.getId().equals(id)) {

                searchTable.getItems().add(c);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Client not found!");
        }
    }

}