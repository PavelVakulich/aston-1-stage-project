package com.aston.afspapp.service.Util;

import java.util.Random;

public final class RandomPasswordUtil {
    private RandomPasswordUtil() {}
    public static String createPassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String num = "0123456789";
        String specialsChars = "!№;%:?*()_+=-";
        String combination = upper + lower + specialsChars + num;
        int lengthPassword = 8;
        char[] password = new char[lengthPassword];
        Random r = new Random();
        for (int i = 0; i < lengthPassword; i++) {
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }
        return new String(password);
    }
}
