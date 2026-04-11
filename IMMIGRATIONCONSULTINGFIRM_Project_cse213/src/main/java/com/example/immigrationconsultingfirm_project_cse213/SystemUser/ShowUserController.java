package com.example.immigrationconsultingfirm_project_cse213.SystemUser;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ShowUserController
{
    @javafx.fxml.FXML
    private TableColumn <User, String>nameCol;
    @javafx.fxml.FXML
    private TableColumn <User, String>roleCol;
    @javafx.fxml.FXML
    private TableView <User> table;
    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));

    }

    @javafx.fxml.FXML
    public void showUsers(ActionEvent actionEvent) {
        table.getItems().clear();


        for (User u : DataStore.userList) {
            table.getItems().add(u);
        }

    }
}