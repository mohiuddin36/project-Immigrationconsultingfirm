package com.example.immigrationconsultingfirm_project_cse213.Documentation;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class DeleteClientController
{
    @javafx.fxml.FXML
    private TextField idTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void deleteClientOA(ActionEvent actionEvent) {
        String id = idTF.getText();


        if (id.isEmpty()) {
            System.out.println("Please enter ID!");
            return;
        }


        for (Client c : DataStore.clientList) {


            if (c.getId().equals(id)) {


                DataStore.clientList.remove(c);

                System.out.println("Client deleted successfully!");


                idTF.clear();

                return;
            }
        }


        System.out.println("Client not found!");
    }
}
