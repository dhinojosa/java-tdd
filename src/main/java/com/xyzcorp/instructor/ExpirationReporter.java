package com.xyzcorp.instructor;

import java.time.LocalDate;
import java.util.function.Supplier;

import static java.time.temporal.ChronoUnit.MONTHS;

public class ExpirationReporter {

    private final Supplier<LocalDate> localDateSupplier;
    private final int monthlyPenalty;

    public ExpirationReporter(Supplier<LocalDate> localDateSupplier, int monthlyPenalty) {
        this.localDateSupplier = localDateSupplier;
        this.monthlyPenalty = monthlyPenalty;
    }

    public int getAmountDue(LocalDate checkoutDate) {
        return monthlyPenalty * (int)(MONTHS.between(checkoutDate, localDateSupplier.get().minusDays(1)));
    }
}
