package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;

import com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model.AppendableObjectOutputStream;
import com.example.immigrationconsultingfirm_project_cse213.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class AdminResponsibilities
{
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TableColumn<AdminResponsibilities,Integer> passwordTableView;
    @javafx.fxml.FXML
    private TableColumn<AdminResponsibilities,Integer> clientIdTableView;
    @javafx.fxml.FXML
    private TextField clientIdTextField;
    @javafx.fxml.FXML
    private TextField feesTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField discountTextField;
    @javafx.fxml.FXML
    private TableView<String> tableView;
    @javafx.fxml.FXML
    private TableColumn<AdminResponsibilities,Integer> feesTableView;
    @javafx.fxml.FXML
    private TableColumn<AdminResponsibilities,String> clientNameTableView;
    @javafx.fxml.FXML
    private TableColumn<AdminResponsibilities,String> discountTableView;

    @javafx.fxml.FXML
    public void initialize() {
        clientNameTableView.setCellValueFactory(new PropertyValueFactory<>("name"));
        clientIdTableView.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        feesTableView.setCellValueFactory(new PropertyValueFactory<>("fees"));
        discountTableView.setCellValueFactory(new PropertyValueFactory<>("discount"));
        passwordTableView.setCellValueFactory(new PropertyValueFactory<>("password"));

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Immegration Consultant/immegrationConsultantDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Immigration Consultant Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        AdminResponsibilities ar = new AdminResponsibilities(
                //clientIdTextField.getText(),
                //nameTextField.getText(),
                //passwordTextField.getText(),
                //feesTextFieldText.getText(),
                //Integer.parseInt(passportTextField.getText()),
                //Integer.parseInt(contactTextField.getText())
        );
        try {
            File file = new File("AdminResponsibilities.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(ar);
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