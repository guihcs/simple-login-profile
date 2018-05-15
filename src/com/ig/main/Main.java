package com.ig.main;

import com.ig.io.IOFiles;
import com.ig.ui.FrameController;
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
    public static final String BASE_FOLDER = System.getProperty("user.home") + "/DanielApp/";

    private static Stage primaryStage;

    public static FrameController frameController;


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Daniel Aplication");
        Main.primaryStage = primaryStage;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/layout_frame.fxml"));
            Parent root = loader.load();
            frameController = loader.getController();
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

    @Override
    public void stop() throws Exception {
        logout();
        super.stop();
    }

    public void logout(){
        com.ig.dao.Application.logout();
        com.ig.dao.Application.saveData(BASE_FOLDER);
    }

    public static void main(String[] args) {
        com.ig.dao.Application.loadData(BASE_FOLDER, "/UserFiles/Users.txt");
        launch(args);

    }


}
