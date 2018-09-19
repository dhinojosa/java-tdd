package com.xyzcorp;

import java.time.LocalDate;
import java.util.function.Supplier;

import static java.time.temporal.ChronoUnit.MONTHS;

public class CalcFee {
    private final Supplier<LocalDate> localDateSupplier;
    private final int amount;

    public CalcFee(int amount, Supplier<LocalDate> localDateSupplier) {
        this.amount = amount;
        this.localDateSupplier = localDateSupplier;
    }

    public long calculate(LocalDate checkoutDate) {
        return amount * MONTHS.between(checkoutDate.plusDays(1), localDateSupplier.get());
    }
}
