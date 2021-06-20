package com.xyzcorp.instructor.person;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    @Test
    void testFirstName() {
        Person person = Person.of("Francene", "Gonzales", LocalDate.of(2000,
            2, 12));
        assertThat(person.getFirstName()).isEqualTo("Francene");
    }

    @Test
    void testAge() {
        Person person = new Person("Francene", "Gonzales", LocalDate.of(2000,
            2, 12), () -> LocalDate.of(2020, 5, 5));
        Integer age = person.getAge();
        assertThat(age).isEqualTo(20);
    }
}
