package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;

import com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model.AppendableObjectOutputStream;
import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.io.Serializable;


public class AppointmentSchedule implements Serializable {

    @javafx.fxml.FXML
    private ComboBox<String> appoinmentTypeComboBox;

    @javafx.fxml.FXML
    private TextField appoinmentTimeTextField;

    @javafx.fxml.FXML
    private DatePicker appoinmentDateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {

    }

    public AppointmentSchedule() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("Immigration_Consultant/immigrationConsultantDashboard.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Immigration Consultant Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {

        AppointmentSchedule as = new AppointmentSchedule();
                //nameTextfield.getText(),
               //passwordTextfield.getText(),
                //appoinmentTypeComboBox.getValue(),



        try {
            File file = new File("AppointmentSchedule.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(as);
            oos.close();

            informationAlert("Added successfully!");

        } catch (Exception e) {
            errorAlert("Error saving data to file!");
        }
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