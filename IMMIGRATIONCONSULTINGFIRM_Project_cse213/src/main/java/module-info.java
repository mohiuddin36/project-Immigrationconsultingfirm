module com.example.immigrationconsultingfirm_project_cse213 {
    requires javafx.controls;
    requires javafx.fxml;
    //requires com.example.immigrationconsultingfirm_project_cse213;
    requires javafx.graphics;
<<<<<<< HEAD
    requires com.example.immigrationconsultingfirm_project_cse213;
=======
    requires java.management;
    requires java.desktop;
<<<<<<< HEAD
    requires java.xml.crypto;
=======
>>>>>>> 06d2e7a671bceb7c28551b626f69b069384ec8c6
>>>>>>> 0b43a4f301ae74d76de41655f8275ec513d9b641
    //requires com.example.immigrationconsultingfirm_project_cse213;


    opens com.example.immigrationconsultingfirm_project_cse213 to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213;
    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller;
    opens com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Controller to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller;
    opens com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Controller to javafx.fxml;
    exports com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant;
    opens com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant to javafx.fxml;
}