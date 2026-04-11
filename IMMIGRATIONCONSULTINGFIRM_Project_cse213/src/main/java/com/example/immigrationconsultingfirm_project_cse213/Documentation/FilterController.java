package com.example.immigrationconsultingfirm_project_cse213.Documentation;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FilterController
{
    @javafx.fxml.FXML
    private TableColumn<Client,String> docTC;
    @javafx.fxml.FXML
    private TableColumn <Client, String>nameTC;
    @javafx.fxml.FXML
    private TableColumn <Client, String> idTC;
    @javafx.fxml.FXML
    private ComboBox <String> typeCombo;
    @javafx.fxml.FXML
    private TableColumn <Client, LocalDate> dateTC;
    @javafx.fxml.FXML
    private TableView <Client> table;

    @javafx.fxml.FXML
    public void initialize() {
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        docTC.setCellValueFactory(new PropertyValueFactory<>("docType"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        // simple fixed values
        typeCombo.getItems().addAll("Passport", "Visa", "Work Permit");
    }



    @javafx.fxml.FXML
    public void filterOA(ActionEvent actionEvent) {
        String type = typeCombo.getValue();

        table.getItems().clear();

        if (type == null) {
            System.out.println("Select a document type!");
            return;
        }

        for (Client c : DataStore.clientList) {

            if (c.getDocType().equals(type)) {
                table.getItems().add(c);
            }
        }
    }
}
