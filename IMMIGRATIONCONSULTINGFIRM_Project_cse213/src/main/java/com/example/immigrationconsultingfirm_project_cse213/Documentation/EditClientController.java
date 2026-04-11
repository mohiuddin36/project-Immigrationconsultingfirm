package com.example.immigrationconsultingfirm_project_cse213.Documentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;


public class EditClientController
{
    @FXML private TextField searchIdTF;
    @FXML private TextField nameTF;
    @FXML private ComboBox<String> docTypeCB;
    @FXML private DatePicker dateDP;

    private Client foundClient; // store selected client


    @FXML
    public void initialize() {


        docTypeCB.getItems().addAll(
                "Passport", "Education", "Work", "Birth Certificate", "NID"
        );
    }


    @FXML
    public void searchClientOA(ActionEvent event) {

        String id = searchIdTF.getText();


        for (Client c : DataStore.clientList) {

            if (c.getId().equals(id)) {

                foundClient = c; // save found client

                // show data in fields
                nameTF.setText(c.getName());
                docTypeCB.setValue(c.getDocType());
                dateDP.setValue(c.getDate());

                System.out.println("Client found!");
                return;
            }
        }

        System.out.println("Client not found!");
    }


    @FXML
    public void updateClientOA(ActionEvent event) {


        if (foundClient == null) {
            System.out.println("Please search first!");
            return;
        }


        String name = nameTF.getText();
        String docType = docTypeCB.getValue();
        LocalDate date = dateDP.getValue();


        if (name.isEmpty() || docType == null || date == null) {
            System.out.println("Fill all fields!");
            return;
        }


        foundClient.setName(name);
        foundClient.setDocType(docType);
        foundClient.setDate(date);

        System.out.println("Updated successfully!");
    }

}