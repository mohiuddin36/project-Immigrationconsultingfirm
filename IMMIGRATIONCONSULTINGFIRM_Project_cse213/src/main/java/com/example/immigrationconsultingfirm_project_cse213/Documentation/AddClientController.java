package com.example.immigrationconsultingfirm_project_cse213.Documentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class AddClientController {

    @FXML private ComboBox<String> documenttypeTF;
    @FXML private TableView<Client> clientdataTable;
    @FXML private TableColumn<Client, String> nameTC;
    @FXML private TableColumn<Client, String> idTC;
    @FXML private TableColumn<Client, String> documentTypeTC;
    @FXML private TableColumn<Client, LocalDate> submissionDateTC;

    @FXML private TextField clientNameTF;
    @FXML private TextField clientIdTF;
    @FXML private DatePicker submissionDate;

    @FXML
    public void initialize() {


        documenttypeTF.getItems().addAll(
                "Passport", "Education", "Work", "Birth Certificate", "NID"
        );


        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        documentTypeTC.setCellValueFactory(new PropertyValueFactory<>("docType"));
        submissionDateTC.setCellValueFactory(new PropertyValueFactory<>("date"));


        clientdataTable.getItems().setAll(DataStore.clientList);
    }

    @FXML
    public void addDocumentOA(ActionEvent actionEvent) {


        String name = clientNameTF.getText();
        String id = clientIdTF.getText();
        String docType = documenttypeTF.getValue();
        LocalDate date = submissionDate.getValue();


        if (name.isEmpty() || id.isEmpty() || docType == null || date == null) {
            System.out.println("Error: Please fill all fields");
            return;
        }


        Client newClient = new Client(name, id, docType, date);


        DataStore.clientList.add(newClient);


        clientdataTable.getItems().add(newClient);


        clientNameTF.clear();
        clientIdTF.clear();
        documenttypeTF.setValue(null);
        submissionDate.setValue(null);

        System.out.println("Client added successfully!");
    }
}