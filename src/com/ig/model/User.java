package com.ig.model;

import javafx.scene.Node;
import javafx.scene.image.Image;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private static SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");


    public static User getFromData(String data){
        User user = new User();
        String[] dataPieces = data.split("#");
        Image image = new Image(dataPieces[0]);

        user.setImage(image);
        user.setName(dataPieces[1]);
        user.setCpf(dataPieces[2]);
        try {
            Date startDate = !dataPieces[3].equals("none") ? dateFormat.parse(dataPieces[3]) : null;
            Date finalDate = !dataPieces[4].equals("none") ? dateFormat.parse(dataPieces[4]) : null;


            user.setStartDate( startDate);
            user.setFinalDate(finalDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

        String startDateText = startDate != null ? dateFormat.format(startDate) : "none";
        String finalDateText = finalDate != null ? dateFormat.format(finalDate) : "none";

        return String.format("%s#%s#%s#%s#%s",image.getUrl(),name,cpf,startDateText,finalDateText);

    }






}
