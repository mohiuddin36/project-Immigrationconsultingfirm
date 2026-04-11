package com.example.immigrationconsultingfirm_project_cse213.Countryspecialist;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UpdateCountryImmigrationInformation
{
    @javafx.fxml.FXML
    private Button ValidateandUpdateInformationButton;
    @javafx.fxml.FXML
    private TextField PolicyVersionTextField;
    @javafx.fxml.FXML
    private TextField NotesTextField;
    @javafx.fxml.FXML
    private Button CancelButton;
    @javafx.fxml.FXML
    private TextField visaRequirmentsTextfield;
    @javafx.fxml.FXML
    private DatePicker EffectiveDatepicker;
    @javafx.fxml.FXML
    private Button SaveUpdateButton;

    @javafx.fxml.FXML
    public void initialize() {
        PolicyVersionTextField.setText("");
        visaRequirmentsTextfield.setText("");
        NotesTextField.setText("");

    }

    @javafx.fxml.FXML
    public void ValidateandUpdateInformationhandeler(ActionEvent actionEvent) {
        if (PolicyVersionTextField.getText().isEmpty()) {
            showAlert("Policy Version is required!");
            return;
        }

        if (visaRequirmentsTextfield.getText().isEmpty()) {
            showAlert("Visa Requirements is required!");
            return;
        }

        if (EffectiveDatepicker.getValue() == null) {
            showAlert("Select Effective Date!");
            return;
        }

        if (EffectiveDatepicker.getValue().isBefore(LocalDate.now())) {
            showAlert("Effective date cannot be past date!");
            return;
        }

        if (NotesTextField.getText().isEmpty()) {
            showAlert("Notes field is required!");
            return;
        }

        showAlert("Validation & Update Successful!");
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

    @javafx.fxml.FXML
    public void CancelButtonhandeler(ActionEvent actionEvent) {
        PolicyVersionTextField.clear();
        visaRequirmentsTextfield.clear();
        NotesTextField.clear();
        EffectiveDatepicker.setValue(null);

        showAlert("Form Cleared!");
    }
    }
}