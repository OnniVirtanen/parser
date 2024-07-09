package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class InputReader {

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line); // Do not append new line characters
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert StringBuilder to String and return
        return content.toString();
    }

}