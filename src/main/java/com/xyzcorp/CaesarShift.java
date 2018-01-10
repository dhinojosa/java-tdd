package com.xyzcorp;

import java.util.stream.Collectors;

public class CaesarShift {

	private static final int ALPHA_SIZE = 26;
	private final int shift;

	public CaesarShift(int shift) {
	   this.shift = shift;
	}

	public String encodeDinesh(String string) {
		if (string == null) throw new NullPointerException("String is null");
		if (string.isEmpty()) return string;
		//return String.valueOf((char)(string.charAt(0) + shift));
		return string.chars()
		             .mapToObj(c -> Character.toString((char)((c + shift))))
		             .collect(Collectors.joining());
	}

	public String innerEncode(String string, int actualShift) {
		if (string == null) throw new NullPointerException("String is null");
		if (string.isEmpty()) return string;

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			char preferredA = 'a';
			if (Character.isUpperCase(c)) {
				preferredA = 'A';
			}
			if (Character.isAlphabetic(c)) {
				c = (char) (((string.charAt(i) + (actualShift % ALPHA_SIZE)
						- preferredA
						+ ALPHA_SIZE) %
						ALPHA_SIZE) + preferredA);
			}
			builder.append(c);
		}
		return builder.toString();
	}

	//Greg
	public String encode(String string) {
		return innerEncode(string, shift);
	}

	public String decode(String string) {
		return innerEncode(string, -shift);
	}
}
