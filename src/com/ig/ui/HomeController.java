package com.ig.ui;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

public class HomeController {


    @FXML
    private WebView webView;

    public void initialize(){
        webView.getEngine().load("https://media1.tenor.com/images/5578616247515b540d877db81818f009/tenor.gif?itemid=7866344");
    }
}
