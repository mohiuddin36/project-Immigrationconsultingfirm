module com.example.immigrationconsultingfirm_project_cse213 {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires java.management;
    requires java.desktop;


    requires java.xml.crypto;

//>>>>>>> 06d2e7a671bceb7c28551b626f69b069384ec8c6
//>>>>>>> 0b43a4f301ae74d76de41655f8275ec513d9b641
    //requires com.example.immigrationconsultingfirm_project_cse213;

//>>>>>>> 678c8fbb5dee46aca652e81da26a52e45d2399c8


    // Existing
    opens com.example.immigrationconsultingfirm_project_cse213 to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213;

    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer to javafx.fxml;


    exports com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;
    opens com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller to javafx.fxml;

    // ADD THESE LINES for DocumentationAndTranslation
//    exports com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;
//    opens com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation to javafx.fxml;

    //exports com.example.immigrationconsultingfirm_project_cse213.Immigration_Consultant.Controller;
    //opens com.example.immigrationconsultingfirm_project_cse213.Immigration_Consultant.Controller to javafx.fxml;

    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model to javafx.fxml;

    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller to javafx.fxml;

    //exports com.example.immigrationconsultingfirm_project_cse213.Immigration_Consultant;
    //opens com.example.immigrationconsultingfirm_project_cse213.Immigration_Consultant to javafx.fxml;
}