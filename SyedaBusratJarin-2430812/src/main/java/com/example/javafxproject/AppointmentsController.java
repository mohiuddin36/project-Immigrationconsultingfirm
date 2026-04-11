package com.example.javafxproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AppointmentsController {

    @FXML private TableView<Booking> appointmentsTable;

    @FXML private TableColumn<Booking, String> nameColumn;
    @FXML private TableColumn<Booking, String> phoneColumn;
    @FXML private TableColumn<Booking, String> serviceColumn;
    @FXML private TableColumn<Booking, String> dateColumn;
    @FXML private TableColumn<Booking, String> timeColumn;
    @FXML private TableColumn<Booking, String> statusColumn;

    @FXML
    public void initialize() {

        nameColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getName()));
        phoneColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPhone()));
        serviceColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getService()));
        dateColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDate()));
        timeColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getTime()));
        statusColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getStatus()));

        appointmentsTable.setItems(BookingStorage.bookings);
    }

    @FXML
    private void goBack() {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/client_dashboard.fxml")
            );

            Stage stage = (Stage) appointmentsTable.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}