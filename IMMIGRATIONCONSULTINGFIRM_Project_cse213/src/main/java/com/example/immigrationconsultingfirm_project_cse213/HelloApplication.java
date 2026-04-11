package com.example.immigrationconsultingfirm_project_cse213;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
<<<<<<< HEAD
                HelloApplication.class.getResource("FinanceOfficer/financeOfficerDashboard.fxml")
=======
<<<<<<< HEAD
                HelloApplication.class.getResource(
                        "/com/example/immigrationconsultingfirmprojectcse213/Documentation/AddClient.fxml")
=======
                HelloApplication.class.getResource("com.example.immigrationconsultingfirm_project_cse213.HelloController")
>>>>>>> af7354aa15cfda3d1705edbbce1c3292d77e5810
>>>>>>> fe4ee4991276fa18193f15c4dd9f6570f122f25f
        );
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}