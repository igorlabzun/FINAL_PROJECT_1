package com.crypto;


import com.crypto.model.Mode;
import com.crypto.service.BruteForceService;
import com.crypto.service.DecryptService;
import com.crypto.service.EncryptService;
import com.crypto.util.InputValidation;



public class Runstart {
    private static final int COMMAND_ARGUMENTS_POSITION = 0;
    private static final int FILE_PATH_ARGUMENTS_POSITION = 1;
    private static final int KEY_ARGUMENTS_POSITION = 2;


    public static void run(String[] args){
        InputValidation.validateInput(args);
        InputValidation.validateCommand(args[Runstart.COMMAND_ARGUMENTS_POSITION]);
        InputValidation.validateFilePath(args[Runstart.FILE_PATH_ARGUMENTS_POSITION]);
        InputValidation.validateKey(args[Runstart.KEY_ARGUMENTS_POSITION]);

        String inputFile = args[Runstart.FILE_PATH_ARGUMENTS_POSITION];
        String encryptedFile = inputFile.replace(".txt", "[ENCRYPT].txt");
        int key = Integer.parseInt(args[Runstart.KEY_ARGUMENTS_POSITION]);


        Mode mode = Mode.valueOf(args[Runstart.COMMAND_ARGUMENTS_POSITION]);
        switch (mode) {
            case ENCRYPT:
                new EncryptService(inputFile, encryptedFile, key).encryptFile();
                break;
            case DECRYPT:
                String decryptedOutputFile ="text[DECRYPT].txt";

                new DecryptService(encryptedFile,decryptedOutputFile,key).decryptFile();
                break;
            case BRUTE_FORCE:
                BruteForceService.bruteForceDecrypt();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mode);
        }

    }

}
