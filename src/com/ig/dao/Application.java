package com.ig.dao;

import com.ig.io.IOFiles;
import com.ig.model.User;
import javafx.scene.Node;
import javafx.scene.image.Image;
import java.io.File;
import java.util.*;

public class Application {

    //Interface lista
    private static List<User> bDUsers = new ArrayList<>();
    private static User userDefault;
    private static Map<String, String> nodeHashMap;

    static{
        bDUsers =  new LinkedList<>();
        nodeHashMap = Map.of("profile", "",
                "aranha",
               Application.class.getResource("../material/movies/Aranha.mp4").toExternalForm(),
                "iron",
                Application.class.getResource("../material/movies/Iron.mp4").toExternalForm(),
                "minion",
                Application.class.getResource("../material/movies/Minion.mp4").toExternalForm(),
                "pixar",
                Application.class.getResource("../material/movies/Pixar.mp4").toExternalForm());
    }
    //Construtor
    public Application ()
    {


    }

    //Adicionar Usuários a lista
    public static boolean addUser(User user){
        if(!containsUser(user)){
            bDUsers.add(user);
            return true;
        }else {
            return false;
        }
    }

    public static void logout(){
        if(userDefault != null) userDefault.setFinalDate(Calendar.getInstance().getTime());
    }

    //Retorna verdadeiro caso o cpf exista, validando o login do usuário.
    public static boolean login(String cpf)
    {
        for (int i = 0; i < bDUsers.size(); i++) {
            User user = bDUsers.get(i);
            if(cpf.equals(user.getCpf())) {
                userDefault = user;
                userDefault.setStartDate(Calendar.getInstance().getTime());
                return true;
            }

        }
        return false;
    }
    //Retorna verdadeiro caso ja exista um usuário com esse CPF.
    private static boolean containsUser(User user) {

        return bDUsers.contains(user);

    }

    public static User getUserDefault(){
        return userDefault;
    }


    //Adiciona o nome no usuário Default
    public static String getMedia(String name) {
        userDefault.visitPagesAdd(name);
        return nodeHashMap.get(name);
    }

    //Salva todos os ddos no arquivo
    public static void saveData(String basePath) {

        File dir =  new File(basePath);
        dir.mkdirs();
        //File names = new File("C:\\Users\\Iarly Medeiros\\Documents\\Acessos");
        List<String> userData = new LinkedList<>();
        for (User user: bDUsers)
        {
            saveAccessPages(basePath + "/UserAccess/", user);
            userData.add(user.toString());
        }
        IOFiles.fileWrite(basePath + "/UserFiles/Users.txt", userData);

    }

    //Salva a lista de acesso em um arquivo com nome dos usuários
    private static void saveAccessPages(String basePath, User user) {

        List<String> list  = user.getAcessPages();
        String filePath = String.format("%s/%s.txt", basePath, user.getCpf());
        IOFiles.fileWrite(filePath, list);

    }

    //Carrega todos os dados
    public static boolean loadData(String basePath, String userfile)
    {

        List<String> userList =  IOFiles.fileReader(basePath + userfile);

        for (String userData : userList) {
            User user = User.getFromData(userData);
            List<String> accesses = IOFiles.fileReader(basePath + "/UserAccess/" + user.getCpf() + ".txt");
            user.setAcessPages(accesses);
            bDUsers.add(user);
        }
        return true;
    }


}
