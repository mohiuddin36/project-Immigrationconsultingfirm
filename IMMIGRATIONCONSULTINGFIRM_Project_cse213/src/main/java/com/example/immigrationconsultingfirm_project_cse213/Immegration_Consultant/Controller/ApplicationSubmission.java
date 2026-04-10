package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;

import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ApplicationSubmission
{
    @javafx.fxml.FXML
    private DatePicker submissionDateDatePicker;
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private ComboBox<String> applicationTypeComboBox;
    @javafx.fxml.FXML
    private TextField nameTextField;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration Consultant/immegrationConsultantDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Application Submission");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        ApplicationData ad = new ApplicationData(
                nameTextField.getText(),
                passwordTextField.getText(),
                applicationTypeComboBox.getValue(),
                submissionDateDatePicker.getValue()
        );


        try {
            File file = new File("ApplicationSubmission.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(ad);
            oos.close();

            informationAlert("Application submitted successfully!");

        } catch (Exception e) {
            errorAlert("Error saving data!");
        }
        public void errorAlert(String s){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(s);
            a.showAndWait();
        }
        public void informationAlert(String s){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(s);
            a.showAndWait();
    }
    }
}