package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;

import com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model.AppendableObjectOutputStream;
import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientFundConteol
{
    @javafx.fxml.FXML
    private TextField idTextfield;
    @javafx.fxml.FXML
    private DatePicker transactionDatePicker;
    @javafx.fxml.FXML
    private TextField nameTextfield;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/financeOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Finance officer Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (nameTextfield.getText().isBlank()) {
            errorAlert("Name field can't be blank!");
            return;
        }

        if (transactionDatePicker.getValue() == null) {
            errorAlert("Please select a record date!");
            return;
        }
        ClientFundConteol bd= new ClientFundConteol(
                //nameTextfield.getText(),
                //Integer.parseInt(idTextfield.getText()),
                //transactionDatePicker.getValue()
         );
        try {
            File file = new File("ClientFund.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(bd);
            oos.close();
            informationAlert("saved successfully!");

        } catch (Exception e) {
            errorAlert("Error saving data to file!");
        }

    }

    // Code for Alert
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

