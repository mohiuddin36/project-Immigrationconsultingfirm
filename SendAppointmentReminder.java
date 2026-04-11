package com.example.immigrationconsultingfirm_project_cse213.AppointmentCoordinator;

import com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel.Appointment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.crypto.dsig.TransformService;
import java.util.ArrayList;

public class SendAppointmentReminder
{
    @javafx.fxml.FXML
    private TableColumn IDCol;
    @javafx.fxml.FXML
    private TableView AppointmentTableview;
    @javafx.fxml.FXML
    private TableColumn DateCol;
    @javafx.fxml.FXML
    private TableColumn NameCol;
    @javafx.fxml.FXML
    private Button ReminderButton;
    private final ArrayList<Appointment> list = new ArrayList<>();
    private TransformService.MechanismMapEntry TodayDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
        list.add(new Appointment("1", "Rahim", "2026-04-11"));
        list.add(new Appointment("2", "Karim", "2026-04-11"));
        list.add(new Appointment("3", "Sadia", "2026-04-12"));

        AppointmentTableview.getItems().setAll(list);

        IDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @FXML
    public void handleSendReminder(ActionEvent actionEvent) {
        Appointment selected = (Appointment) AppointmentTableview.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Please select an appointment!");
            return;
        }

        if (TodayDatePicker.getValue() == null) {
            showAlert("Please select today's date!");
            return;
        }
        showAlert("Reminder Sent!\n\nTo: " + selected.getName() + "\nDate: " + selected.getDate());

    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String msg;
        alert.setContentText(msg);
        alert.showAndWait();
    }
}