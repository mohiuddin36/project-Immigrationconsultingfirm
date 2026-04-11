package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentController {

    @FXML private RadioButton morningRadio;
    @FXML private RadioButton eveningRadio;

    @FXML private TableView<Appointment> appointmentTable;

    @FXML private TableColumn<Appointment, String> nameCol;
    @FXML private TableColumn<Appointment, String> visaCol;
    @FXML private TableColumn<Appointment, String> dateCol;

    @FXML private ComboBox<String> visaTypeBox;
    @FXML private ComboBox<String> countryBox;
    @FXML private TextField nameField;
    @FXML private TextField dateField;
    @FXML private TextArea noteArea;

    private List<Appointment> appointmentList = new ArrayList<>();
    private ObservableList<Appointment> tableData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        visaTypeBox.setItems(FXCollections.observableArrayList(
                "Student Visa", "Work Visa", "Tourist Visa", "PR Visa"
        ));

        countryBox.setItems(FXCollections.observableArrayList(
                "Bangladesh", "Canada", "UK", "USA", "Australia"
        ));

        ToggleGroup group = new ToggleGroup();
        morningRadio.setToggleGroup(group);
        eveningRadio.setToggleGroup(group);

        // 🔥 IMPORTANT FIX (TABLE LINK)
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        visaCol.setCellValueFactory(new PropertyValueFactory<>("visaType"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        appointmentList.add(new Appointment("AP-101", "Rahim", "Student Visa", "Canada", "2026-04-10", "Morning", "Pending"));
        appointmentList.add(new Appointment("AP-102", "Karim", "Work Visa", "UK", "2026-04-11", "Evening", "Pending"));

        loadTable();
    }

    @FXML
    public void handleBook(ActionEvent event) {

        String name = nameField.getText();
        String visa = visaTypeBox.getValue();
        String country = countryBox.getValue();
        String date = dateField.getText();

        String timeSlot = null;
        if (morningRadio.isSelected()) timeSlot = "Morning";
        else if (eveningRadio.isSelected()) timeSlot = "Evening";

        if (name.isEmpty() || visa == null || country == null || date.isEmpty() || timeSlot == null) {
            showAlert("Error", "Please fill all fields!");
            return;
        }

        Appointment ap = new Appointment(
                "AP-" + (appointmentList.size() + 101),
                name,
                visa,
                country,
                date,
                timeSlot,
                "Pending"
        );

        appointmentList.add(ap);
        loadTable();
        clearFields();

        showAlert("Success", "Appointment Booked!");
    }

    private void loadTable() {
        tableData.clear();
        tableData.addAll(appointmentList);
        appointmentTable.setItems(tableData);
    }

    private void clearFields() {
        nameField.clear();
        dateField.clear();
        noteArea.clear();
        visaTypeBox.getSelectionModel().clearSelection();
        countryBox.getSelectionModel().clearSelection();
        morningRadio.setSelected(false);
        eveningRadio.setSelected(false);
    }

    // 🔥 BACK TO DASHBOARD (FIX)
    @FXML
    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("client_dashboard.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}