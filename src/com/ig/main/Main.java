package com.ig.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Daniel Aplication");
        Main.primaryStage = primaryStage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../resources/layout_frame.fxml"));

            Scene scene = new Scene(root, 300, 400);
            setScene(scene);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setScene(Scene scene){
        scene.getStylesheets().add(Main.class.getResource("../material/style/MaterialStyle.css").toExternalForm());
        primaryStage.setScene(scene);
//        primaryStage.setX();
//        primaryStage.setY();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
