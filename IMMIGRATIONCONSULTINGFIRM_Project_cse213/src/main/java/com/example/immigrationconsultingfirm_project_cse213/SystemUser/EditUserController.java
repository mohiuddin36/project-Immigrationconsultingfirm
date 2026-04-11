package com.example.immigrationconsultingfirm_project_cse213.SystemUser;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class EditUserController
{
    @javafx.fxml.FXML
    private TextField newName;
    @javafx.fxml.FXML
    private TextField oldName;
    @javafx.fxml.FXML
    private TextField newRole;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void editUser(ActionEvent actionEvent) {
        for (User u : DataStore.userList) {

            if (u.getName().equals(oldName.getText())) {

                u.setName(newName.getText());
                u.setRole(newRole.getText());

                break;
            }
        }

        oldName.clear();
        newName.clear();
        newRole.clear();

    }
}