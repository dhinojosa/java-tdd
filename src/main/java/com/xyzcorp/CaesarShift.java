package com.xyzcorp;

import java.util.stream.Collectors;

public class CaesarShift {

    public static final int ALPHA_SIZE = 26;

    static String encode(String string, int count) {
        return CaesarShift.encodeUsingStreams(string, count);
    }

    static String decode(String s, int count) {
        return CaesarShift.encodeUsingStreams(s, -count);
    }

    private static String encodeUsingStreams(String string, int count) {
        if (string == null) throw new NullPointerException("String cannot be null");
        if (string.isEmpty() || count == 0) return string;
        return string.chars()
                     .boxed()
                     .map(integer -> ((char) integer.intValue()))
                     .map(c -> shiftChar(c, count))
                     .map(c -> "" + c)
                     .collect(Collectors.joining());
    }

    private static char shiftChar(char c, int count) {
        if (!Character.isAlphabetic(c)) return c;
        char baseChar = Character.isUpperCase(c) ? 'A' : 'a';
        return ((char) ((c - baseChar + count % ALPHA_SIZE + ALPHA_SIZE)
                % ALPHA_SIZE + baseChar));
    }


    //    public static String encodeUsingFor(String string, int count) {
//        if (string == null) throw new NullPointerException("String cannot be null");
//        if (string.isEmpty() || count == 0) return string;
//        StringBuilder sb = new StringBuilder();
//        for (char c : string.toCharArray()) {
//            sb.append(shiftChar(c, count));
//        }
//        return sb.toString();
//    }

}
