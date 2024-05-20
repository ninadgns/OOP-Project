package org.example.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class amiKeuna extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Image source URL
        String imageUrl = "https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg";

        // Create an ImageView
        ImageView imageView = new ImageView();

        // Load the image with error handling
        Image image = new Image(imageUrl);
        imageView.setImage(image);

        // Set image fit for the pane
//        imageView.setFitToPane(true);

        // Create a StackPane to hold the ImageView
        StackPane pane = new StackPane(imageView);

        // Create the scene and set its size
        Scene scene = new Scene(pane, 600, 400);

        // Set the stage title and scene
        primaryStage.setTitle("Displaying Image from Pexels");
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
