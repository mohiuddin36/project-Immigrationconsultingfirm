package com.example.immigrationconsultingfirm_project_cse213.SystemUser;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class AddRoleController
{
    @javafx.fxml.FXML
    private TextField accessLevel;
    @javafx.fxml.FXML
    private TextField roleName;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addRole(ActionEvent actionEvent) {
        Role r = new Role(roleName.getText(), accessLevel.getText());
        DataStore.roleList.add(r);

        roleName.clear();
        accessLevel.clear();
    }
}