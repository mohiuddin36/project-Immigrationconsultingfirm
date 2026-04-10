package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;

import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class VisaRuleCheck
{
    @javafx.fxml.FXML
    private TextField refundIdTextField;
    @javafx.fxml.FXML
    private TextField applicationIdTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/financeOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Visa Rule Check");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}