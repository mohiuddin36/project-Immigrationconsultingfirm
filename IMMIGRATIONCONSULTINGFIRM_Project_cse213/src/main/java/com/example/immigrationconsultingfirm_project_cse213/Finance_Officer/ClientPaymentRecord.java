package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer;

import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientPaymentRecord
{
    @javafx.fxml.FXML
    private ComboBox<String> typeCombobox;
    @javafx.fxml.FXML
    private TextField amountTextfield;
    @javafx.fxml.FXML
    private TextField idTextfield;

    @javafx.fxml.FXML
    public void initialize() {
        typeCombobox.getItems().addAll("Retainer", "Gov Fee");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinanceOfficer/financeOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Pay Bill");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {

        // Bin file write code
        PaymentRecord pr = new PaymentRecord(
                Integer.parseInt(idTextfield.getText()),
                Integer.parseInt(amountTextfield.getText()),
                typeCombobox.getValue()
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
            oos.writeObject(pr);
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