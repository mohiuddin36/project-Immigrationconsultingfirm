package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;

import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientAssessment
{
    @javafx.fxml.FXML
    private AnchorPane ieltsScores;
    @javafx.fxml.FXML
    private TextField ieltsScoreTextField;
    @javafx.fxml.FXML
    private TextField educationTextField;
    @javafx.fxml.FXML
    private TextField workExperienceTextfield;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration Consultant/immegrationConsultantDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Client Assessement");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}