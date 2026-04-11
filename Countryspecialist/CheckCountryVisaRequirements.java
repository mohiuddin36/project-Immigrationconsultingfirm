package com.example.immigrationconsultingfirm_project_cse213.Countryspecialist;

import com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel.ClientDetails;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.util.ArrayList;

public class CheckCountryVisaRequirements
{
    @FXML
    private Button ValidateButton;
    @FXML
    private AnchorPane CountryComboBox;
    @FXML
    private TableColumn AgeCol;
    @FXML
    private TableColumn EducatioonQualificationCol;
    @FXML
    private TextArea VisaRequirementsTextArea;
    @FXML
    private Button saveAdviceButton;
    @FXML
    private TableView ClientdetailsTableview;
    @FXML
    private ComboBox countryComboBox;
    @FXML
    private TableColumn namecol;
    @FXML
    private Label messagelabe;
    private ArrayList<ClientDetails> clientList = new ArrayList<>();

    @FXML
    public void initialize() {
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        AgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        EducatioonQualificationCol.setCellValueFactory(new PropertyValueFactory<>("educationQualification"));


        clientList.add(new ClientDetails("Rahim", 22, "Bachelor"));
        clientList.add(new ClientDetails("Karim", 30, "Diploma"));

        ClientdetailsTableview.getItems().addAll(clientList);


        countryComboBox.getItems().addAll("Canada", "Australia", "UK");


        messagelabe.setText("");
    }

    @FXML
    public void saveAdviceHandeler(ActionEvent actionEvent) {  String advice = VisaRequirementsTextArea.getText();

        if (advice.isEmpty()) {
            messagelabe.setText("No advice to save!");
            return;
        }


        messagelabe.setText("Advice saved successfully!");
    }

}


    public void validatehandeler(ActionEvent actionEvent) {



        selectedClient = ClientdetailsTableview.getSelectionModel().getSelectedItem();
        String country = countryComboBox.getValue();

        if (selectedClient == null) {
            messagelabel.setText("Select a client!");
            return;
        }

        if (country == null) {
            messagelabel.setText("Select a country!");
            return;
        }


        if (country.equals("Canada")) {

            if (selectedClient.getEducationQualification().equalsIgnoreCase("Bachelor")) {

                VisaRequirementsTextArea.setText("Canada: IELTS + Financial Proof");
                messagelabel.setText("Eligible for Canada");

            } else {
                messagelabel.setText("Not eligible for Canada");
            }

        } else if (country.equals("Australia")) {

            if (selectedClient.getAge() >= 18) {

                VisaRequirementsTextArea.setText("Australia: Skill Assessment + IELTS");
                messagelabel.setText("Eligible for Australia");

            } else {
                messagelabel.setText("Not eligible for Australia");
            }

        } else if (country.equals("UK")) {

            VisaRequirementsTextArea.setText("UK: Job Offer + English Test");
            messagelabel.setText("Basic eligibility checked");
        }


    }

@FXML
private Button ValidateButton;
@FXML
private AnchorPane CountryComboBox;
@FXML
private TableColumn AgeCol;
@FXML
private TableColumn EducatioonQualificationCol;
@FXML
private TextArea VisaRequirementsTextArea;
@FXML
private Button saveAdviceButton;
@FXML
private TableView ClientdetailsTableview;
@FXML
private ComboBox countryComboBox;
@FXML
private TableColumn namecol;
@FXML
private Label messagelabe;

@FXML
public void validateHandelr(ActionEvent actionEvent) {
}

@FXML
public void saveAdviceHandler(ActionEvent actionEvent) {
}


