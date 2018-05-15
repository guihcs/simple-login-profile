package com.ig.ui;

import com.ig.dao.Application;
import com.ig.main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField cpfField;


    @FXML
    public void login(){

        if(Application.login(cpfField.getText())) {

            try {
                Parent node = FXMLLoader.load(getClass().getResource("../resources/layout_home.fxml"));
                Main.setScene(new Scene(node));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {

           showErrorAlert();
        }

    }




    private void showErrorAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Login");
        alert.setHeaderText(null);
        alert.setContentText("Usuário não cadastrado.");
        alert.showAndWait();
    }
}
