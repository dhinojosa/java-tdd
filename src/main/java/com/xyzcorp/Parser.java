package com.xyzcorp;

import java.io.File;
import java.time.LocalDate;
import java.util.function.Function;
import java.util.stream.Stream;

public class Parser {
    public static final String WRONG_NUMBER_OF_FIELDS_MSG = "Wrong number of Fields";
	public static final String INVALID_DATE_FORMAT_MSG = "Invalid Date Format";
	private final String delimiter;

    public Parser(String delimiter) {
       this.delimiter = delimiter;
    }

    public Checkout parse(String data) {
        String[] strings = data.split(delimiter);
        if (strings.length != 3)
            throw new IllegalArgumentException(WRONG_NUMBER_OF_FIELDS_MSG);
        try {
        	   return new Checkout(new Person(strings[0]),
    				LocalDate.parse(strings[2]),
                    new Book(strings[1]));
        } catch (java.time.format.DateTimeParseException dtp) {
        	    throw new IllegalArgumentException(INVALID_DATE_FORMAT_MSG);
        }
    }

	public Stream<Checkout> parseStream(Stream<String> stream) {
		return stream.map(this::parse);
	}
}
