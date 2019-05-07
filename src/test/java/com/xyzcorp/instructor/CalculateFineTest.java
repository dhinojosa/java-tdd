package com.xyzcorp.instructor;

import org.junit.Test;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.MONTHS;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculateFineTest {
    @Test
    public void testCheckoutDateIsEqualToTodayDateWithFineAs10() {
        CalculateFine calculateFine = new CalculateFine(10, () -> LocalDate.of(2018, 1, 3));
        int result = calculateFine.calculate(LocalDate.of(2018, 1, 3));
        assertThat(result).isEqualTo(0);
    }


    //GreenBar
    @Test
    public void testCheckoutDateIsOneMonthFromToTodayDateWithFineAs10() {
        CalculateFine calculateFine = new CalculateFine(10, () -> LocalDate.of(2018, 2, 3));
        int result = calculateFine.calculate(LocalDate.of(2018, 1, 3));
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testCheckoutDateIsOneMonthOneDayFromToTodayDateWithFineAs10() {
        CalculateFine calculateFine = new CalculateFine(10, () -> LocalDate.of(2018, 2, 4));
        int result = calculateFine.calculate(LocalDate.of(2018, 1, 3));
        assertThat(result).isEqualTo(10);
    }

    //GreenBar
    @Test
    public void testCheckoutDateIsTwoMonthOneDayFromTodayDateWithFineAs10() {
        CalculateFine calculateFine = new CalculateFine(10, () -> LocalDate.of(2018, 3, 4));
        int result = calculateFine.calculate(LocalDate.of(2018, 1, 3));
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void testFactoryToCreateCalculator() {
        CalculateFine calculateFine = CalculateFine.create(20);
        assertThat(calculateFine).isNotNull();
    }
}
