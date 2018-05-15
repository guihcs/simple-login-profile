package com.ig.ui;

import com.ig.main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField cpfField;


    @FXML
    public void login(){
        try {
            Parent node = FXMLLoader.load(getClass().getResource("../resources/layout_home.fxml"));
            Main.setScene(new Scene(node));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
