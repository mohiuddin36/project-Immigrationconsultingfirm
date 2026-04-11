package com.example.immigrationconsultingfirm_project_cse213.AppointmentCoordinator;

import com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes.Appointment;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ScheduleNewAppointment
{
    @javafx.fxml.FXML
    private Button saveAppointmentBtn;
    @javafx.fxml.FXML
    private Button checkAvailabilityBtn;
    @javafx.fxml.FXML
    private Button cancelBtn;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private ComboBox<String> clientCombo;
    @javafx.fxml.FXML
    private ComboBox<String> consultantCombo;
    @javafx.fxml.FXML
    private Label messagelabel;
    private ArrayList<Appointment> appointmentList = new ArrayList<>();
    private java.awt.Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
        clientCombo.getItems().add("Client A");
        clientCombo.getItems().add("Client B");

        consultantCombo.getItems().add("Consultant X");
        consultantCombo.getItems().add("Consultant Y");


        appointmentList.add(new Appointment("Client A", "Consultant X", LocalDate.now()));

    }
    private boolean isValid() {

        if(clientCombo.getValue() == null)
            return false;

        if(consultantCombo.getValue() == null)
            return false;

        if(datePicker.getValue() == null)
            return false;

        return true;
    }


    @javafx.fxml.FXML
    public void handleCancel(ActionEvent actionEvent) {
        clientCombo.setValue(null);
        consultantCombo.setValue(null);
        datePicker.setValue(null);

        messageLabel.setText("Form cleared");

    }

    @javafx.fxml.FXML
    public void handleCheckAvailability(ActionEvent actionEvent) {
        if(isValid()){

            boolean isAvailable = true;

            for(Appointment a : appointmentList){

                if(a.getConsultant().equals(consultantCombo.getValue())
                        && a.getDate().equals(datePicker.getValue())){

                    isAvailable = false;
                    break;
                }
            }

            if(isAvailable)
                messageLabel.setText("Available");
            else
                messageLabel.setText("Not Available");
        }
        else{
            messageLabel.setText("Invalid input");
        }

    }

    @javafx.fxml.FXML
    public void handleSaveAppointment(ActionEvent actionEvent) {
        if(isValid()){

            Appointment obj = new Appointment(
                    clientCombo.getValue(),
                    consultantCombo.getValue(),
                    datePicker.getValue()
            );

            appointmentList.add(obj);

            messageLabel.setText("Appointment Saved!");
        }
        else{
            messageLabel.setText("Invalid input!");
        }
    }

}


