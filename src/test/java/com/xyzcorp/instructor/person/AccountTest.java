package com.xyzcorp.instructor.person;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AccountTest {

    @Test
    void testCreationOfAccount() {
        //Fira Mono
        Account account = new Account(new Person("Andrew", "Goodspeed",
            LocalDate.of(2010, 11, 10), LocalDate::now));

        System.out.println(account.getPerson().getFirstName());


    }
}
