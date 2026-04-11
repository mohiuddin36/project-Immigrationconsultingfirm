package com.example.immigrationconsultingfirm_project_cse213.Countryspecialist;

import com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel.ClientDetails;
import javafx.css.Rule;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.crypto.dsig.TransformService;

public class provideCountrySpecificImmigration
{
    @javafx.fxml.FXML
    private ComboBox ClientcaseComboBox;
    @javafx.fxml.FXML
    private TableColumn ruleDescriptionColumn;
    @javafx.fxml.FXML
    private TableColumn Agecol;
    @javafx.fxml.FXML
    private TableColumn ruleNameColumn;
    @javafx.fxml.FXML
    private TableView rulesTable;
    @javafx.fxml.FXML
    private TableColumn requirementLevelColumn;
    @javafx.fxml.FXML
    private Label DestinationCountrycombobox;
    @javafx.fxml.FXML
    private Button saveadvicebutton;
    @javafx.fxml.FXML
    private Button validatebutton;
    @javafx.fxml.FXML
    private TextArea rulesArea;
    @javafx.fxml.FXML
    private TableView ClientdetailsTableview;
    @javafx.fxml.FXML
    private TableColumn namecol;
    @javafx.fxml.FXML
    private TableColumn Educationcol;

    private ArrayList<ClientDetails> clientList = new ArrayList<>();
    private ArrayList<Rule> ruleList = new ArrayList<>();

    public provideCountrySpecificImmigration(ComboBox clientcaseComboBox) {
        ClientcaseComboBox = clientcaseComboBox;
    }

    @javafx.fxml.FXML
    public void initialize() {

        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        Agecol.setCellValueFactory(new PropertyValueFactory<>("age"));
        Educationcol.setCellValueFactory(new PropertyValueFactory<>("education"));

        ruleNameColumn.setCellValueFactory(new PropertyValueFactory<>("ruleName"));
        ruleDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        requirementLevelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));

        clientList.add(new ClientDetails("Rahim", 25, "BSc"));
        clientList.add(new ClientDetails("Karim", 30, "HSC"));

        ClientdetailsTableview.getItems().addAll(clientList);


        ClientcaseComboBox.getItems().add("Case-1");
        ClientcaseComboBox.getItems().add("Case-2");

        // ================= RULE DATA =================
        ruleList.add(new Rule("Visa Rule", "Must have passport", "High"));
        ruleList.add(new Rule("Education Rule", "Minimum HSC required", "Medium"));

        rulesTable.getItems().addAll(ruleList);
    }



}

    @javafx.fxml.FXML
    public void saveadvicehandeler(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void validatehandeler(ActionEvent actionEvent) {


         ClientcaseComboBox;
        if (ClientcaseComboBox.getValue() == null) {
            showAlert("Select Client Case!");
            return;
        }

        if (rulesArea.getText().isEmpty()) {
            showAlert("Write advice first!");
            return;
        }

        showAlert("Validation Successful!");
    }

private void showAlert(String s) {
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("System Message");
        alert.setContentText(msg);
        alert.show();

    }
}

