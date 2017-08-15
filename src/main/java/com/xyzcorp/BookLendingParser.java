package com.xyzcorp;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookLendingParser {

	public static List<CheckoutRecord> parse(Stream<String> streamOfStrings){
		return streamOfStrings
				 .map(BookLendingParser::getCheckoutRecord)
				 .collect(Collectors.toList());
	}

	protected static CheckoutRecord getCheckoutRecord(String s) {
		if (s.trim().isEmpty()) throw new IllegalArgumentException("String cannot be blank");
		String name = s.split("~")[0];
		LocalDate checkoutDate = LocalDate.parse(s.split("~")[2]);
		return new CheckoutRecord(name, checkoutDate);
	}
}
