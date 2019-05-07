package com.xyzcorp.instructor;

import java.time.LocalDate;
import java.util.stream.Stream;

public class LibraryReader {
    private Stream<String> stream;
    private String delimiter;

    public LibraryReader(Stream<String> stream, String delimiter) {

        this.stream = stream;
        this.delimiter = delimiter;
    }

    public Stream<LibraryRecord> getContents() {
        return stream.map(this::getLibraryRecord);
    }

    private LibraryRecord getLibraryRecord(String s) {
        String[] strings = s.split(delimiter);
        return new LibraryRecord(strings[0], LocalDate.parse(strings[2]));
    }
}
