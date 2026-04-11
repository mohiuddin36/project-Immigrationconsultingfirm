package com.example.immigrationconsultingfirm_project_cse213.SystemUser;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class DeleteUserController
{
    @javafx.fxml.FXML
    private TextField name;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void deleteUser(ActionEvent actionEvent) {
        for (int i = 0; i < DataStore.userList.size(); i++) {

            if (DataStore.userList.get(i).getName().equals(name.getText())) {

                DataStore.userList.remove(i);
                break;
            }
        }

        name.clear();
    }

}