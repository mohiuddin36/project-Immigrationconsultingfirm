package com.example.immigrationconsultingfirm_project_cse213.SystemUser;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewRoleController
{
    @javafx.fxml.FXML
    private TableColumn <Role, String> accessCol;
    @javafx.fxml.FXML
    private TableColumn <Role, String> roleCol;
    @javafx.fxml.FXML
    private TableView <Role> table;

    @javafx.fxml.FXML
    public void initialize() {
        roleCol.setCellValueFactory(new PropertyValueFactory<>("roleName"));
        accessCol.setCellValueFactory(new PropertyValueFactory<>("accessLevel"));
    }

    @javafx.fxml.FXML
    public void loadRoles(ActionEvent actionEvent) {
        table.getItems().clear();

        for (Role r : DataStore.roleList) {
            table.getItems().add(r);
        }

    }
}