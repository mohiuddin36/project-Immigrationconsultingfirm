package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelpdeskController {

    @FXML private TextField subjectField;
    @FXML private ComboBox<String> categoryBox;
    @FXML private TextArea descriptionArea;

    private List<String> tickets = new ArrayList<>();

    @FXML
    public void initialize() {
        categoryBox.setItems(FXCollections.observableArrayList(
                "Visa Issue", "Document Issue", "Payment Issue"
        ));
    }

    @FXML
    public void handleSubmit() {

        if (subjectField.getText().isEmpty() ||
                categoryBox.getValue() == null ||
                descriptionArea.getText().isEmpty()) {
            return;
        }

        tickets.add(subjectField.getText());

        subjectField.clear();
        descriptionArea.clear();
        categoryBox.getSelectionModel().clearSelection();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("client_dashboard.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}