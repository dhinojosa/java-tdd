package com.xyzcorp.instructor;

import java.time.LocalDate;

public class LibraryRecord {
    private String name;
    private LocalDate parse;

    public LibraryRecord(String name, LocalDate parse) {
        this.name = name;
        this.parse = parse;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCheckoutDate() {
        return parse;
    }
}
