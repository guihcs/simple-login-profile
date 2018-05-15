package com.ig.ui;

import com.ig.dao.Application;
import com.ig.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class ProfileViewController {

    @FXML
    private Circle imageView;
    @FXML
    private Label nameLabel;
    @FXML
    private Label cpfLabel;
    @FXML
    private Label startDateLabel;
    @FXML
    private Label finalDateLabel;
    @FXML
    private Label pages;

    public void initialize(){
        User currentUser = Application.getUserDefault();

        imageView.setFill(new ImagePattern(currentUser.getImage()));

        nameLabel.setText("Nome: " + currentUser.getName());
        cpfLabel.setText("CPF: " + currentUser.getCpf());
        startDateLabel.setText("Data inicial: " + currentUser.getStartDate());
        finalDateLabel.setText("Data final: " + currentUser.getFinalDate());

        StringBuilder pagesText = new StringBuilder();
        pagesText.append("Acessos: ");

        for (String acess : currentUser.getAcessPages()) {
            pagesText.append(acess).append(",");
        }

        pages.setText(pagesText.toString());
    }
}
