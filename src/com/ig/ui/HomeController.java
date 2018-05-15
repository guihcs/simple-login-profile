package com.ig.ui;


import com.ig.dao.Application;
import com.ig.main.Main;
import com.ig.material.view.RippleEffect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button profileButton;
    @FXML
    private Button spiderButton;
    @FXML
    private Button ironButton;
    @FXML
    private Button minionButton;
    @FXML
    private Button pixarButton;
    @FXML
    private Button logoutButton;

    public void initialize(){
        RippleEffect.installEffect(profileButton);
        RippleEffect.installEffect(spiderButton);
        RippleEffect.installEffect(ironButton);
        RippleEffect.installEffect(minionButton);
        RippleEffect.installEffect(pixarButton);
        RippleEffect.installEffect(logoutButton);

        profileButton.setOnAction(e -> startProfile());
        spiderButton.setOnAction(e -> startSpider());
        ironButton.setOnAction(e -> startIron());
        minionButton.setOnAction(e -> startMinion());
        pixarButton.setOnAction(e -> startPixar());
        logoutButton.setOnAction(e -> logout());
    }

    public void startProfile(){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../resources/layout_profile_view.fxml"));
            Scene scene = new Scene(parent);
            Main.openScene("Profile", scene);
            Application.getMedia("profile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startSpider(){
        Media media = new Media(Application.getMedia("aranha"));
        Main.showMedia("Aranha", media);
    }

    public void startIron(){
        Media media = new Media(Application.getMedia("iron"));
        Main.showMedia("Iron", media);
    }

    public void startMinion(){
        Media media = new Media(Application.getMedia("minion"));
        Main.showMedia("Minion", media);
    }

    public void startPixar(){
        Media media = new Media(Application.getMedia("pixar"));
        Main.showMedia("Pixar", media);
    }
    public void logout(){
        Main.logout();
        Main.setStartScene();
    }
}
