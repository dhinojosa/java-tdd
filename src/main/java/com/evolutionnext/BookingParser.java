package com.evolutionnext;

import java.time.LocalDate;

public class BookingParser {
    public static Booking parseLine(String data) {
        String[] strings = data.split("~");
        if(strings.length < 3)
            throw new RuntimeException("Invalid number of fields");
        return new Booking(strings[0],
                LocalDate.parse(strings[2]));
    }
}
