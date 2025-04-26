package org.example.therapycenter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.therapycenter.configuration.FactoryConfiguration;
import org.example.therapycenter.entity.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class AppInitializer extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppInitializer.class.getResource("/view/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Serenity Health Therapy Center System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        FactoryConfiguration.getInstance().getSession();
        launch();
    }
}