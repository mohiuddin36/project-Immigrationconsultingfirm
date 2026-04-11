package com.example.immigrationconsultingfirm_project_cse213.Countryspecialist;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class SuggestSuitableVisaType
{
    @javafx.fxml.FXML
    private Button ConfirmandSaveButton;
    @javafx.fxml.FXML
    private ListView AvailabilitiesTypeListView;
    @javafx.fxml.FXML
    private Button ChoseforRecommendationBtton;
    @javafx.fxml.FXML
    private TextArea ClientImmigrationgoalTextArea;


    private ArrayList<String> visaList = new ArrayList<>();
    private ArrayList<String> savedRecommendations = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {


        visaList.add("Skilled Worker Visa");
        visaList.add("Student Visa");
        visaList.add("Family Sponsorship Visa");

        AvaialablevisaTypeListView.getItems().addAll(visaList);

    }

    @javafx.fxml.FXML
    public void ChoseforRecommendationhandeler(ActionEvent actionEvent) {
        public void ChoseforRecommendationhandeler(ActionEvent actionEvent) {

            String selectedVisa = AvaialablevisaTypeListView.getSelectionModel().getSelectedItem();

            if (selectedVisa == null) {
                showAlert("Please select a visa type!");
                return;
            }

            ClientImmigrationgoalTextArea.setText(selectedVisa);
            showAlert("Visa Selected!");
    }

    @javafx.fxml.FXML
    public void ConfirmandSaveButtonhandeler(ActionEvent actionEvent) {


            if (ClientImmigrationgoalTextArea.getText().isEmpty()) {
                showAlert("No recommendation found!");
                return;
            }

            savedRecommendations.add(ClientImmigrationgoalTextArea.getText());

            showAlert("Saved Successfully!")
    }
}

    private void showAlert(String s) {
        private void showAlert(String msg) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("System Message");
            alert.setContentText(msg);
            alert.show();
        }


    }
    }