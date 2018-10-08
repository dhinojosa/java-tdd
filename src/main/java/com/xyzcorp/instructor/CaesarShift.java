package com.xyzcorp.instructor;

public class CaesarShift {

    public static final int ALPHA_SIZE = 26;
    public static final char SMALL_A = 'a';
    public static final char CAPITAL_A = 'A';

    private CaesarShift() {}

    public static String encode(String string, int shift) {
        if (string == null)
            throw new NullPointerException("String cannot be null");
        if (string.isEmpty() || shift == 0) return string;
        StringBuilder builder = new StringBuilder();
        for (Character c : string.toCharArray()) {
           builder.append(shiftChar(shift, c));
        }
        return builder.toString();
    }

    private static char shiftChar(int shift, char currentChar) {
        char actualChar = currentChar;
        char preferredA = Character.isUpperCase(currentChar) ? CAPITAL_A : SMALL_A;
        if (Character.isAlphabetic(currentChar)) {
            actualChar = (char)((currentChar - preferredA + shift + ALPHA_SIZE) % ALPHA_SIZE + preferredA);
        }
        return actualChar;
    }

    public static String decode(String string, int shift) {
        return encode(string, -shift);
    }
}
