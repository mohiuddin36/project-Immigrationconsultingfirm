package com.example.immigrationconsultingfirm_project_cse213.Documentation;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CountByTypeController
{
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private ComboBox typeCombo;
    @javafx.fxml.FXML
    private TableView table;

    @javafx.fxml.FXML
    public void initialize() {
        typeCombo.getItems().addAll("Passport", "Visa", "Work","Birth Certificate","NID");
    }

    @javafx.fxml.FXML
    public void countOA(ActionEvent actionEvent) {
        String type = typeCombo.getValue();

        if (type == null) {
            System.out.println("Select a type!");
            return;
        }

        int count = 0;

        for (Client c : DataStore.clientList) {

            if (c.getDocType().equals(type)) {
                count++;
            }
        }


        System.out.println("Total " + type + ": " + count);
    }
}
