package com.ig.io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IOFiles {

    public static void fileWriteAppend(File file, String conteudo){

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write(conteudo);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileWrite(File file, String conteudo){

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(conteudo);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<String> fileReader(File file){

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            List<String> userLines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()).equals(null)){
                userLines.add(line);
            }
            return userLines;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
