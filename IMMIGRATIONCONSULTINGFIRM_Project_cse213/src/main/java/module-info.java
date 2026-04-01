module com.example.immigrationconsultingfirm_project_cse213 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.immigrationconsultingfirm_project_cse213 to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213;
}