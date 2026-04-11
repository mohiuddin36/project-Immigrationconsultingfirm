package com.example.immigrationconsultingfirm_project_cse213.AppointmentCoordinator;

import com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel.Appointment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ViewDailySchedule
{
    @javafx.fxml.FXML
    private Button UpdateStatusButton;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> IDCol;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> ConsultantCol;
    @javafx.fxml.FXML
    private DatePicker TodayDatePicker;
    @javafx.fxml.FXML
    private TableView<Appointment> AppointmentTableView;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> NameCol;
    @javafx.fxml.FXML
    private Label messagelabe;
    private final ArrayList<Appointment> list = new ArrayList<>();
    @FXML
    public void initialize() {
        AppointmentTableView.getItems().setAll(
                new Appointment("1", "Rahim", "Consultant A", "2026-04-11"),
                new Appointment("2", "Karim", "Consultant B", "2026-04-11"),
                new Appointment("3", "Sadia", "Consultant C", "2026-04-12")
        );


        AppointmentTableView.getItems().setAll(list);

        IDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ConsultantCol.setCellValueFactory(new PropertyValueFactory<>("consultant"));

    }

    @javafx.fxml.FXML
    public void UpdateStatusButtonhandeler(ActionEvent actionEvent) {
        if (TodayDatePicker.getValue() == null) {
            messagelabe.setText("Select a date first!");
            return;
        }

        String selectedDate = TodayDatePicker.getValue().toString();

        // FILTER DATA (SCRATCHPAD LOGIC)
        ArrayList<Appointment> filteredList = new ArrayList<>();

        for (Appointment a : list) {
            if (a.getDate().equals(selectedDate)) {
                filteredList.add(a);
            }
        }

        // SHOW FILTERED RESULT
        AppointmentTableView.getItems().setAll(filteredList);

        if (filteredList.isEmpty()) {
            messagelabe.setText("No appointments found!");
        } else {
            messagelabe.setText("Schedule loaded!");
        }
    }
}

