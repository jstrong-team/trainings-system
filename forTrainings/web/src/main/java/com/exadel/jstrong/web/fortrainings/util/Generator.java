package com.exadel.jstrong.web.fortrainings.util;

import java.util.Random;

/**
 * Created by Anton on 05.08.2015.
 */
public class Generator {

    private static final String VALID_CHARS = "abcdefghijklmnopqrstuvwxyzABCEDFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String generateString(int length) {
        int count = VALID_CHARS.length();
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append(VALID_CHARS.charAt(random.nextInt(count - 1)));
        }
        return str.toString();
    }

}
