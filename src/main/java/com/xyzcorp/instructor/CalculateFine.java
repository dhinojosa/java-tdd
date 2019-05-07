package com.xyzcorp.instructor;

import java.time.LocalDate;
import java.util.function.Supplier;

import static java.time.temporal.ChronoUnit.MONTHS;

public class CalculateFine {
    private int amount;
    private Supplier<LocalDate> dateSupplier;

    public CalculateFine(int amount, Supplier<LocalDate> dateSupplier) {
        this.amount = amount;
        this.dateSupplier = dateSupplier;
    }

    public static CalculateFine create(int amount) {
        return new CalculateFine(amount, () -> LocalDate.now());
    }

    public int calculate(LocalDate localDate) {
        return (int) (MONTHS.between(localDate.plusDays(1), dateSupplier.get()) * amount);
    }
}
