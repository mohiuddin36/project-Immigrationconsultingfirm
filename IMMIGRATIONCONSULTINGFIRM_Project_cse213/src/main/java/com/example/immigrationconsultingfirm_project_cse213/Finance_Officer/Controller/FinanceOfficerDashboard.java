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
    public void budgetMonitorButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/budgetMonitor.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Budget Monitor");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void cashFlowSteadyButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/steadyCashFlowOptimization.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Cash flow Steady");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void monthlyFinancialReportButton(ActionEvent actionEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/monthlyFinanceReports.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Monthly Financial Report");
        stage.setScene(scene);
        stage.show();


    }

    @javafx.fxml.FXML
    public void paymentBreakdownButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/paymentBreakdown.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Payment Breakdown");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void cashRequirementForecastButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/cashForecast.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("cash Forecast");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void visaRuleCheckButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/visaRuleCheck.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("visa Rule Check");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void clintFundControlButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/clientFundControl.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Client Fund Control");
        stage.setScene(scene);
        stage.show();
    }
}