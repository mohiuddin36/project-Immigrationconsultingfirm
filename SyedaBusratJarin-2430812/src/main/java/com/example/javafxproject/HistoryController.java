package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class HistoryController {

    @FXML private TableView<Booking> historyTable;

    @FXML private TableColumn<Booking, String> nameColumn;
    @FXML private TableColumn<Booking, String> serviceColumn;
    @FXML private TableColumn<Booking, String> dateColumn;
    @FXML private TableColumn<Booking, String> timeColumn;
    @FXML private TableColumn<Booking, String> statusColumn;

    @FXML
    public void initialize() {

        nameColumn.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getName()));

        serviceColumn.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getService()));

        dateColumn.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getDate()));

        timeColumn.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getTime()));



        statusColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getStatus()));

        historyTable.setItems(BookingStorage.bookings);
    }

    // PREVIOUS BUTTON
    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/javafxproject/client_dashboard.fxml")
            );

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Client Dashboard");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}