package com.example.tonnidemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationController {

    // fx:id field (proper type + access modifier)
    @FXML
    private TextField textField;

    // collection (ArrayList as required)
    private List<String> dataList = new ArrayList<>();

    @FXML
    public void initialize() {
        dataList = new ArrayList<>();
    }

    @FXML
    public void handleSubmit(ActionEvent actionEvent) {

        String value = textField.getText();

        // validation
        if (value == null || value.isEmpty()) {
            showAlert("Error", "Input field is empty!");
            return;
        }

        // save data
        dataList.add(value);

        showAlert("Success", "Data saved successfully!");

        textField.clear();
    }

    // SCENE SWITCHING (IMPORTANT)
    public void switchScene(String fxmlFile, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene()
                    .getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Cannot load page!");
        }
    }

    // ALERT METHOD
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}