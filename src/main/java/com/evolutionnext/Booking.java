package com.evolutionnext;

import java.time.LocalDate;

public class Booking {
    private String name;
    private LocalDate date;

    public Booking(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}
