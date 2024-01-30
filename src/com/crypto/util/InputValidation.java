package com.crypto.util;

import com.crypto.exeptional.InvalidArgumentException;
import com.crypto.model.Mode;

import java.nio.file.Files;
import java.nio.file.Path;

public class InputValidation {

    public static void validateInput(String[] args){
        if ( args.length < 2 || args.length>3){
            throw new InvalidArgumentException("Arguments is not found!");
        }
    }
    public static void validateCommand(String command){
        boolean isExistCommand = false;
        for (Mode mod : Mode.values()){
            if (mod.toString().equals(command)){
                isExistCommand = true;
                break;
            }
        }
        if (!isExistCommand){
            throw new InvalidArgumentException("Command is not found!");
        }
    }
    public static void validateFilePath(String path){
        if (path.isBlank()){
            throw new InvalidArgumentException("Filename is empty!");
        }
        if (!Files.exists(Path.of(path))){
            throw new InvalidArgumentException("File is not found!");
        }
    }
    public static void validateKey(String key){

        try {
            int keyValue = Integer.parseInt(key);
            if (keyValue < 0) {
                throw new InvalidArgumentException("Key must be a non-negative integer!");
            }
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Invalid key format. Key must be an integer!");
        }
    }

}
