package com.xyzcorp.instructor.person;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    Faker faker = new Faker();

    @Test
    void testFirstName() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        LocalDate birthday = LocalDate.ofInstant(faker.date().birthday(20,
            65).toInstant(), ZoneId.systemDefault());
        Person person = Person.of(
            firstName,
            lastName,
            birthday);
        assertThat(person.getFirstName()).isEqualTo(firstName);
        assertThat(person.getLastName()).isEqualTo(lastName);
    }

    @Test
    void testAge() {
        Person person = new Person("Francene", "Gonzales", LocalDate.of(2000,
            2, 12), () -> LocalDate.of(2020, 5, 5));
        Integer age = person.getAge();
        assertThat(age).isEqualTo(20);
    }


}
