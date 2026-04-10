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

public class SteadyCashFlowOptimization
{
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private ComboBox<String> paymentStatusComboBox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableColumn<SteadyCashFlowOptimization,String> paymentStatusTableView;
    @javafx.fxml.FXML
    private TableColumn<SteadyCashFlowOptimization,String> passwordTableView;
    @javafx.fxml.FXML
    private TableView<String> tableView;
    @javafx.fxml.FXML
    private TableColumn<SteadyCashFlowOptimization,String> nameTableView;

    @javafx.fxml.FXML
    public void initialize() {
        paymentStatusComboBox.getItems().addAll("Paid","unpaid");
        nameTableView.setCellValueFactory(new PropertyValueFactory<>("name"));
        passwordTableView.setCellValueFactory(new PropertyValueFactory<>("password"));
        paymentStatusTableView.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
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

        SteadyCashFlowOptimization sc = new SteadyCashFlowOptimization(

                //nameTextField.getText(),
                //passwordTextField.getText(),
                //paymentStatusComboBox.getValue()

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
            oos.writeObject(sc);
            oos.close();
            informationAlert("Case save successfully!");

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


