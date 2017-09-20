package com.xyzcorp;

import java.util.Objects;

public class CaesarShift {

	private final int shift;

	public CaesarShift(int shift) {
	    this.shift = shift;
	}

	public String encode(String string) {
		Objects.requireNonNull(string,
				"String cannot be null");
		if (shift == 0) return string;
		final int LITTLE_A = 96;
		return "" + (char)((((string.charAt(0) - LITTLE_A) + shift) % 26)
				             + LITTLE_A);
	}
}
