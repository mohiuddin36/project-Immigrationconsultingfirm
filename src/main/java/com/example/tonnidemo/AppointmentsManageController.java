package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppointmentsManageController {

    @FXML private TableView<Appointment> appointmentTable;

    @FXML private TableColumn<Appointment, String> colAppointmentId;
    @FXML private TableColumn<Appointment, String> colName;
    @FXML private TableColumn<Appointment, String> colVisaType;
    @FXML private TableColumn<Appointment, String> colCountry;
    @FXML private TableColumn<Appointment, String> colDate;
    @FXML private TableColumn<Appointment, String> colStatus;

    @FXML private ComboBox<String> statusComboBox;
    @FXML private TextField officerField;
    @FXML private Label messageLabel;

    private ObservableList<Appointment> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // 🔥 TABLE COLUMN FIX
        colAppointmentId.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colVisaType.setCellValueFactory(new PropertyValueFactory<>("visaType"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        // 🔥 COMBOBOX FIX (THIS WAS YOUR ISSUE)
        statusComboBox.setItems(FXCollections.observableArrayList(
                "Pending",
                "Approved",
                "Rejected",
                "In Progress"
        ));

        // 🔥 TABLE DATA FIX (THIS WAS ALSO YOUR ISSUE)
        data.addAll(
                new Appointment("A-101", "Rahim", "Visa", "Bangladesh", "2026-04-10", "Morning", "Pending"),
                new Appointment("A-102", "Karim", "Study Visa", "Canada", "2026-04-11", "Evening", "Pending")
        );

        appointmentTable.setItems(data);

        // 🔥 ROW CLICK EVENT
        appointmentTable.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> showDetails(newVal)
        );
    }

    // ---------------- VIEW ----------------
    @FXML
    public void handleView(ActionEvent event) {
        showDetails(appointmentTable.getSelectionModel().getSelectedItem());
    }

    // ---------------- UPDATE ----------------
    @FXML
    public void handleUpdate(ActionEvent event) {

        Appointment selected = appointmentTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setText("Select appointment!");
            return;
        }

        selected.setStatus(statusComboBox.getValue());
        selected.setOfficer(officerField.getText());

        appointmentTable.refresh();
        messageLabel.setText("Updated successfully!");
    }

    // ---------------- REFRESH ----------------
    @FXML
    public void handleRefresh(ActionEvent event) {
        appointmentTable.refresh();
    }

    // ---------------- BACK BUTTON ----------------
    @FXML
    public void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/tonnidemo/staff_dashboard.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene()
                    .getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- DETAILS ----------------
    private void showDetails(Appointment app) {
        if (app != null) {
            messageLabel.setText(
                    "ID: " + app.getAppointmentId() +
                            "\nName: " + app.getName() +
                            "\nVisa: " + app.getVisaType() +
                            "\nCountry: " + app.getCountry() +
                            "\nStatus: " + app.getStatus()
            );
        }
    }
}