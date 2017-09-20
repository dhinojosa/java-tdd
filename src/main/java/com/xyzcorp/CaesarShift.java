package com.xyzcorp;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CaesarShift {

    public static final int ALPHA_SIZE = 26;

    public static String encode(String string, int count) {
        return encodeUsingStreams(string, count);
    }

    public static String encodeUsingFor(String string, int count) {
        if (string == null) throw new NullPointerException("String cannot be null");
        if (string.isEmpty() || count == 0) return string;
        StringBuilder sb = new StringBuilder();
        for (char c : string.toCharArray()) {
            sb.append(shiftChar(c, count));
        }
        return sb.toString();
    }

    public static String encodeUsingStreams(String string, int count) {
        if (string == null) throw new NullPointerException("String cannot be null");
        if (string.isEmpty() || count == 0) return string;
        String result = string.chars()
                               .boxed()
                               .map(integer -> ((char) integer.intValue()))
                               .map(c -> shiftChar(c, count))
                               .map(c -> "" + c)
                               .collect(Collectors.joining());
        return result;
    }

    private static char shiftChar(char c, int count) {
        if (!Character.isAlphabetic(c)) return c;
        char baseChar = Character.isUpperCase(c) ? 'A' : 'a';
        return ((char) ((c - baseChar + count) % ALPHA_SIZE + baseChar));
    }

    public static String decode(String s, int count) {
        return encodeUsingStreams(s, -count);
    }
}
