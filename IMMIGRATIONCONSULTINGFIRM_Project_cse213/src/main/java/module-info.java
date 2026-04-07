module com.example.immigrationconsultingfirm_project_cse213 {
    requires javafx.controls;
    requires javafx.fxml;
    //requires com.example.immigrationconsultingfirm_project_cse213;
    requires javafx.graphics;
    //requires com.example.immigrationconsultingfirm_project_cse213;


    opens com.example.immigrationconsultingfirm_project_cse213 to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213;
    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;
    opens com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller to javafx.fxml;
}