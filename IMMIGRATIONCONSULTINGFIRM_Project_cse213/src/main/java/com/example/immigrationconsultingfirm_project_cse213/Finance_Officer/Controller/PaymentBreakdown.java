package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PaymentBreakdown
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField nameTaxtField;
    @javafx.fxml.FXML
    private TableColumn<PaymentBreakdown,String> applicationStreamTableView;
    @javafx.fxml.FXML
    private ComboBox<String> applicationStreamComboBox;
    @javafx.fxml.FXML
    private TableColumn<PaymentBreakdown,String> clientIdTableView;
    @javafx.fxml.FXML
    private TableView<String> tableView;
    @javafx.fxml.FXML
    private TableColumn<PaymentBreakdown,String> clientNameTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}