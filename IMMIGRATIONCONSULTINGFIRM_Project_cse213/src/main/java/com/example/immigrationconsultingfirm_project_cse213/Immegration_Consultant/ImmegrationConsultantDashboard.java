package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant;

import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ImmegrationConsultantDashboard
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void applicationsubmission(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/paymentBreakdown.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Payment Breakdown");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void documentsVerification(ActionEvent actionEvent) throws IOException  {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration/documentVerification-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Documents Verification");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void clientProfileButton(ActionEvent actionEvent) throws IOException  {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration/clientProfiles-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("client Profile");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void appoinmentScheduleButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration/appoinmentSchedule-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Appointment Schedule");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void updateMilestonesButton(ActionEvent actionEvent) throws IOException  {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration/milestoneUpdate.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Milestone Update");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void clientAssessmentButton(ActionEvent actionEvent) throws IOException  {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration/clientAssessment-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Client Assessment");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void generateBillingButton(ActionEvent actionEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration/adminResponsibilities-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Admin Responsibilities");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void communicationLogButton(ActionEvent actionEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration/clientCommunication-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Client communication");
        stage.setScene(scene);
        stage.show();
    }
}