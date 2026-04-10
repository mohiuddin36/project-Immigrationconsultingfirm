package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;

import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentBreakdown
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField nameTaxtField;
    @javafx.fxml.FXML
    private ComboBox<String> applicationStreamComboBox;
    @javafx.fxml.FXML
    private TableView<String> tableView;
    @javafx.fxml.FXML
    private TableColumn<PaymentBreakdown,String> applicationStreamTableColumn;
    @javafx.fxml.FXML
    private TableColumn<PaymentBreakdown,Integer> clientIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<PaymentBreakdown,String> clientNameTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        applicationStreamComboBox.getItems().addAll("Paid","Unpaid");
        clientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("clintId"));
        clientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        applicationStreamComboBox.setCellFactory(new PropertyValueFactory<>("applicationStream"));

    }

    @javafx.fxml.FXML
    public void backbutton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/financeOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Payment BreakDown");
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}