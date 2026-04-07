package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;
//import com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.PaymentRecord;
import com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.AppendableObjectOutputStream;
import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model.ClientProfiles;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientProfilesController
{
    @javafx.fxml.FXML
    private TextField passportTextfield;
    @javafx.fxml.FXML
    private TextField nationalityTextfield;
    @javafx.fxml.FXML
    private TextField addressTextfield;
    @javafx.fxml.FXML
    private TextField contactTextfield;
    @javafx.fxml.FXML
    private TextField mailTextfield;
    @javafx.fxml.FXML
    private TextField nameTextfield;


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

        ClientProfiles cp = new ClientProfiles(
                nameTextfield.getText(),
                mailTextfield.getText(),
                addressTextfield.getText(),
                nationalityTextfield.getText(),
                Integer.parseInt(passportTextfield.getText()),
                Integer.parseInt(contactTextfield.getText())
        );
        try {
            File file = new File("ClientProfile.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(cp);
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