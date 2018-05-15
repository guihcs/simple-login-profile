package com.ig.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    public static void fileWrite(String path, List<String> lines) {

        Path filePath = Paths.get(path);

        try {
            Files.createDirectories(filePath.getParent());
            PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(filePath));
            for (String line : lines) {
                printWriter.println(line);
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static List<String> fileReader(String path) {

        Path filePath = Paths.get(path);

        try {
            if(Files.exists(filePath))
                return Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new LinkedList<>();
    }

}
