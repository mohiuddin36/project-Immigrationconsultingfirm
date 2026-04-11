package com.example.immigrationconsultingfirm_project_cse213.Support_Staff.Controllers;

import com.example.immigrationconsultingfirm_project_cse213.Support_Staff.ModelClasses.StaffAppointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class StaffAppointmentController {

    @FXML private TableColumn<StaffAppointment, String> StaffIdColumn;
    @FXML private TableColumn<StaffAppointment, String> StatusColumn;
    @FXML private TableColumn<StaffAppointment, String> AppointmentIdColumn;
    @FXML private TableColumn<StaffAppointment, String> ClientNameColumn;
    @FXML private TableColumn<StaffAppointment, LocalDate> AppointmentDateColumn;
    @FXML private DatePicker AppointmentDatePicker;
    @FXML private TextField StaffIdTextField;
    @FXML private TextField ClientNameTextField;
    @FXML private TableView<StaffAppointment> AppointmentTableView;
    @FXML private Label messageLabel;
    @FXML private ComboBox<String> StatusComboBox;

    private ObservableList<StaffAppointment> appointmentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind columns using PropertyValueFactory
        AppointmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        StaffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        ClientNameColumn.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        AppointmentDateColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        AppointmentTableView.setItems(appointmentList);

        // Status options
        StatusComboBox.getItems().addAll("Scheduled", "Completed", "Cancelled");

        // Demo record
        appointmentList.add(new StaffAppointment("A001", "S001", "John Doe", LocalDate.now(), "Scheduled"));
    }

    @FXML
    public void AddAppointmentButton(ActionEvent actionEvent) {
        String staffId = StaffIdTextField.getText();
        String clientName = ClientNameTextField.getText();
        LocalDate date = AppointmentDatePicker.getValue();
        String status = StatusComboBox.getValue();

        if (staffId.isEmpty() || clientName.isEmpty() || date == null || status == null) {
            messageLabel.setText("⚠️ All fields must be filled!");
            messageLabel.setStyle("-fx-text-fill: red;");
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill all fields before adding an appointment.");
            return;
        }

        String appointmentId = "A" + (appointmentList.size() + 1);
        StaffAppointment appointment = new StaffAppointment(appointmentId, staffId, clientName, date, status);
        appointmentList.add(appointment);

        messageLabel.setText("Appointment Added Successfully!");
        messageLabel.setStyle("-fx-text-fill: green;");
        showAlert(Alert.AlertType.INFORMATION, "Appointment Added", "Appointment for " + clientName + " scheduled.");
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
