package com.crypto.transformer;

public class TextTransformer {
    private static String englishAlphabet = "abcdefghijklmnopqrstuvwxyz";
    public static String encrypt(String text, int key){
        StringBuilder encryptedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                encryptedText.append((char) ((character - base + key) % englishAlphabet.length() + base));
            } else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }
    public String getEnglishAlphabet(){
        return englishAlphabet;
    }
    public void setEnglishAlphabet(String variable){
        englishAlphabet  = String.valueOf(variable);
    }
    public static String decrypt(String text, int key) {

        return encrypt(text, englishAlphabet.length() - key);
    }
}
