package com.example.immigrationconsultingfirm_project_cse213.Client.controllers;

import com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes.Appointment;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class AppointmentController {

    @FXML private ComboBox<String> ServiceTypeComboBox;
    @FXML private ComboBox<String> TimeSlotComboBox;
    @FXML private DatePicker AppointmentDatePicker;

    @FXML private TableView<Appointment> BookAppointmentTableView;
    @FXML private TableColumn<Appointment, String> ServiceTypeTableColumn;
    @FXML private TableColumn<Appointment, String> DateTableColumn;
    @FXML private TableColumn<Appointment, String> TimeTableColumn;
    @FXML private TableColumn<Appointment, String> StatusTableColumn;

    private ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        ServiceTypeComboBox.getItems().addAll(
                "Visa Consultation",
                "Work Permit",
                "Student Visa"
        );

        TimeSlotComboBox.getItems().addAll(
                "10:00 AM",
                "12:00 PM",
                "3:00 PM"
        );

        ServiceTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
        TimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        StatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        DateTableColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDate().toString())
        );

        BookAppointmentTableView.setItems(appointmentList);
    }

    @FXML
    public void BookAppointmentOnClickButton() {

        String service = ServiceTypeComboBox.getValue();
        String time = TimeSlotComboBox.getValue();
        LocalDate date = AppointmentDatePicker.getValue();

        // ERROR ALERT (validation)
        if (service == null || time == null || date == null) {
            showAlert("Error", "Please fill all fields!", Alert.AlertType.ERROR);
            return;
        }

        if (date.isBefore(LocalDate.now())) {
            showAlert("Error", "Invalid date selected!", Alert.AlertType.ERROR);
            return;
        }

        Appointment appointment = new Appointment(service, date, time, "Pending");

        appointmentList.add(appointment);

        showAlert("Success", "Appointment Booked Successfully!", Alert.AlertType.INFORMATION);

        ServiceTypeComboBox.setValue(null);
        TimeSlotComboBox.setValue(null);
        AppointmentDatePicker.setValue(null);
    }

    // ALERT METHOD
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}