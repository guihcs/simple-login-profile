package com.ig.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FrameController {

    @FXML
    private ToggleButton loginToggle;
    @FXML
    private ToggleButton signupToggle;

    @FXML
    private AnchorPane container;



    public void initialize(){
        loginToggle.fire();
        loginToggle.setSelected(true);
    }

    @FXML
    public void setLoginFragment(){

        if(signupToggle.isSelected()){
            signupToggle.setSelected(false);
        }
        setFragment("../resources/layout_login.fxml");


    }

    @FXML
    public void setSignupFragment(){
        if(loginToggle.isSelected()){
            loginToggle.setSelected(false);
        }
        setFragment("../resources/layout_signup.fxml");
    }


    private void setFragment(String path){
        if(container.getChildren().size() > 0){
            container.getChildren().clear();
        }
        try {
            Node node = FXMLLoader.load(getClass().getResource(path));

            container.getChildren().add(node);
            AnchorPane.setTopAnchor(node, 20.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
