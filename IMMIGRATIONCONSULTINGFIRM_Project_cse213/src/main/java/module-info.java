module com.example.immigrationconsultingfirm_project_cse213 {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.management;
    requires java.desktop;

    opens com.example.immigrationconsultingfirm_project_cse213 to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213;

    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer to javafx.fxml;

    exports com.example.immigrationconsultingfirm_project_cse213.Immigration_Consultant.Controller;
    opens com.example.immigrationconsultingfirm_project_cse213.Immigration_Consultant.Controller to javafx.fxml;

    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model to javafx.fxml;

    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller to javafx.fxml;

    exports com.example.immigrationconsultingfirm_project_cse213.Immigration_Consultant;
    opens com.example.immigrationconsultingfirm_project_cse213.Immigration_Consultant to javafx.fxml;
}