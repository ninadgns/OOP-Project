package org.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.stage.Stage;
import org.example.database.DatabaseClient;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HomePageForCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
//        System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version"));

    }

    public static void main(String[] args) {

        DatabaseClient.initiate();
        // DatabaseClient.runSQL("select id, content from notes");
        // DatabaseClient.runSQL("insert into notes (id, content) values (3, 'chirodin tomar akash')");
        // DatabaseClient.insert("notes", "id, content", "5, 'o ma fagune tor'");
//        var a = DatabaseClient.fetch("accountinfo");
//        for (var row : a) {
//            System.out.println(row.get("email"));
//
//        }
        
        launch();
    }
}