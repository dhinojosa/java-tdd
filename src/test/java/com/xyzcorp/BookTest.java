package com.xyzcorp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void testPropertyOfBook() {
        Book book = new Book("Roses");
        assertThat(book.getTitle()).isEqualTo("Roses");
    }

    @Test
    void testEqualityOfBook() {
        Book book = new Book("Roses");
        Book book2 = new Book("Roses");
        assertThat(book).isEqualTo(book2);
    }

    @Test
    void testHashCodeOfBook() {
        Book book = new Book("Roses");
        Book book2 = new Book("Roses");
        assertThat(book.hashCode()).isEqualTo(book2.hashCode());
    }

    //You have more work to do...
}