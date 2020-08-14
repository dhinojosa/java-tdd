package com.xyzcorp.instructor;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void testCreatePerson() {
        Person person =
            new Person("Adolfo", "Foliaco",
                LocalDate.of(2000,5, 30), () -> LocalDate.of(2020, 8, 14));
        assertThat(person.getFirstName()).isEqualTo("Adolfo");
        assertThat(person.getLastName()).isEqualTo("Foliaco");
        assertThat(person.getBirthdate()).isEqualTo(LocalDate.of(2000,5, 30));
    }

    @Test
    void testPersonAge() {
        Person person =
            new Person("Adolfo", "Foliaco",
                LocalDate.of(2000,5, 30),  () -> LocalDate.of(2020, 8, 14));
        assertThat(person.getAge()).isEqualTo(20);
    }

    @Test
    void testPersonAgeWhoseBirthdayHasntHappenedYet() {
        Person person = new Person("Peterson", "Cemoin",
            LocalDate.of(2000, 9, 15),  () -> LocalDate.of(2020, 8, 14));
        assertThat(person.getAge()).isEqualTo(19);
    }

    @Test
    void testFactoryPersonForMyEndUsersIntegrationTest() {
        Person person =
            Person.of("Peterson", "Cemoin", LocalDate.of(2000, 9, 15));
        assertThat(person.getFirstName()).isEqualTo("Adolfo");
        assertThat(person.getLastName()).isEqualTo("Foliaco");
        assertThat(person.getBirthdate()).isEqualTo(LocalDate.of(2000,5, 30));
    }
}
