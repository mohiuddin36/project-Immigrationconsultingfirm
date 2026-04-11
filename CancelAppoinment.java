package com.example.immigrationconsultingfirm_project_cse213.AppointmentCoordinator;

import com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel.Appointment;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class CancelAppoinment
{
    @javafx.fxml.FXML
    private TextArea CancelreasonTextArea;
    @javafx.fxml.FXML
    private Button ConfirmCancelletion;
    @javafx.fxml.FXML
    private Button CancelSelectedButton;
    @javafx.fxml.FXML
    private Label mrssagelabel;
    @javafx.fxml.FXML
    private TableView clientinformationTableView;
    @javafx.fxml.FXML
    private TableColumn DateCol;
    @javafx.fxml.FXML
    private TableColumn Namecol;
    @javafx.fxml.FXML
    private TableColumn ColID;

    ArrayList<Appointment> appointmentList = new ArrayList<>();
    Appointment selectedAppointment;

    @javafx.fxml.FXML
    public void initialize() {
        ColID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        appointmentList.add(new Appointment(1, "Samin", LocalDate.now()));
        appointmentList.add(new Appointment(2, "Uzair", LocalDate.now().plusDays(1)));

        clientinformationTableView.getItems().addAll(appointmentList);
    }

    @javafx.fxml.FXML
    public void appointmentTable(Event event) {
        selectedAppointment =
                (Appointment) clientinformationTableView.getSelectionModel().getSelectedItem();
    }



    @javafx.fxml.FXML
    public void handleCancelSelectedButton(ActionEvent actionEvent) {
        if (selectedAppointment == null) {
            mrssagelabel.setText("Select an appointment first");
            return;
        }

        CancelreasonTextArea.clear();
        mrssagelabel.setText("Enter cancellation reason");
    }

    @javafx.fxml.FXML
    public void handleconfirmcancellation(ActionEvent actionEvent) {
        if (!isValid()) {
            mrssagelabel.setText("Invalid cancellation request");
            return;
        }

        appointmentList.remove(selectedAppointment);

        clientinformationTableView.getItems().clear();
        clientinformationTableView.getItems().addAll(appointmentList);

        selectedAppointment = null;
        CancelreasonTextArea.clear();

        mrssagelabel.setText("Appointment Cancelled Successfully");
    }

    private boolean isValid() {
        if (selectedAppointment == null)
            return false;

        if (CancelreasonTextArea.getText() == null ||
                CancelreasonTextArea.getText().isEmpty())
            return false;

        return true;
    }

}
