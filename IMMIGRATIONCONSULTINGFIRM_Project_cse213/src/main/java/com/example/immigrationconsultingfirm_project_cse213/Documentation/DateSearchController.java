package com.example.immigrationconsultingfirm_project_cse213.Documentation;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class DateSearchController
{
    @javafx.fxml.FXML
    private TableColumn <Client, String>docTC;
    @javafx.fxml.FXML
    private TableColumn<Client, String> nameTC;
    @javafx.fxml.FXML
    private DatePicker  datePicker;
    @javafx.fxml.FXML
    private TableColumn <Client, String> idTC;
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
    }



    @javafx.fxml.FXML
    public void searchOA(ActionEvent actionEvent) {
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        docTC.setCellValueFactory(new PropertyValueFactory<>("docType"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

}
