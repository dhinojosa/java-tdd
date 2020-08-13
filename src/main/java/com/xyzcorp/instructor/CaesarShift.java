package com.xyzcorp.instructor;

import java.util.Objects;
import java.util.stream.Collectors;

public class CaesarShift {
    public static String encode(String string, int shift) {
        Objects.requireNonNull(string, "null is not a valid input");
        if (string.isEmpty()) return string;
        return string.chars()
              .boxed()
              .map(i -> encodeChar((char) i.intValue(), shift))
              .map(String::valueOf)
              .collect(Collectors.joining());
    }

    private static char encodeChar(char c, int shift) {
        char whichA = Character.isUpperCase(c) ? 'A' : 'a';
        if (!Character.isAlphabetic(c)) return c;
        return (char) (((c - whichA + shift + 26) % 26) + whichA);
    }
}
