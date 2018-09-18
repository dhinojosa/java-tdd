package com.xyzcorp;

import java.time.LocalDate;

public class Checkout {
    private final String name;
    private final String title;
    private final LocalDate date;

    public Checkout(String name, String title, LocalDate date) {
       this.name = name;
       this.title = title;
       this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }
}
