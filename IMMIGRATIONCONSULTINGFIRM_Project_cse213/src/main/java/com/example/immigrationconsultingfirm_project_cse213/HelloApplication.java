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

                HelloApplication.class.getResource("FinanceOfficer/financeOfficerDashboard.fxml")

//                HelloApplication.class.getResource(
//                        "/com/example/immigrationconsultingfirmprojectcse213/Documentation/AddClient.fxml")
//
//                HelloApplication.class.getResource("com.example.immigrationconsultingfirm_project_cse213.HelloController")

        );
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}