package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SteadyCashFlowOptimization
{
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private ComboBox<String> paymentStatusComboBox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableColumn<SteadyCashFlowOptimization,String> paymentStatusTableView;
    @javafx.fxml.FXML
    private TableColumn<SteadyCashFlowOptimization,String> passwordTableView;
    @javafx.fxml.FXML
    private TableView<String> tableView;
    @javafx.fxml.FXML
    private TableColumn nameTableView;

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