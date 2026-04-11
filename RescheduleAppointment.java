package com.example.immigrationconsultingfirm_project_cse213.AppointmentCoordinator;

import com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel.Appointment;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class RescheduleAppointment
{
    @javafx.fxml.FXML
    private TableColumn<Appointment,String> datecol;
    @javafx.fxml.FXML
    private TableColumn<Appointment,String> namecol;
    @javafx.fxml.FXML
    private TableView Appointmenttableview;
    @javafx.fxml.FXML
    private Button savebtn;
    @javafx.fxml.FXML
    private TableColumn<Appointment,String> IdCol;
    @javafx.fxml.FXML
    private DatePicker newdatepicker;
    @javafx.fxml.FXML
    private Label messagelabel;
    private final ArrayList<Appointment> list = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {

        list.add(new Appointment("1", "Rahim", "2026-04-10"));
        list.add(new Appointment("2", "Karim", "2026-04-11"));
        list.add(new Appointment("3", "Sadia", "2026-04-12"));


        Appointmenttableview.setItems(list);

        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void handleSaveChanges(ActionEvent actionEvent) {
        Appointment selected = (Appointment) Appointmenttableview.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messagelabel.setText("Please select an appointment!");
            return;
        }

        if (newdatepicker.getValue() == null) {
            messagelabel.setText("Please select new date!");
            return;
        }

        selected.setDate(newdatepicker.getValue().toString());

        Appointmenttableview.refresh();
        newdatepicker.setValue(null);

        messagelabel.setText("Appointment rescheduled successfully!");
    }
}