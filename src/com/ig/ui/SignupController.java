package com.ig.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class SignupController {

    @FXML
    private Circle imageView;
    @FXML
    private TextField nameField;
    @FXML
    private TextField cpfField;

    public void initialize(){
        Image startImage = new Image(getClass().getResource("../material/icons/avatar.png").toExternalForm());
        imageView.setFill(new ImagePattern(startImage));
    }


    @FXML
    public void signup(){

    }
}
