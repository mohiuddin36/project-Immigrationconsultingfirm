package com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel;

import javafx.scene.control.*;

import java.time.LocalDate;

public class Appointment {
    private int id;
    private String clientName;
    private LocalDate date;
    private String status;
    private String cancelReason;
    private TableColumn<Appointment, String> datecol;
    private TableColumn<Appointment, String> namecol;
     private TableView<Appointment> Appointmenttableview;
     private Button savebtn;
    
    private TableColumn<Appointment, String> IdCol;

    public Appointment(int id, Label messagelabel, DatePicker newdatepicker, TableColumn<Appointment, String> idCol, Button savebtn, TableView<Appointment> appointmenttableview, TableColumn<Appointment, String> namecol, TableColumn<Appointment, String> datecol, String status, String clientName, LocalDate date, String cancelReason) {
        this.id = id;
        this.messagelabel = messagelabel;
        this.newdatepicker = newdatepicker;
        IdCol = idCol;
        this.savebtn = savebtn;
        Appointmenttableview = appointmenttableview;
        this.namecol = namecol;
        this.datecol = datecol;
        this.status = status;
        this.clientName = clientName;
        this.date = date;
        this.cancelReason = cancelReason;
    }

    private DatePicker newdatepicker;
     private Label messagelabel;

    public Appointment(int id, String clientName, LocalDate date) {
        this.id = id;
        this.clientName = clientName;
        this.date = date;
        this.status = status;
        this.cancelReason = cancelReason;
    }

    public Appointment(String number, String sadia, String date) {
    }

    public Appointment(String number, String sadia, String date) {
    }

    public Appointment(String number, String sadia, String date) {
    }

    public Appointment(String number, String sadia, String date) {
    }

    public Appointment(String number, String sadia, String date) {
    }

    public Appointment(String number, String rahim, String date) {
    }

    public Appointment(String number, String rahim, String date) {
    }

    public Appointment(String number, String rahim, String date) {
    }

    public Appointment(String number, String rahim, String date) {
    }

    public Appointment(String number, String rahim, String date) {
    }

    public Appointment(String number, String rahim, String date) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public TableColumn<Appointment, String> getDatecol() {
        return datecol;
    }

    public void setDatecol(TableColumn<Appointment, String> datecol) {
        this.datecol = datecol;
    }

    public TableColumn<Appointment, String> getNamecol() {
        return namecol;
    }

    public void setNamecol(TableColumn<Appointment, String> namecol) {
        this.namecol = namecol;
    }

    public TableView<Appointment> getAppointmenttableview() {
        return Appointmenttableview;
    }

    public void setAppointmenttableview(TableView<Appointment> appointmenttableview) {
        Appointmenttableview = appointmenttableview;
    }

    public Button getSavebtn() {
        return savebtn;
    }

    public void setSavebtn(Button savebtn) {
        this.savebtn = savebtn;
    }

    public TableColumn<Appointment, String> getIdCol() {
        return IdCol;
    }

    public void setIdCol(TableColumn<Appointment, String> idCol) {
        IdCol = idCol;
    }

    public DatePicker getNewdatepicker() {
        return newdatepicker;
    }

    public void setNewdatepicker(DatePicker newdatepicker) {
        this.newdatepicker = newdatepicker;
    }

    public Label getMessagelabel() {
        return messagelabel;
    }

    public void setMessagelabel(Label messagelabel) {
        this.messagelabel = messagelabel;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", cancelReason='" + cancelReason + '\'' +
                ", datecol=" + datecol +
                ", namecol=" + namecol +
                ", Appointmenttableview=" + Appointmenttableview +
                ", savebtn=" + savebtn +
                ", IdCol=" + IdCol +
                ", newdatepicker=" + newdatepicker +
                ", messagelabel=" + messagelabel +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
