package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdminResponsibilities
{
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TableColumn<AdminResponsibilities,Integer> passwordTableView;
    @javafx.fxml.FXML
    private TableColumn<AdminResponsibilities,Integer> clientIdTableView;
    @javafx.fxml.FXML
    private TextField clientIdTextField;
    @javafx.fxml.FXML
    private TextField feesTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField discountTextField;
    @javafx.fxml.FXML
    private TableView<String> tableView;
    @javafx.fxml.FXML
    private TableColumn<AdminResponsibilities,Integer> feesTableView;
    @javafx.fxml.FXML
    private TableColumn<AdminResponsibilities,String> clientNameTableView;
    @javafx.fxml.FXML
    private TableColumn<AdminResponsibilities,String> discountTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}