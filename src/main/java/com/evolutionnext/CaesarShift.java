package com.evolutionnext;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class CaesarShift {
    private final int shift;

    public CaesarShift(int shift) {
       this.shift = shift % 26;
    }

    private char encryptChar(char chr) {
        char temp = (char) (chr + shift);
        if (temp > 'z') {
            temp -= 26;
        }
        return temp;
    }

	public String encrypt(String string) {
        if (string.isEmpty()) return string;
        return string.chars().boxed()
                     .map(integer -> encryptChar((char) integer.intValue()))
                     .collect(StringBuilder::new,
                              StringBuilder::appendCodePoint,
                              StringBuilder::append).toString();
	}
}
