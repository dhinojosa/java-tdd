package com.xyzcorp.instructor;

import java.time.LocalDate;
import java.util.function.Supplier;

import static java.time.temporal.ChronoUnit.YEARS;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private Supplier<LocalDate> getCurrentDate;

    protected Person(String firstName, String lastName,
                  LocalDate birthdate,
                  Supplier<LocalDate> getCurrentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.getCurrentDate = getCurrentDate;
    }

    public static Person of(String firstName, String lastName, LocalDate birthdate) {
        return new Person(firstName, lastName, birthdate, LocalDate::now);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getAge() {
        return (int) YEARS.between(birthdate, getCurrentDate.get());
    }
}
