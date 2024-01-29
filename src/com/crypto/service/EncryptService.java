package com.crypto.service;

import com.crypto.transformer.FileOperations;
import com.crypto.transformer.TextTransformer;

import java.io.IOException;

public class EncryptService {
    final String inputFile;
    final String outputFile;
    final int key;

    public EncryptService(String inputFile, String outputFile, int key) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.key = key;
    }

    public void encryptFile() {
        String originalText = FileOperations.readFile(inputFile);
        String encryptedText = TextTransformer.encrypt(originalText, key);
        FileOperations.writeFile(outputFile, encryptedText);
    }
}
