package com.ig.main;

import com.ig.io.IOFiles;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application{


    public static final String MATERIAL_STYLE = Main.class.getResource("../material/style/MaterialStyle.css").toExternalForm();

    private static Stage primaryStage;



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Daniel Aplication");
        Main.primaryStage = primaryStage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../resources/layout_frame.fxml"));
            root.getStylesheets().add(Main.MATERIAL_STYLE);
            Scene scene = new Scene(root, 300, 400);
            setScene(scene);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void setScene(Scene scene){

        primaryStage.setScene(scene);
//        primaryStage.setX();
//        primaryStage.setY();
    }

    public static void main(String[] args) {


    }


}
