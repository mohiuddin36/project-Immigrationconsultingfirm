package com.example.immigrationconsultingfirm_project_cse213.AppointmentCoordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RescheduleAppointment
{
    @javafx.fxml.FXML
    private DatePicker nerwdatepicker;
    @javafx.fxml.FXML
    private TableColumn datecol;
    @javafx.fxml.FXML
    private TableColumn namecol;
    @javafx.fxml.FXML
    private TableView Appointmenttableview;
    @javafx.fxml.FXML
    private Button savebtn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSaveChanges(ActionEvent actionEvent) {
    }
}