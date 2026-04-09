package com.example.immigrationconsultingfirm_project_cse213.Client.controllers;

import com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes.Appointment;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.UUID;

public class AppointmentController {

    @FXML private ComboBox<String> TimeSlotComboBox;
    @FXML private ComboBox<String> ServiceTypeComboBox;
    @FXML private Label MessageLabel;
    @FXML private DatePicker AppointmentDatePicker;

    @FXML private TableColumn<Appointment,String> ServiceTypeTableColumn;
    @FXML private TableColumn<Appointment,String> DateTableColumn;
    @FXML private TableColumn<Appointment,String> TimeTableColumn;
    @FXML private TableColumn<Appointment,String> StatusTableColumn;
    @FXML private TableView<Appointment> BookAppointmentTableView;

    // ✅ Missing piece: ObservableList
    private ObservableList<Appointment> appointments = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        ServiceTypeComboBox.getItems().addAll("Visa Consultation", "Work Permit", "Student Visa", "PR Consultation");
        TimeSlotComboBox.getItems().addAll("09:00", "11:00", "14:00", "16:00");

        // Bind columns
        ServiceTypeTableColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getServiceType()));
        DateTableColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDate().toString()));
        TimeTableColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTime()));
        StatusTableColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getStatus()));

        BookAppointmentTableView.setItems(appointments);
    }

    @FXML
    public void BookAppointmentOnClickButton(ActionEvent actionEvent) {
        String serviceType = ServiceTypeComboBox.getValue();
        String timeSlot = TimeSlotComboBox.getValue();
        LocalDate date = AppointmentDatePicker.getValue();

        if (date == null || serviceType == null || timeSlot == null) {
            MessageLabel.setText("Please fill all fields.");
        } else {
            String appointmentId = UUID.randomUUID().toString();
            Appointment newAppointment = new Appointment(appointmentId, serviceType, date, timeSlot, "Pending");
            appointments.add(newAppointment);
            MessageLabel.setText("Appointment booked successfully!");
        }
    }
}
