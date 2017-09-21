package com.xyzcorp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PenaltyCalculatorTest {

    @Test
    void testNoPenaltyWhereCheckoutDateIsTheSameAsSuppliedDate() {
        LocalDate checkoutDate =
                LocalDate.of(2015, 3, 1);
        Supplier<LocalDate> currentDateSupplier = () -> checkoutDate;
        PenaltyCalculator penaltyCalculator =
                new PenaltyCalculator(currentDateSupplier);
        assertThat(penaltyCalculator.calculate(checkoutDate)).isEqualTo(0);
    }

    @Test
    void testPenaltyWhereFakeTodayDateIsOneMonthAfterCheckoutDate() {
        LocalDate checkoutDate =
                LocalDate.of(2015, 3, 2);
        Supplier<LocalDate> currentDateSupplier = () ->
                LocalDate.of(2015, 4, 3);
        PenaltyCalculator penaltyCalculator =
                new PenaltyCalculator(currentDateSupplier);
        assertThat(penaltyCalculator.calculate(checkoutDate)).isEqualTo(0.17);
    }


    @Test
    void testPenaltyCheckoutDateAfterSuppliedTodayDate() {
        LocalDate checkoutDate =
                LocalDate.of(2015, 5, 2);
        Supplier<LocalDate> currentDateSupplier = () ->
                LocalDate.of(2015, 4, 3);
        PenaltyCalculator penaltyCalculator =
                new PenaltyCalculator(currentDateSupplier);

        assertThatThrownBy(() -> {
            penaltyCalculator.calculate(checkoutDate);
        }).hasMessage("Checkout date must be before todays date")
          .isInstanceOf(IllegalArgumentException.class);
    }

    //Be more aggressive!
}
