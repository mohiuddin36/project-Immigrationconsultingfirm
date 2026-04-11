module com.example.immigrationconsultingfirm_project_cse213 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // Existing
    opens com.example.immigrationconsultingfirm_project_cse213 to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213;

    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer to javafx.fxml;

    exports com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;
    opens com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller to javafx.fxml;

    // ADD THESE LINES for DocumentationAndTranslation
    exports com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;
    opens com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation to javafx.fxml;
}