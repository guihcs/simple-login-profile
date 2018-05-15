package com.ig.dao;

import com.ig.io.IOFiles;
import com.ig.model.User;
import javafx.scene.Node;
import javafx.scene.image.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Application {

    //Interface lista
    private static List<User> bDUsers;
    private static User userDefault;
    private static HashMap<String, javafx.scene.Node> nodeHashMap;

    //Construtor
    public Application ()
    {
        bDUsers =  new LinkedList<>();
    }

    //Adicionar Usuários a lista
    public boolean addUser(User user)
    {
        return (isContains(user)) ? bDUsers.add(user): false;
    }

    //Retorna verdadeiro caso o cpf exista, validando o login do usuário.
    public static boolean login(String cpf)
    {
        for (User user : bDUsers)
        {
            if(cpf.equals(user.getCpf()))
                userDefault = user;
                return true;
        }
        return false;
    }
    //Retorna verdadeiro caso ja exista um usuário com esse CPF.
    private static boolean isContains(User user) {

        for (User u : bDUsers)
        {
            if(u.getCpf().equals(user.getCpf()))
                return true;
        }
        return false;
    }

    //Adiciona o nome no usuário Default
    public Node getNode(String name) {
        userDefault.visitPagesAdd(name);
        return nodeHashMap.get(name);
    }

    //Salva todos os ddos no arquivo
    public void datasSaved() {

        File dir =  new File("C:\\Users\\Iarly Medeiros\\Documents\\Usuarios");
        dir.mkdirs();
        //File names = new File("C:\\Users\\Iarly Medeiros\\Documents\\Acessos");

        for (User u: bDUsers)
        {
            File arq = new File("C:\\Users\\Iarly Medeiros\\Documents\\Usuarios\\" + u.getCpf() + ".txt");

            try
            {
                arq.createNewFile();
                IOFiles.fileWriteAppend(arq,u.toString());
                acessPagesSaved(u);

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    //Salva a lista de acesso em um arquivo com nome dos usuários
    private void acessPagesSaved(User user) {
        File dir =  new File("C:\\Users\\Iarly Medeiros\\Documents\\Acessos");
        dir.mkdirs();

        List<String> list  = user.getAcessPages();

        for (String acess:list) {
            File arq = new File("C:\\Users\\Iarly Medeiros\\Documents\\Acessos\\" + user.getCpf() + ".txt");
            try {
                arq.createNewFile();
                IOFiles.fileWriteAppend(arq,acess);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //Carrega todos os dados
    public boolean loaderDatas(String userfile)
    {
        User user;
        List<String> userList =  IOFiles.fileReader(userfile);

        for (int i = 0; i < userList.size() ; i++)
        {
            String uD[] = userList.get(i).split("#");
            user = new User(new Image(uD[0]),uD[1],uD[2]);

            for (String acess : IOFiles.fileReader("C:\\Users\\Iarly Medeiros\\Documents\\Acessos" + uD[2] + ".txt"))
            {
                user.getAcessPages().add(acess);
            }
        }
        return true;
    }


}
