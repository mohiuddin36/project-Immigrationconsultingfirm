package com.example.immigrationconsultingfirm_project_cse213.Countryspecialist;

import com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel.Eligibility;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class CheckClientEligibilitybyCountry
{
    @javafx.fxml.FXML
    private Button CheckEligibalityButton;
    @javafx.fxml.FXML
    private TableColumn Countrycol;
    @javafx.fxml.FXML
    private ComboBox SelectCountryComboBox;
    @javafx.fxml.FXML
    private TableView EligibilityTableView;
    @javafx.fxml.FXML
    private ComboBox ClientprofileComboBox;
    @javafx.fxml.FXML
    private TableColumn programecol;
    @javafx.fxml.FXML
    private TableColumn RequirmentsCol;
    @javafx.fxml.FXML
    private TextArea eduTextArea;
    @javafx.fxml.FXML
    private TextArea experienceTextArea;
    @javafx.fxml.FXML
    private Label messagelabel;
    private ArrayList<Eligibility> eligibilityList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        Countrycol.setCellValueFactory(new PropertyValueFactory<>("country"));
        programecol.setCellValueFactory(new PropertyValueFactory<>("program"));
        RequirmentsCol.setCellValueFactory(new PropertyValueFactory<>("requirements"));

        eligibilityList.add(new Eligibility("Canada", "Student Visa", "Bachelor + IELTS"));
        eligibilityList.add(new Eligibility("Australia", "Work Visa", "Experience + IELTS"));
        eligibilityList.add(new Eligibility("UK", "Skilled Worker", "Degree + Job Offer"));

        EligibilityTableView.getItems().addAll(eligibilityList);

        ClientprofileComboBox.getItems().addAll("Undergraduate", "Graduate", "Experienced");

        SelectCountryComboBox.getItems().addAll("Canada", "Australia", "UK");

        messagelabel.setText("");
    }

    @javafx.fxml.FXML
    public void CheckEligibalityButtonhandeler(ActionEvent actionEvent) {
        String profile = (String)  ClientprofileComboBox.getValue();
        String country = (String) SelectCountryComboBox.getValue();
        String education = eduTextArea.getText();
        String experience = experienceTextArea.getText();

        if (profile == null) {
            messagelabel.setText("Select client profile!");
            return;
        }

        if (country == null) {
            messagelabel.setText("Select country!");
            return;
        }

        if (education.isEmpty() || experience.isEmpty()) {
            messagelabel.setText("Fill all fields!");
            return;
        }

        if (country.equals("Canada")) {

            if (education.toLowerCase().contains("bachelor")) {
                messagelabel.setText("Eligible for Canada Student Visa");
            } else {
                messagelabel.setText("Not eligible for Canada");
            }

        } else if (country.equals("Australia")) {

            if (experience.length() > 2) {
                messagelabel.setText("Eligible for Australia Work Visa");
            } else {
                messagelabel.setText("Not eligible for Australia");
            }

        } else if (country.equals("UK")) {

            if (education.toLowerCase().contains("degree")) {
                messagelabel.setText("Eligible for UK Skilled Worker");
            } else {
                messagelabel.setText("Not eligible for UK");
            }
        }
    }
}

