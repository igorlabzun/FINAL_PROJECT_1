package com.crypto.service;

import com.crypto.transformer.FileOperations;
import com.crypto.transformer.TextTransformer;

public class BruteForceService {
    static String encryptedFile;
    static TextTransformer caesarCipher = new TextTransformer();
    public BruteForceService(String encryptedFile) {

        BruteForceService.encryptedFile = encryptedFile;

    }


    public static void bruteForceDecrypt()  {
        System.out.println(" Розшифровка методом brute-force:");
        caesarCipher.setEnglishAlphabet("abcdefghijklmnopqrstuvwxyz");
        String variable = caesarCipher.getEnglishAlphabet();



        for (int key = 0; key < variable.length() ; key++) {
            String encryptedText = FileOperations.readFile(encryptedFile);
            String decryptedText = TextTransformer.decrypt(encryptedText, key);
            System.out.println("Зсув " + key + ": " + decryptedText);
        }
    }
}



