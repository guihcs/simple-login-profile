package com.ig.ui;

import com.ig.main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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

    public static final String LOGIN_LAYOUT_PATH = "../resources/layout_login.fxml";
    public static final String SIGNUP_LAYOUT_PATH = "../resources/layout_signup.fxml";

    public void initialize(){
        loginToggle.fire();
        loginToggle.setSelected(true);
    }

    @FXML
    public void setLoginFragment(){

        if(signupToggle.isSelected()){
            signupToggle.setSelected(false);
        }
        setFragment(LOGIN_LAYOUT_PATH);


    }

    @FXML
    public void setSignupFragment(){
        if(loginToggle.isSelected()){
            loginToggle.setSelected(false);
        }
        setFragment(SIGNUP_LAYOUT_PATH);
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
