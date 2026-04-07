package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;

public class DeadlinesController
{
    @FXML
    private TextArea logArea;

    @FXML
    private TableColumn<TranslatingDocumentData, String> statusColumn;

    @FXML
    private TableColumn<TranslatingDocumentData, String> docNameColumn;

    @FXML
    private TableColumn<TranslatingDocumentData, String> deadlineColumn;

    @FXML
    private TableView<TranslatingDocumentData> tableView;

    @FXML
    private Label statusLabel;

    private ObservableList<TranslatingDocumentData> documents = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        docNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        deadlineColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDeadline()));
        statusColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));

        statusLabel.setText("Status: Ready");

        // Example documents with deadlines
        documents.add(new TranslatingDocumentData("ClientPassport.pdf", "French", "2", "Pending"));
        documents.add(new TranslatingDocumentData("BirthCert.docx", "Spanish", "5", "Pending"));
        documents.add(new TranslatingDocumentData("VisaForm.pdf", "English", "1", "Pending"));

        tableView.setItems(documents);
    }

    @FXML
    public void handleViewDeadlines(ActionEvent actionEvent) {
        tableView.setItems(documents);
        statusLabel.setText("Loaded document deadlines");
    }

    @FXML
    public void handleIdentifyUrgent(ActionEvent actionEvent) {
        ObservableList<TranslatingDocumentData> urgentDocs = FXCollections.observableArrayList();
        for (TranslatingDocumentData doc : documents) {
            int daysRemaining = Integer.parseInt(doc.getDeadline());
            if (daysRemaining < 3) {
                urgentDocs.add(doc);
            }
        }
        tableView.setItems(urgentDocs);
        statusLabel.setText("Urgent documents identified (deadline < 3 days)");
    }

    @FXML
    public void handleSetPriority(ActionEvent actionEvent) {
        // Sort urgent documents first
        documents.sort((d1, d2) -> Integer.parseInt(d1.getDeadline()) - Integer.parseInt(d2.getDeadline()));
        tableView.setItems(documents);
        statusLabel.setText("Documents prioritized by deadline");
    }

    @FXML
    public void handleProcessUrgent(ActionEvent actionEvent) {
        for (TranslatingDocumentData doc : documents) {
            int daysRemaining = Integer.parseInt(doc.getDeadline());
            if (daysRemaining < 3) {
                doc.setStatus("Processed Immediately");
            }
        }
        tableView.refresh();
        statusLabel.setText("Urgent documents processed");
    }

    @FXML
    public void handleTrackProgress(ActionEvent actionEvent) {
        int total = documents.size();
        int processed = (int) documents.stream().filter(d -> d.getStatus().equals("Processed Immediately")).count();
        int progress = (processed * 100) / total;
        logArea.setText("Progress: " + progress + "% documents processed");
        statusLabel.setText("Progress updated");
    }

    @FXML
    public void handleNotifyConsultant(ActionEvent actionEvent) {
        for (TranslatingDocumentData doc : documents) {
            int daysRemaining = Integer.parseInt(doc.getDeadline());
            if (daysRemaining < 0) {
                logArea.appendText("Notification sent for delay on " + doc.getName() + "\n");
            }
        }
        statusLabel.setText("Consultant notified about delayed documents");
    }

    @FXML
    public void handleUpdateDeadlineStatus(ActionEvent actionEvent) {
        for (TranslatingDocumentData doc : documents) {
            int daysRemaining = Integer.parseInt(doc.getDeadline());
            if (daysRemaining < 3) {
                doc.setStatus("Urgent");
            } else {
                doc.setStatus("Normal");
            }
        }
        tableView.refresh();
        statusLabel.setText("Deadline status updated");
    }
}