package com.xyzcorp.instructor;

public class CaesarShift {

    public static final int ALPHA_SIZE = 26;
    public static final char SMALL_A = 'a';

    public static String encode(String string, int shift) {
        if (string == null)
            throw new NullPointerException("String cannot be null");
        if (string.isEmpty() || shift == 0) return string;
        char currentChar = string.charAt(0);
        if (Character.isAlphabetic(currentChar)) {
            return String.valueOf((char)((currentChar - SMALL_A + shift) % ALPHA_SIZE + SMALL_A));
        } else {
            return String.valueOf(currentChar);
        }
    }
}
