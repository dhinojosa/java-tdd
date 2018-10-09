package com.xyzcorp.instructor;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpirationReporterTest {
    @Test
    public void testWhereTodaysDateAndCheckoutDateAreTheSame(){
        ExpirationReporter expirationReporter = new ExpirationReporter(() -> LocalDate.of(2018, 10, 9), 5);
        int actualResult = expirationReporter.getAmountDue(LocalDate.of(2018,10,9));
        assertThat(actualResult).isEqualTo(0);
    }

    //Green Bar
    @Test
    public void testWhereTodaysDateIsOneMonthAfterCheckoutDate(){
        ExpirationReporter expirationReporter = new ExpirationReporter(() -> LocalDate.of(2018, 11, 9), 5);
        int actualResult = expirationReporter.getAmountDue(LocalDate.of(2018,10,9));
        assertThat(actualResult).isEqualTo(0);
    }

    @Test
    public void testWhereTodaysDateIsOneMonthAndOneDayAfterCheckoutDate(){
        ExpirationReporter expirationReporter = new ExpirationReporter(() -> LocalDate.of(2018, 11, 10), 5);
        int actualResult = expirationReporter.getAmountDue(LocalDate.of(2018,10,9));
        assertThat(actualResult).isEqualTo(5);
    }

    //We can add more!

}
