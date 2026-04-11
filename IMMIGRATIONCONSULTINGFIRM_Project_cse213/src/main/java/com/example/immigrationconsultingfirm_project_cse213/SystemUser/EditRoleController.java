package com.example.immigrationconsultingfirm_project_cse213.SystemUser;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class EditRoleController
{
    @javafx.fxml.FXML
    private TextField newName;
    @javafx.fxml.FXML
    private TextField newAccess;
    @javafx.fxml.FXML
    private TextField oldName;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void editRole(ActionEvent actionEvent) {
        for (Role r : DataStore.roleList) {

            if (r.getRoleName().equals(oldName.getText())) {

                r.setRoleName(newName.getText());
                r.setAccessLevel(newAccess.getText());
                break;
            }
        }
    }
}