package com.example.immigrationconsultingfirm_project_cse213.SystemUser;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;



public class UserController
{
    @javafx.fxml.FXML
    private TextField role;
    @javafx.fxml.FXML
    private TextField name;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void addUser(ActionEvent actionEvent) {
        String username = name.getText();
        String userRole = role.getText();


        User u = new User(username, userRole);


        DataStore.userList.add(u);


        name.clear();
        role.clear();

        System.out.println("User Added: " + username + " - " + userRole);
    }
}

