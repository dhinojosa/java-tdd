package com.xyzcorp.instructor;

import java.util.Objects;

public class CaesarShift {
    private final int shift;

    public CaesarShift(int shift) {
        this.shift = shift;
    }

    public String encode(String string) {
        Objects.requireNonNull(string, "String cannot be null");
        if (string.isEmpty()) return string;
        char c = (char) (string.charAt(0) + shift);
        return String.valueOf(c);
    }
}
