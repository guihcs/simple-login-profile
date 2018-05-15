package com.ig.io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IOFiles {

    public static void fileWriteAppend(File path, String data) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileWrite(String path, String data) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<String> fileReader(String path) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
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
