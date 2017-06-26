package com.xyzcorp;

import java.util.stream.Collectors;

public class CaesarShift {
    private final int shift;
    public static final int ALPHA_LENGTH = 26;
    public static final char LOWERCASE_Z = 'z';
    public static final char CAPITAL_Z = 'Z';

    public CaesarShift(int shift) {
        this.shift = shift;
    }

    private char encodeChar(char c, int actualShift) {
        if (!Character.isAlphabetic(c)) return c;
        int maxValue = Character.isLowerCase(c) ? LOWERCASE_Z : CAPITAL_Z;
        int calc = c + actualShift;
        if (calc > maxValue) calc -= ALPHA_LENGTH;
        return (char) calc;
    }

    private String process(String string, int tempShift) {
        if (string == null) throw new NullPointerException("String cannot be null");
        tempShift %= 26;
        final int actualShift = tempShift > 0 ? tempShift : tempShift + 26;

        if (string.isEmpty() || actualShift == 0) {
            return string;
        }
        return string.chars().boxed()
                     .map(i -> "" + encodeChar((char) i.intValue(), actualShift))
                     .collect(Collectors.joining());
    }

    public String encode(String string) {
        return process(string, shift);
    }

    public String decode(String string) {
        return process(string, -shift);
    }

}
