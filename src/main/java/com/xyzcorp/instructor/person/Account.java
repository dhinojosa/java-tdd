package com.xyzcorp.instructor.person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class Account {

    private Person person;
    private LocalDate registrationDate;

    public Account() {
    }

    public Account(Person person) {
        this.person = person;
    }

    public Account(Person person, LocalDate registrationDate) {
        this.person = person;
        this.registrationDate = registrationDate;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return createStringJoiner()
            .toString();
    }

    private StringJoiner createStringJoiner() {
        StringJoiner stringJoiner = null;
        try {
            stringJoiner = new StringJoiner(", ",
                Account.class.getSimpleName() + "[", "]")
                .add("person=" + person)
                .add("registrationDate=" + registrationDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringJoiner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(person, account.person) && Objects.equals(registrationDate, account.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, registrationDate);
    }
}
