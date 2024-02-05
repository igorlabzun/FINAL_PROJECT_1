package com.crypto.service;

import com.crypto.transformer.FileOperations;
import com.crypto.transformer.TextTransformer;



public class DecryptService {
    final String encryptedFile;
    final String outputFile;
    final int key;

    public DecryptService(String encryptedFile,String outputFile,int key) {
        this.encryptedFile = encryptedFile;
        this.outputFile = outputFile;
        this.key = key;
    }

    public void decryptFile()  {
        String encryptedText = FileOperations.readFile(encryptedFile);
        String decryptedText = TextTransformer.decrypt(encryptedText,key);
        FileOperations.writeFile(outputFile,decryptedText);
    }
}
