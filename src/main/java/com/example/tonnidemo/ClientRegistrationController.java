package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientRegistrationController {

    @FXML private TextField nameField;
    @FXML private TextField birthField;
    @FXML private TextField addressField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;

    @FXML private TableView<Client> clientTable;

    @FXML private TableColumn<Client, String> colId;
    @FXML private TableColumn<Client, String> colName;
    @FXML private TableColumn<Client, String> colBirth;
    @FXML private TableColumn<Client, String> colPhone;
    @FXML private TableColumn<Client, String> colEmail;

    private ObservableList<Client> clientList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colId.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBirth.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        clientTable.setItems(clientList);
    }

    @FXML
    public void handleSave() {

        String name = nameField.getText();
        String birth = birthField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();

        if (name.isEmpty() || birth.isEmpty() || address.isEmpty()
                || phone.isEmpty() || email.isEmpty()) {

            showAlert("Error", "Fill all fields!");
            return;
        }

        String id = "C-" + (clientList.size() + 101);

        Client newClient = new Client(id, name, birth, address, phone, email);

        clientList.add(newClient);

        clearFields();

        showAlert("Success", "Client Registered!");
    }

    private void clearFields() {
        nameField.clear();
        birthField.clear();
        addressField.clear();
        phoneField.clear();
        emailField.clear();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("client_dashboard.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}