package com.example.immigrationconsultingfirm_project_cse213.AppointmentCoordinator;

import com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel.Appointment;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UpdateAppointmentStatus
{
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> IdCol;
    @javafx.fxml.FXML
    private TableView<Appointment> AppointmentTableView;
    @javafx.fxml.FXML
    private ComboBox<String> SelectstatusComboBox;
    @javafx.fxml.FXML
    private Button UpdatestatusButton;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> DateCol;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> NameCol;
    private Appointment list;

    @javafx.fxml.FXML
    public void initialize() {

        list.add(new Appointment("1", "Rahim", "2026-04-10", "Pending"));
        list.add(new Appointment("2", "Karim", "2026-04-11", "Pending"));
        list.add(new Appointment("3", "Sadia", "2026-04-12", "Pending"));

        AppointmentTableView.getItems().setAll(list);

        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        SelectstatusComboBox.getItems().addAll(
                "Pending",
                "Confirmed",
                "Completed",
                "Cancelled"
        );

    }

    @javafx.fxml.FXML
    public void UpdatestatusButtonhandle(ActionEvent actionEvent) {
        Appointment selected = AppointmentTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            System.out.println("Select appointment first!");
            return;
        }

        String status = SelectstatusComboBox.getValue();

        if (status == null) {
            System.out.println("Select status!");
            return;
        }


        selected.setStatus(status);


        AppointmentTableView.getItems().setAll(list);

        SelectstatusComboBox.setValue(null);

        System.out.println("Status updated!");
    }

}


