package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;

import com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model.AppendableObjectOutputStream;
import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MonthlyFinancereports
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void monthTextField(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void feesTextField(ActionEvent actionEvent) {
    }
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/financeOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Finance officer Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    //@javafx.fxml.FXML
    //public void costTextField(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        MonthlyFinancereports bd= new MonthlyFinancereports(
                // Integer.parseInt(idTextField.getText()),
                //Integer.parseInt(amountTextField.getText()),
                //departmentTypeComboBox.getValue()
        );
        try {
            File file = new File("BudgetMonitor.bin");
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
            informationAlert("monthly statement Show successfully!");

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



