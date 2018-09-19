package com.xyzcorp;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Stream;

public class LibraryParser {
    public static Checkout parseLine(String line) {
        Objects.requireNonNull(line, "Line cannot be null");
        String[] tokens = line.split("~");
        if (tokens.length != 3) throw new IllegalArgumentException(
                "Incorrect number of fields");
        return new Checkout(tokens[0], tokens[1], LocalDate.parse(tokens[2]));
    }

    public static Stream<Checkout> parseStream(Stream<String> stream) {
        return stream.map(LibraryParser::parseLine);
    }
}
