package com.xyzcorp;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Category(value=UnitTest.class)
public class PenaltyCalculatorTest {

    @Test
    public void testCheckoutDateIsSameAsCurrentDate() throws Exception {
        LocalDate currentDate = LocalDate.of(2017, 4, 1);
        LocalDate checkoutDate = LocalDate.of(2017, 4, 1);
        int result = PenaltyCalculator.calculate(100, currentDate, checkoutDate);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testCheckoutDateIsGreaterCurrentDate() throws Exception {
        LocalDate currentDate = LocalDate.of(2017, 4, 1);
        LocalDate checkoutDate = LocalDate.of(2017, 6, 1);
        assertThatThrownBy(() -> {PenaltyCalculator.calculate(100, currentDate, checkoutDate);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You cannot checkout in the future");

    }

    //GreenBar
    @Test
    public void testCurrentDateIsOneMonthPastCheckoutDate() throws Exception {
        LocalDate currentDate = LocalDate.of(2017, 4, 1);
        LocalDate checkoutDate = LocalDate.of(2017, 3, 1);
        int result = PenaltyCalculator.calculate(100, currentDate, checkoutDate);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testCurrentDateIsOneMonthOneDayPastCheckoutDate() throws Exception {
        LocalDate currentDate = LocalDate.of(2017, 4, 2);
        LocalDate checkoutDate = LocalDate.of(2017, 3, 1);
        int result = PenaltyCalculator.calculate(100, currentDate, checkoutDate);
        assertThat(result).isEqualTo(100);
    }

    //GB
    @Test
    public void testCurrentDateIsOneMonthOneDayDuringALeapYear() throws Exception {
        LocalDate currentDate = LocalDate.of(2016, 2, 29);
        LocalDate checkoutDate = LocalDate.of(2016, 1, 28);
        int result = PenaltyCalculator.calculate(100, currentDate, checkoutDate);
        assertThat(result).isEqualTo(100); //0
    }

    @Test
    public void testCurrentDateIsOneMonthOneDayDuringALeapYearCase2() throws Exception {
        LocalDate currentDate = LocalDate.of(2016, 3, 1);
        LocalDate checkoutDate = LocalDate.of(2016, 1, 31);
        int result = PenaltyCalculator.calculate(100, currentDate, checkoutDate);
        assertThat(result).isEqualTo(0); //0
    }


    @Test
    public void testCurrentDateIsOneMonthOneDayDuringALeapYearCase3() throws Exception {
        LocalDate currentDate = LocalDate.of(2016, 3, 2);
        LocalDate checkoutDate = LocalDate.of(2016, 1, 31);
        int result = PenaltyCalculator.calculate(100, currentDate, checkoutDate);
        assertThat(result).isEqualTo(100); //0
    }

    @Test
    public void testCurrentDateIsOneMonthOneDayDuringALeapYearCase4() throws Exception {
        LocalDate currentDate = LocalDate.of(2017, 1, 16);
        LocalDate checkoutDate = LocalDate.of(2016, 1, 15);
        int result = PenaltyCalculator.calculate(100, currentDate, checkoutDate);
        assertThat(result).isEqualTo(1200); //0
    }

}
