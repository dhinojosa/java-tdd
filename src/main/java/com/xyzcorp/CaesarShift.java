package com.xyzcorp;

public class CaesarShift {

	private final int shift;

	public CaesarShift(int shift) {
	   this.shift = shift;
	}

	public String encode(String string) {
		if (string == null) throw new NullPointerException("String is null");
		if (string.isEmpty()) return string;
		return String.valueOf((char)(string.charAt(0) + shift));
	}

}
