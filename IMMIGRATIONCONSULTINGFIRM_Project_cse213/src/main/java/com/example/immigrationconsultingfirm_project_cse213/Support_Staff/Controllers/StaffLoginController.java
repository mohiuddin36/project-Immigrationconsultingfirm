package com.example.immigrationconsultingfirm_project_cse213.Support_Staff.Controllers;

import com.example.immigrationconsultingfirm_project_cse213.Support_Staff.ModelClasses.StaffLogin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class StaffLoginController {

    @FXML private TableColumn<StaffLogin, String> StaffIdColumn;
    @FXML private TableColumn<StaffLogin, String> EmailColumn;
    @FXML private TableColumn<StaffLogin, Boolean> StatusColumn;

    @FXML private ComboBox<String> SearchTypeComboBox;
    @FXML private TableView<StaffLogin> StaffTableView;
    @FXML private PasswordField StaffPasswordField;
    @FXML private CheckBox CitationCheckBox;
    @FXML private TextField StaffEmailTextField;

    private ObservableList<StaffLogin> staffList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // ComboBox setup
        SearchTypeComboBox.getItems().addAll("By Email", "By ID");

        // Table binding
        StaffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("loginStatus"));

        StaffTableView.setItems(staffList);

        // Demo data
        StaffLogin demo = new StaffLogin("S001", "admin@firm.com", "12345");
        demo.setLoginStatus(false);
        staffList.add(demo);
    }

    // ✅ LOGIN BUTTON
    @FXML
    public void StaffLoginButton(ActionEvent actionEvent) {

        String email = StaffEmailTextField.getText();
        String password = StaffPasswordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Error", "Email & Password required!");
            return;
        }

        boolean found = false;

        for (StaffLogin s : staffList) {
            if (s.getEmail().equals(email) && s.getPassword().equals(password)) {
                s.setLoginStatus(true);
                found = true;

                showAlert(Alert.AlertType.INFORMATION,
                        "Login Success",
                        "Welcome " + email);
                break;
            }
        }

        if (!found) {
            showAlert(Alert.AlertType.ERROR,
                    "Login Failed",
                    "Invalid email or password");
        }

        StaffTableView.refresh();
    }

    // ✅ SEARCH BUTTON
    @FXML
    public void SearchButton(ActionEvent actionEvent) {

        String type = SearchTypeComboBox.getValue();

        if (type == null) {
            showAlert(Alert.AlertType.WARNING, "Error", "Select search type first");
            return;
        }

        boolean citationChecked = CitationCheckBox.isSelected();

        ObservableList<StaffLogin> results = FXCollections.observableArrayList();

        String input = StaffEmailTextField.getText();

        for (StaffLogin s : staffList) {

            if ("By Email".equals(type)) {
                if (s.getEmail().toLowerCase().contains(input.toLowerCase())) {
                    results.add(s);
                }
            }

            if ("By ID".equals(type)) {
                if (s.getStaffId().toLowerCase().contains(input.toLowerCase())) {
                    results.add(s);
                }
            }
        }

        StaffTableView.setItems(results);

        showAlert(Alert.AlertType.INFORMATION,
                "Search Complete",
                "Citation checked: " + citationChecked);
    }

    // ✅ ALERT METHOD
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}