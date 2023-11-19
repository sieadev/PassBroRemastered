package dev.siea.passbro.util;

import java.util.UUID;

public class Generator {
    public static String getRandomPassword(int length, boolean uppercase, boolean lowercase, boolean numbers, boolean specialChas){
        return generateRandomPassword(length,uppercase,lowercase,numbers,specialChas);
    }

    public static UUID generateUUID(){
        return generateRandomUUID();
    }

    private static UUID generateRandomUUID() {
        return UUID.randomUUID();
    }

    private static String generateRandomPassword(int length, boolean uppercase, boolean lowercase, boolean numbers, boolean specialChas){
        return null;
    }
}
