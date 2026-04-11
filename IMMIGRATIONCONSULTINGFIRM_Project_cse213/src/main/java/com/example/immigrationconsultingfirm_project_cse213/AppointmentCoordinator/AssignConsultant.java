package com.example.immigrationconsultingfirm_project_cse213.AppointmentCoordinator;

import com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel.ClientRequest;
import com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel.Consultant;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class AssignConsultant
{
    @javafx.fxml.FXML
    private TableView Consultanttableview;
    @javafx.fxml.FXML
    private Label AvaiableConsultcol;
    @javafx.fxml.FXML
    private TableView clientdetailstableview;
    @javafx.fxml.FXML
    private Button AssignButton;
    @javafx.fxml.FXML
    private TableColumn AvailableDateCol;
    @javafx.fxml.FXML
    private TableColumn RequestIDcol;
    @javafx.fxml.FXML
    private TableColumn ConsultantNamecol;
    @javafx.fxml.FXML
    private Label messagelabel;
    @javafx.fxml.FXML
    private TableColumn Clientnamecol;
    @javafx.fxml.FXML
    private ComboBox AvaialableConsultcombo;
    @javafx.fxml.FXML
    private TableColumn Datecol;

    private ArrayList<ClientRequest> clientList = new ArrayList<>();
    private ArrayList<Consultant> consultantList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        RequestIDcol.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        Clientnamecol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        Datecol.setCellValueFactory(new PropertyValueFactory<>("date"));

        ConsultantNamecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        AvailableDateCol.setCellValueFactory(new PropertyValueFactory<>("availableDate"));


        clientList.add(new ClientRequest(1, "Rahim", LocalDate.now()));
        clientList.add(new ClientRequest(2, "Karim", LocalDate.now().plusDays(1)));

        consultantList.add(new Consultant("John", LocalDate.now()));
        consultantList.add(new Consultant("Smith", LocalDate.now().plusDays(1)));

        clientdetailstableview.getItems().addAll(clientList);
        Consultanttableview.getItems().addAll(consultantList);


        for (Consultant c : consultantList) {
            AvaialableConsultcombo.getItems().add(c.getName());
        }

        messagelabel.setText("");
    }

    @javafx.fxml.FXML
    public void handleassign(ActionEvent actionEvent) {
        ClientRequest selectedClient =
                (ClientRequest) (ClientRequest) clientdetailstableview.getSelectionModel().getSelectedItem();

        Consultant selectedConsultant =
                (Consultant) (Consultant)  Consultanttableview.getSelectionModel().getSelectedItem();


        if (selectedClient == null) {
            messagelabel.setText("Select a client!");
            return;
        }


        if (selectedConsultant == null) {
            messagelabel.setText("Select a consultant!");
            return;
        }


        if (selectedClient.getDate().equals(selectedConsultant.getAvailableDate())) {

            messagelabel.setText("Assigned ");

        } else {

            messagelabel.setText("Date mismatch! Cannot assign.");
        }

    }
}