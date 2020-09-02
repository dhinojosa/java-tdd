package com.xyzcorp.instructor;

import java.util.stream.Collectors;

public class CaesarShift {
    private final int shift;
    public static final char LOWER_CASE_A = 'a';
    public static final int ALPHA_SIZE = 26;

    public CaesarShift(int shift) {
        this.shift = shift;
    }

    public String encode(String s) {
        if (s == null)
            throw new NullPointerException("Encode cannot accept a null " +
                "String");
        if (s.isEmpty()) return s;

        return s.chars()
                .boxed()
                .map(this::shiftChar)
                .collect(Collectors.joining());
    }

    private String shiftChar(Integer i) {
        return String.valueOf(shiftChar((char) i.intValue()));
    }

    private char shiftChar(char letter) {
        return (char) ((((letter - LOWER_CASE_A) + shift) % ALPHA_SIZE) + LOWER_CASE_A);
    }
}
