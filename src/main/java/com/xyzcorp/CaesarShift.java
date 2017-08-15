package com.xyzcorp;

import java.util.Objects;
import java.util.stream.Collectors;

public class CaesarShift {

	private static final int ALPHA_LENGTH = 26;
	private static final int SMALL_A = 97;
	private static final int BIG_A = 65;
	public static final String STRING_CANNOT_BE_NULL = "String cannot be null";
	private final int shift;
	
	public CaesarShift(int shift) {
		this.shift = shift;
	}

	private char shiftChar(char c, int actualShift) {
		if (!Character.isLetter(c)) return c;
		int preferredA = Character.isUpperCase(c) ? BIG_A : SMALL_A;
		return (char)((c + (actualShift % ALPHA_LENGTH + ALPHA_LENGTH) 
				                                     - preferredA) 
				                                     % ALPHA_LENGTH + preferredA);
	}
	
	private String shiftString(String string, int actualShift) {
		Objects.requireNonNull(string, STRING_CANNOT_BE_NULL);
		if (string.isEmpty()) return "";
		return string
				.chars()
				.boxed()
				.map(i -> "" + shiftChar((char) i.intValue(), actualShift))
				.collect(Collectors.joining());
	}
	
	public String encode(String string) {
		return shiftString(string, shift);
	}

	public String decode(String string) {
		return shiftString(string, -shift);
	}
}
