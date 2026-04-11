package com.example.tonnidemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class TicketManageController {

    @FXML
    private TableView<Ticket> ticketTable;

    @FXML
    private TableColumn<Ticket, String> colTicketId;

    @FXML
    private TableColumn<Ticket, String> colSubject;

    @FXML
    private TableColumn<Ticket, String> colCategory;

    @FXML
    private TableColumn<Ticket, String> colStatus;

    @FXML
    private TextArea replyArea;

    @FXML
    private Label messageLabel;

    private List<Ticket> ticketList = new ArrayList<>();
    private ObservableList<Ticket> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colTicketId.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ticketList.add(new Ticket("T-101", "Visa Issue", "Visa", "Open"));
        ticketList.add(new Ticket("T-102", "Payment Delay", "Payment", "Open"));

        load();
    }

    private void load() {
        data.clear();
        data.addAll(ticketList);
        ticketTable.setItems(data);
    }

    @FXML
    public void handleReply(ActionEvent actionEvent) {

        Ticket selected = ticketTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setText("Select a ticket!");
            return;
        }

        if (replyArea.getText().isEmpty()) {
            messageLabel.setText("Write reply first!");
            return;
        }

        selected.setStatus("Replied");
        load();

        messageLabel.setText("Reply Sent!");
        replyArea.clear();
    }
}