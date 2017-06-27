package com.xyzcorp;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class BookRentingParser {

	public static final String STRING_MUST_DELIMITED_WITH_A = "String must delimited with a ~";
	public static final String STRING_CANNOT_BE_EMPTY = "String cannot be empty";
	public static final String TILDE = "~";
	public static final String NOT_ENOUGH_FIELDS = "String doesn't contain enough fields";
	public static final String BAD_DATE = "Date is not in the right format";

	public static Customer parseLine(String string) throws ParseException {
		if (string.isEmpty())
			throw new ParseException(STRING_CANNOT_BE_EMPTY, 0);
		String[] tokens = string.split(TILDE);
		if (tokens.length == 1)
			throw new ParseException(STRING_MUST_DELIMITED_WITH_A, string.length());
		if (tokens.length < 3)
			throw new ParseException(NOT_ENOUGH_FIELDS, string.length());
		LocalDate checkoutDate = null;
		try {
			checkoutDate = LocalDate.parse(tokens[2]);
		} catch (DateTimeParseException dtpe) {
            throw new ParseException(BAD_DATE, dtpe.getErrorIndex());
		}
		return new Customer(tokens[0], checkoutDate);
	}
}
