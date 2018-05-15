package com.ig.model;

import javafx.scene.Node;
import javafx.scene.image.Image;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class User {

    private Image image;
    private String name;
    private String cpf;
    private Date startDate;
    private Date finalDate;
    private List<String> acessPages;
    //Adicionado para formatar o Date
    private SimpleDateFormat dateFormat;


    public static User getFromData(String data){
        User user = new User();
        String[] dataPieces = data.split("#");
        Image image = new Image(dataPieces[0]);

        user.setImage(image);
        user.setName(dataPieces[1]);
        user.setCpf(dataPieces[2]);
        //user.setStartDate(dataPieces[3]);
        //user.setFinalDate(dataPieces[4]);
        return user;
    }

    //Construtor default
    public User() {
        acessPages = new LinkedList<>();
    }

    //Construtor
    public User(Image image, String name, String cpf) {
        this.image = image;
        this.name = name;
        this.cpf = cpf;
        this.acessPages = acessPages;
        this.acessPages =  new LinkedList<>();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public List<String> getAcessPages() {
        return acessPages;
    }

    public void setAcessPages(List<String> acessPages) {
        this.acessPages = acessPages;
    }

    public boolean visitPagesAdd(String name){

        for (String visit: acessPages) {
            if(!visit.equals(name))
                return acessPages.add(name);
        }
        return false;
    }

    @Override
    public String toString() {

        dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(startDate);

        return String.format("%s#%s#%s#%s#%s",image.getUrl(),name,cpf,dateFormat.format(startDate),dateFormat.format(finalDate));

    }






}
