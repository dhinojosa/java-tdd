package com.xyzcorp.instructor;

public class CaesarShift {
    public static String encode(String string, int shift) {
        if (string.isEmpty()) return string;
        return String.valueOf((char)(string.charAt(0) + shift));
    }
}
