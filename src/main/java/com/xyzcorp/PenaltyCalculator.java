package com.xyzcorp;

import java.time.LocalDate;
import java.util.function.Supplier;
import static java.time.temporal.ChronoUnit.DAYS;

public class PenaltyCalculator {
    private final Supplier<LocalDate> currentDateSupplier;

    public PenaltyCalculator(Supplier<LocalDate> currentDateSupplier) {
       this.currentDateSupplier = currentDateSupplier;
    }

    public double calculate(LocalDate checkoutDate) {
        if (checkoutDate.equals(currentDateSupplier.get())) return 0.0;
        if (checkoutDate.isAfter(currentDateSupplier.get()))
            throw new IllegalArgumentException
                    ("Checkout date must be before todays date");
        long daysBetween = DAYS.between
                (checkoutDate.plusMonths(1), currentDateSupplier.get());
        return daysBetween * 0.17;
    }
}
