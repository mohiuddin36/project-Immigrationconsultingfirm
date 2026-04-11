package com.example.immigrationconsultingfirm_project_cse213.AppointmentCoordinator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ViewAppointmentRequests
{
    @javafx.fxml.FXML
    private TableView<AppointmentRequest> RequestlistTableView;
    @javafx.fxml.FXML
    private Button requestButton;
    @javafx.fxml.FXML
    private TableColumn contactCol;
    @javafx.fxml.FXML
    private TableColumn reasonCol;
    @javafx.fxml.FXML
    private TableView clientinformatioTableView;
    @javafx.fxml.FXML
    private TableColumn NameCol;

    private ArrayList<AppointmentRequest> requestList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        requestCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<>("reason"));

        requestList.add(new AppointmentRequest("Rahim", "01711111111", "Visa Inquiry"));
        requestList.add(new AppointmentRequest("Karim", "01822222222", "Study Visa"));


        RequestlistTableView.getItems().addAll(requestList);
    }




    @javafx.fxml.FXML
    public void handleSelectRequest(ActionEvent actionEvent) {
        AppointmentRequest selected =
                RequestlistTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Please select a request!");
            return;
        }

        // load selected data into second table
        clientinformatioTableView.getItems().clear();
        clientinformatioTableView.getItems().add(selected);

        showAlert("Request Loaded!");
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