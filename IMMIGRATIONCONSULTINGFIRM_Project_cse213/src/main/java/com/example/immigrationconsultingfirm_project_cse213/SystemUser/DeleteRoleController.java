package com.example.immigrationconsultingfirm_project_cse213.SystemUser;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class DeleteRoleController
{
    @javafx.fxml.FXML
    private TextField roleName;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void deleteRole(ActionEvent actionEvent) {
        for (int i = 0; i < DataStore.roleList.size(); i++) {

            if (DataStore.roleList.get(i).getRoleName().equals(roleName.getText())) {

                DataStore.roleList.remove(i);
                break;
            }
        }

        roleName.clear();

    }
}