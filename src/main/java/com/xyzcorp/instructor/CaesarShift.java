package com.xyzcorp.instructor;

import java.util.Objects;

public class CaesarShift {
	public static String encode(String word, int shift) {
		Objects.requireNonNull(word, "Word cannot be null");
		if (word.isEmpty() || shift == 0) return word;
		StringBuilder result = new StringBuilder();
		for (char c : word.toCharArray()) {
			result.append(shiftChar(shift, c));
		}
		return result.toString();
	}

	private static char shiftChar(int shift, char c) {
		return (char) (c + shift);
	}
}
