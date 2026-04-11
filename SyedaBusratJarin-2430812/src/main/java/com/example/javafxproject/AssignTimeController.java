package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class AssignTimeController {

    @FXML private TableView<Booking> table;

    @FXML private TableColumn<Booking, String> nameCol;
    @FXML private TableColumn<Booking, String> serviceCol;
    @FXML private TableColumn<Booking, String> timeCol;

    @FXML private TextField timeField;

    @FXML
    public void initialize() {

        nameCol.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getName()));

        serviceCol.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getService()));

        timeCol.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getTime()));

        table.setItems(BookingStorage.bookings);
    }

    @FXML
    private void assignTime() {

        Booking selected = table.getSelectionModel().getSelectedItem();

        if (selected != null && !timeField.getText().isEmpty()) {

            selected.setTime(timeField.getText());
            table.refresh();

            System.out.println("Time Assigned!");
        }
    }

    // 🔙 PREVIOUS BUTTON
    @FXML
    private void goBack(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/receptionist_dashboard.fxml")
            );

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Receptionist Dashboard");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}