package com.xyzcorp.instructor.caesarshift;

import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isUpperCase;

public class CaesarShift {
    private static final int ALPHA_SIZE = 26;
    private final int shift;

    public CaesarShift(int i) {
        this.shift = i % ALPHA_SIZE;
    }

    public String encode(String s) {
        return shiftString(s, shift);
    }

    public String decode(String s) {
        return shiftString(s, -shift);
    }

    private String shiftString(String s, int actualShift) {
        Objects.requireNonNull(s, "Original string cannot be null");
        return s
            .chars()
            .boxed()
            .map(i -> shiftCharAsString(actualShift, i))
            .collect(Collectors.joining());
    }

    private String shiftCharAsString(int actualShift, Integer i) {
        return String.valueOf(shiftCharacter((char) i.intValue(), actualShift));
    }

    private char shiftCharacter(char c, int actualShift) {
        char preferredA = isUpperCase(c) ? 'A' : 'a';
        if (!isAlphabetic(c)) return c;
        return ((char)
            ((c - preferredA + actualShift + ALPHA_SIZE) %
                ALPHA_SIZE + preferredA));
    }
}
