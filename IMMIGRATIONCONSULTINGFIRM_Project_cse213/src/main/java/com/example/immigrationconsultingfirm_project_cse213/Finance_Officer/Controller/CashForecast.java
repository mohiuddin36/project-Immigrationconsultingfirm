package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.time.LocalDate;

public class CashForecast implements Serializable {
    protected String username, password;
    protected LocalDate applicationDeadlines,
    @javafx.fxml.FXML
    private DatePicker applicationDeadlineTextField;
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField userNameTaxtfield;
    ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CashForecast(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CashForecast{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", applicationDeadlines=" + applicationDeadlines +
                '}';
    }

    @javafx.fxml.FXML
    public void backbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}

