package com.xyzcorp.instructor;

import java.util.Objects;

public class CaesarShift {
    public static String encode(String original, int shift) {
        Objects.requireNonNull(original, "String cannot be null");
        if (original.isEmpty()) return original;
        return String.valueOf((char) (original.charAt(0) + shift));
    }
}
