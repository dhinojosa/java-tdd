package com.xyzcorp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CheckoutTest {


    @Test
    void testCheckoutCreation() {
        Person person = new Person("Howard Smith");
        Book book = new Book("IT");
        LocalDate date = LocalDate.of(2017, 3, 4);

        Checkout checkout = new Checkout(
                person,
                date,
                book);

        assertAll("Checkout properties",
                () -> {
                    assertThat(checkout.getPerson()).isEqualTo(person);
                    assertThat(checkout.getBook()).isEqualTo(book);
                    assertThat(checkout.getDate()).isEqualTo(date);
                });
    }

    @Test
    void testCheckoutEquality() {
        Person person = new Person("Howard Smith");
        Book book = new Book("IT");
        LocalDate date = LocalDate.of(2017, 3, 4);

        Checkout checkout = new Checkout(
                person,
                date,
                book);

        Checkout checkout2 = new Checkout(
                person,
                date,
                book);

        assertThat(checkout).isEqualTo(checkout2);
    }

    @Test
    void testCheckoutHashCode() {
        Person person = new Person("Howard Smith");
        Book book = new Book("IT");
        LocalDate date = LocalDate.of(2017, 3, 4);

        Checkout checkout = new Checkout(
                person,
                date,
                book);

        Checkout checkout2 = new Checkout(
                person,
                date,
                book);

        assertThat(checkout.hashCode()).isEqualTo(checkout2.hashCode());
    }

    //You have more work to do...
}
