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
import javafx.stage.Stage;

import java.io.IOException;

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
    private TableColumn<SteadyCashFlowOptimization,String> nameTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/financeOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Steady Cash Flow");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}