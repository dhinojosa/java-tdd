package com.xyzcorp.instructor;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaesarShift {

    public static final int ALPHA_SIZE = 26;
    public static final char SMALL_A = 'a';

    public static String encode(String string, int shift) {
        if (string == null)
            throw new NullPointerException("String cannot be null");
        if (string.isEmpty() || shift == 0) return string;
        StringBuilder builder = new StringBuilder();
        for (Character c : string.toCharArray()) {
           builder.append(shiftChar(shift, c));
        }
        return builder.toString();
//        Stream<Integer> integerStream = string.chars().boxed();
//        Stream<String> characterStream =
//                integerStream.map(i -> String.valueOf(shiftChar(shift, (char) i.intValue())));
//        return characterStream.collect(Collectors.joining());
    }

    private static char shiftChar(int shift, char currentChar) {
        char actualChar = currentChar;
        if (Character.isAlphabetic(currentChar)) {
            actualChar = (char)((currentChar - SMALL_A + shift) % ALPHA_SIZE + SMALL_A);
        }
        return actualChar;
    }
}
