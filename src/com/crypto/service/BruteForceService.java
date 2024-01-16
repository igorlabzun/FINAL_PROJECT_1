package com.crypto.service;

import com.crypto.transformer.FileOperations;
import com.crypto.transformer.TextTransformer;

public class BruteForceService {
    final String encryptedFile;

    public BruteForceService(String encryptedFile) {
        this.encryptedFile = encryptedFile;
    }

    public void bruteForceDecrypt() throws Exception {
        System.out.println(" Розшифровка методом brute-force:");

        for (int key = 0; key < 26; key++) {
            String encryptedText = FileOperations.readFile(encryptedFile);
            String decryptedText = TextTransformer.decrypt(encryptedText, key);
            System.out.println("Зсув " + key + ": " + decryptedText);
        }
    }
}
