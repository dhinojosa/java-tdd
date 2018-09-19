package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.MONTHS;
import static org.assertj.core.api.Assertions.assertThat;

public class CalcFeeTest {
    @Test
    public void testCurrentAndCheckoutDateAreEqual() {
        LocalDate currentDate = LocalDate.of(2018, 9, 18);
        LocalDate checkoutDate = LocalDate.of(2018, 9, 18);
        CalcFee cf = new CalcFee(10, () -> currentDate);
        long fee = cf.calculate(checkoutDate);
        assertThat(fee).isEqualTo(0);
    }

    @Test
    public void testCurrentAndCheckoutDateAreExactlyOneMonth() {
        LocalDate currentDate = LocalDate.of(2018, 10, 18);
        LocalDate checkoutDate = LocalDate.of(2018, 9, 18);
        CalcFee cf = new CalcFee(10, () -> currentDate);
        long fee = cf.calculate(checkoutDate);
        assertThat(fee).isEqualTo(0);
    }

    @Test
    public void testCurrentAndCheckoutDateAreExactlyOneMonthOneDay() {
        LocalDate currentDate = LocalDate.of(2018, 10, 19);
        LocalDate checkoutDate = LocalDate.of(2018, 9, 18);
        CalcFee cf = new CalcFee(10, () -> currentDate);
        long fee = cf.calculate(checkoutDate);
        assertThat(fee).isEqualTo(10);
    }

    @Test
    public void testCurrentAndCheckoutDateAreExactlyTwoMonthsOneDay() {
        LocalDate currentDate = LocalDate.of(2018, 11, 19);
        LocalDate checkoutDate = LocalDate.of(2018, 9, 18);
        CalcFee cf = new CalcFee(10, () -> currentDate);
        long fee = cf.calculate(checkoutDate);
        assertThat(fee).isEqualTo(20);
    }

}
