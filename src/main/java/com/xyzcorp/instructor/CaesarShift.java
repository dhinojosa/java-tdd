package com.xyzcorp.instructor;

import java.util.Objects;

public class CaesarShift {
    private final int shift;

    public CaesarShift(int shift) {
       this.shift = shift;
    }

    public String encode(String s) {
        Objects.requireNonNull(s, "Encode cannot accept null");
        if (s.isEmpty()) return s;
        return "" + ((char)(s.charAt(0) + shift));
    }
}
