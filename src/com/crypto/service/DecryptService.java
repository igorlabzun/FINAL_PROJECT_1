package com.crypto.service;

import com.crypto.transformer.FileOperations;
import com.crypto.transformer.TextTransformer;

import java.io.IOException;

public class DecryptService {
    final String encryptedFile;

    public DecryptService(String encryptedFile) {

        this.encryptedFile = encryptedFile;
    }

    public void decryptFile() throws IOException {
        String encryptedText = FileOperations.readFile(encryptedFile);
        String decryptedText = TextTransformer.decrypt(encryptedText, 3);
        System.out.println("Розшифрований текст:\n" + decryptedText);
    }
}
