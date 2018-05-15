package com.ig.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FrameController {

    @FXML
    private AnchorPane container;

    public void initialize(){
        try {
            Node node = FXMLLoader.load(getClass().getResource("../resources/layout_login.fxml"));
            container.getChildren().add(node);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
