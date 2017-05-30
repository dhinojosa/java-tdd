package com.evolutionnext;

import java.util.stream.Collectors;

public class CaesarShift {
    private final int shift;

    public CaesarShift(int shift) {
        this.shift = shift % 26;
    }

    /*
    private int convert(int c, int shift) {
		if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) return c;
		int offset = Character.isLowerCase(c) ? 'a' : 'A';
		int charShifted = c + shift - offset;
		int alphaLen = 'Z' - 'A' + 1;
		return (charShifted % alphaLen + alphaLen) % alphaLen + offset;
	}
     */

    private char encryptChar(char chr) {
        if ((chr < 'A' || chr > 'Z') && (chr < 'a' || chr > 'z')) return chr;
        char temp = (char) (chr + shift);
        return (temp > 'z' || (temp > 'Z' && temp < 'a')) ? (char) (temp - 26) : temp;
    }

    public String encrypt(String string) {
        if (string == null) throw
                new NullPointerException("String cannot be null");
        if (string.isEmpty()) return string;
        return string.chars().boxed()
                     .map(integer -> "" + encryptChar((char) integer.intValue()))
                     .collect(Collectors.joining());
    }
}
