package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;

import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FinanceOfficerDashboard
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void recordClientPaymentButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/clientPaymentRecord.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Pay Event Bill");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void budgetMonitorButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void cashFlowSteadyButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void monthlyFinancialReportButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void paymentBreakdownButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void cashRequirementForecastButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void visaRuleCheckButton(ActionEvent actionEvent) {
    }
}