package com.xyzcorp;

import java.text.ParseException;

public class BookRentingParser {

	public static Customer parseLine(String string) throws ParseException {
		if (string.isEmpty()) throw new ParseException("String cannot be empty", 0);
		return new Customer(string.split("~")[0]);
	}
}
