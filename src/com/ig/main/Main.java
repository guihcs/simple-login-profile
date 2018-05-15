package com.ig.main;

import com.ig.io.IOFiles;
import com.ig.ui.FrameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

public class Main extends Application{


    public static final String MATERIAL_STYLE = Main.class.getResource("../material/style/MaterialStyle.css").toExternalForm();
    public static final String BASE_FOLDER = System.getProperty("user.home") + "/DanielApp/";
    public static final URL START_SCENE = Main.class.getResource("../resources/layout_frame.fxml");

    private static Stage primaryStage;

    public static FrameController frameController;

    public static Path getFile(){
        FileChooser fileChooser = new FileChooser();
        File resultFile = fileChooser.showOpenDialog(primaryStage);
        return resultFile != null? resultFile.toPath() : null;
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Daniel Aplication");
        Main.primaryStage = primaryStage;
        setStartScene();

        primaryStage.show();
    }

    public static void setStartScene(){
        try {
            FXMLLoader loader = new FXMLLoader(START_SCENE);
            Parent root = loader.load();
            frameController = loader.getController();
            Scene scene = new Scene(root, 300, 400);
            setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setScene(Scene scene){
        scene.getStylesheets().add(Main.MATERIAL_STYLE);
        primaryStage.setScene(scene);
//        primaryStage.setX();
//        primaryStage.setY();
    }

    public static void openScene(String title, Scene scene){
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle(title);
        stage.setScene(scene);

        stage.showAndWait();
    }

    public static void showMedia(String title, Media media){
        Group group = new Group();
        MediaView mediaView = new MediaView();
        group.getChildren().add(mediaView);

        mediaView.setPreserveRatio(true);



        MediaPlayer player = new MediaPlayer(media);
        mediaView.setMediaPlayer(player);

        Scene mediaScene = new Scene(group);

        Stage dialogMovie = new Stage();
        dialogMovie.initModality(Modality.WINDOW_MODAL);
        dialogMovie.setTitle(title);
        dialogMovie.setScene(mediaScene);

        player.setAutoPlay(true);

        dialogMovie.setOnCloseRequest( event -> player.dispose());

        mediaView.fitWidthProperty().bind(dialogMovie.widthProperty());
        dialogMovie.showAndWait();

    }

    @Override
    public void stop() throws Exception {
        logout();
        super.stop();
    }

    public static void logout(){
        com.ig.dao.Application.logout();
        com.ig.dao.Application.saveData(BASE_FOLDER);
    }

    public static void main(String[] args) {
        com.ig.dao.Application.loadData(BASE_FOLDER, "/UserFiles/Users.txt");
        launch(args);

    }


}
