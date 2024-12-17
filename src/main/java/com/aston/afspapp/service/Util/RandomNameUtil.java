package com.aston.afspapp.service.Util;

import java.util.Random;

public final class RandomNameUtil {
    private RandomNameUtil() {}
    public static String createName() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 20;
        Random random = new Random();

        String name = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
