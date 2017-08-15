package com.xyzcorp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class PenaltyCalculator {
    public static int calculate(int penalty, LocalDate currentDate, LocalDate checkoutDate) {
        if (checkoutDate.isAfter(currentDate)) throw new IllegalArgumentException("You cannot checkout in the future");
        long months = ChronoUnit.MONTHS.between(checkoutDate, currentDate.minusDays(1));
        return (int) (months * penalty);
    }
}
