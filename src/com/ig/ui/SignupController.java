package com.ig.ui;

import com.ig.dao.Application;
import com.ig.main.Main;
import com.ig.material.view.RippleEffect;
import com.ig.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;

public class SignupController {

    @FXML
    private Circle imageView;
    @FXML
    private TextField nameField;
    @FXML
    private TextField cpfField;
    @FXML
    private Button flatButton;

    private Image image;

    public void initialize(){
        RippleEffect.installEffect(flatButton);
        image = new Image(getClass().getResource("../material/icons/avatar.png").toExternalForm());
        imageView.setFill(new ImagePattern(image));
    }


    @FXML
    public void signup(){
        User newUser = new User(image, nameField.getText(), cpfField.getText());

        if(!Application.addUser(newUser)){
            Alert messageAlert = new Alert(Alert.AlertType.WARNING);
            messageAlert.setHeaderText(null);
            messageAlert.setTitle("Signup");
            messageAlert.setContentText("Usuário já cadastrado.");
            messageAlert.showAndWait();
        }

        Main.frameController.setLoginFragment();
    }

    @FXML
    public void editImage(){
        java.nio.file.Path path = Main.getFile();
        if(path != null){
            System.out.println(path.toUri());
            image = new Image(path.toUri().toString());
            imageView.setFill(new ImagePattern(image));
        }
    }
}
