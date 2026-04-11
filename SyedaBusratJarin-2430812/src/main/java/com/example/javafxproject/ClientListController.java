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

import java.util.stream.Collectors;

public class ClientListController {

    @FXML private TableView<Booking> table;

    @FXML private TableColumn<Booking, String> nameCol;
    @FXML private TableColumn<Booking, String> phoneCol;

    @FXML
    public void initialize() {

        nameCol.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getName()));

        phoneCol.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getPhone()));

        table.setItems(BookingStorage.bookings);
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