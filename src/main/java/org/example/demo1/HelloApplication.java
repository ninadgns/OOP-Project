package org.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signinPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres?user=postgres.iaffaaaqyxfouhtxibey&password=amarsonarbangla");) {
            if (conn != null) {
                System.out.println("Database connected successfully...");
                String sql = "SELECT id, content FROM notes";
                try (Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)) {
                    // Iterate over the result set and print the rows
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String content = rs.getString("content");
                        System.out.println("ID: " + id + ", Content: " + content);
                    }
                    System.out.println("db query successfull");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        launch();
    }
}