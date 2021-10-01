package com.xyzcorp.instructor.person;

import java.time.LocalDate;
import java.util.function.Supplier;

import static java.time.temporal.ChronoUnit.YEARS;

public class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final Supplier<LocalDate> now;

    public Person(String firstName, String lastName, LocalDate birthday,
                  Supplier<LocalDate> now) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.now = now;
    }

    protected static Person of(
        String firstName, String lastName, LocalDate birthday) {
        return new Person(firstName, lastName, birthday, LocalDate::now);
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return (int) YEARS.between(birthday, now.get());
    }

    public String getLastName() {
        return lastName;
    }
}
