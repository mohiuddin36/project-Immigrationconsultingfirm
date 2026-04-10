package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;

import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration Consultant/immegrationConsultantDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Client Profile");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}