package com.crypto.transformer;

public class TextTransformer {
    public static String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                encryptedText.append((char) ((character - base + key) % 26 + base));
            } else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String text, int key) {
        return encrypt(text, 26 - key); //
    }
}
