package com.xyzcorp;

import java.util.Objects;
import java.util.stream.Collectors;

public class CaesarShift {

    public static final String STRING_CANNOT_BE_NULL = "String cannot be null";
    private int shift;

	public CaesarShift(int shift) {
       this.shift = shift;
    }

    public String encode(String s) {
        return encodeWord(s, shift);
    }

    public String decode(String s) {
        return encodeWord(s, -shift);
    }

//    private String encodeWordLambda(String s, int actualShift) {
//        Objects.requireNonNull(s, STRING_CANNOT_BE_NULL);
//        if (s.isEmpty()) return s;
//        return s.chars()
//         .boxed()
//         .map(c -> encodeChar((char) c.intValue(), actualShift))
//         .map(String::valueOf)
//         .collect(Collectors.joining());
//    }

    private String encodeWord(String s, int actualShift) {
        Objects.requireNonNull(s, STRING_CANNOT_BE_NULL);
        if (s.isEmpty()) return s;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(encodeChar(s.charAt(i), actualShift));
        }
        return stringBuilder.toString();
    }

    private char encodeChar(char c, int actualShift) {
	    char bestA = Character.isUpperCase(c) ? 'A' : 'a';
        if (!Character.isLetter(c)) return c;
        return (char)((c - bestA + actualShift % 26 + 26) % 26 + bestA);
    }
}
