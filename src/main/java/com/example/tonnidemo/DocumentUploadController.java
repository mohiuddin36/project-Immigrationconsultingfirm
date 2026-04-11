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

public class DocumentUploadController {

    @FXML
    private ComboBox<String> docTypeBox;

    @FXML
    private TextField filePathField;

    @FXML
    private Label messageLabel;

    private List<String> documentList = new ArrayList<>();

    @FXML
    public void initialize() {

        docTypeBox.setItems(FXCollections.observableArrayList(
                "Passport Copy",
                "Educational Certificate",
                "Photo",
                "Work Experience Letter"
        ));
    }

    // FAKE FILE SELECT
    @FXML
    public void handleChooseFile(ActionEvent actionEvent) {
        filePathField.setText("C:/fakepath/document.pdf");
    }

    // UPLOAD
    @FXML
    public void handleUpload(ActionEvent actionEvent) {

        String type = docTypeBox.getValue();
        String file = filePathField.getText();

        if (type == null || file == null || file.isEmpty()) {
            showAlert("Error", "Select document type and file!");
            return;
        }

        documentList.add(type + " -> " + file);

        messageLabel.setText("Upload Successful!");

        clearFields();
    }

    // BACK TO DASHBOARD (IMPORTANT FIX)
    @FXML
    public void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("client_dashboard.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(scene);
        stage.show();
    }

    private void clearFields() {
        docTypeBox.getSelectionModel().clearSelection();
        filePathField.clear();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}