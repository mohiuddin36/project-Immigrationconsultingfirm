package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class FeedbackController {

    @FXML private TextField nameField;
    @FXML private ComboBox<String> ratingCombo;
    @FXML private TextArea commentArea;

    @FXML
    public void initialize() {

        ratingCombo.getItems().addAll(
                "⭐", "⭐⭐", "⭐⭐⭐", "⭐⭐⭐⭐", "⭐⭐⭐⭐⭐"
        );
    }

    // SUBMIT FEEDBACK
    @FXML
    private void submitFeedback() {

        String name = nameField.getText();
        String rating = ratingCombo.getValue();
        String comment = commentArea.getText();

        if (name.isEmpty() || rating == null || comment.isEmpty()) {
            System.out.println("Please fill all fields!");
            return;
        }

        System.out.println("FEEDBACK RECEIVED:");
        System.out.println(name + " | " + rating + " | " + comment);

        nameField.clear();
        ratingCombo.getSelectionModel().clearSelection();
        commentArea.clear();
    }

    // BACK BUTTON
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