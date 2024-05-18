package org.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.example.database.ChatServer;
import org.example.database.DatabaseClient;
import org.example.database.Tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Map;
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

    }

    public static List<Map<String, Object>> allHotels;

    public static void main(String[] args) {

        DatabaseClient.initiate();
        launch();

        // DatabaseClient.runSQL("select id, content from notes");
        // DatabaseClient.runSQL("insert into notes (id, content) values (3, 'chirodin
        // tomar akash')");
        // DatabaseClient.insert("notes", "id, content", "5, 'o ma fagune tor'");
        // var a = DatabaseClient.fetch("accountinfo");
        // for (var row : a) {
        // System.out.println(row.get("email"));
        //
        // }

        // var a = DatabaseClient.fetch(Tables.ACCOUNTINFO);
        // for (Map<String, Object> map : a) {
        // var base64String = map.get("profilephoto");
        //// if (base64String!=null && base64String.toString().length()>50) {
        //// DatabaseClient.saveFile(base64String.toString());
        //// }

        allHotels = DatabaseClient.fetch(Tables.HOTELS);

        launch();
        // for (Map<String, Object> map : a) {
        // var base64String = map.get("profilephoto");
        // if (base64String!=null && base64String.toString().length()>50) {
        // DatabaseClient.saveFile(base64String.toString());
        // }

        // }
        // new Thread(
        // () -> {
        // while (true) {
        // chat();
        // }
        // }).start();

        // try {
        // ChatServer.start(args);
        // } catch (Exception e) {
        // e.printStackTrace();// TODO: handle exception
        // }

    }
}