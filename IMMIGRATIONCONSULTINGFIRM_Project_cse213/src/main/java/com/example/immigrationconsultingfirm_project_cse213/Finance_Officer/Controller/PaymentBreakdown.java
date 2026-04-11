package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;

import com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model.AppendableObjectOutputStream;
import com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.PaymentRecord;
import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PaymentBreakdown
{
    @javafx.fxml.FXML
    private TextField nameTaxtField;
    @javafx.fxml.FXML
    private ComboBox<String> applicationStreamComboBox;
    @javafx.fxml.FXML
    private TableView<String> tableView;
    @javafx.fxml.FXML
    private TableColumn<PaymentBreakdown,String> applicationStreamTableColumn;
    @javafx.fxml.FXML
    private TableColumn<PaymentBreakdown,Integer> clientIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<PaymentBreakdown,String> clientNameTableColumn;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private TextField nameTaxtField1;

    @javafx.fxml.FXML
    public void initialize() {
        applicationStreamComboBox.getItems().addAll("Paid","Unpaid");
        clientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("clintId"));
        clientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        applicationStreamTableColumn.setCellValueFactory(new PropertyValueFactory<>("applicationStream"));


    }

    @javafx.fxml.FXML
    public void backbutton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/financeOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Finance officer Dashboard");
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {

        PaymentBreakdown pb = new PaymentBreakdown(
               //Integer.parseInt(idTextfield.getText()),
                //applicationStreamComboBox.getValue(),
                //nameTextfield.getText(),
        );
        try {
            File file = new File("PaymentRecord.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(pb);
            oos.close();
            informationAlert("Payment saved successfully!");

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



