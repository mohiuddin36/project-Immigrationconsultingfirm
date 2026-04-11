package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;

import com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model.AppendableObjectOutputStream;
import com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model.CashForecast;
import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class CashForecastController {

    @FXML
    private DatePicker applicationDeadlineTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField userNameTextField;

    @javafx.fxml.FXML
    public void initialize() {

    }
    @FXML
    public void backbutton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("FinanceOfficer/financeOfficerDashboard.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Finance Officer Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void saveButton(ActionEvent actionEvent) {

        String username = userNameTextField.getText();
        String password = passwordTextField.getText();
        LocalDate deadline = applicationDeadlineTextField.getValue();

        // Create Model object
        CashForecast cf = new CashForecast(username, password, deadline);

        try {
            File file = new File("CashForecast.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(cf);
            oos.close();

            informationAlert("Saved successfully!");

        } catch (Exception e) {
            errorAlert("Error saving data!");
        }
    }

    // ⚠️ Alerts
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

