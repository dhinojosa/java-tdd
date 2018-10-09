package com.xyzcorp.instructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryParser {

    public static List<LibraryRecord> parseStream(Stream<String> stream) {
        return stream.map(LibraryParser::parseLine).collect(Collectors.toList());
    }

	protected static LibraryRecord parseLine(String s) {
		String[] tokens = s.split("~");
		if (tokens.length != 3) throw new IllegalArgumentException("Line should have 3 fields");
		return new LibraryRecord(tokens[0], tokens[1], LocalDate.parse(tokens[2]));
	}
}
