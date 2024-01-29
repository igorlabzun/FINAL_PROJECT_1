package com.crypto.transformer;

import java.io.*;

public class FileOperations {
    public static String readFile(String filePath)  {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader((filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (Exception e) {
            System.err.println("Error");
        }
        return content.toString();
    }

    public static void writeFile(String filePath, String content)  {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter((filePath)))) {
            bw.write(content);
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
}
