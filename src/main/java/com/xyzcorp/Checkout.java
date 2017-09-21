package com.xyzcorp;

import java.time.LocalDate;
import java.util.Objects;

public class Checkout {

	private Person person;
	private LocalDate date;
	private Book book;
	
	public Checkout(Person person, LocalDate date, Book book) {
		this.person = person;
		this.date = date;
		this.book = book;
	}

	public Person getPerson() {
		return person;
	}

	public Book getBook() {
		return book;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Checkout checkout = (Checkout) o;
		return Objects.equals(person, checkout.person) &&
				Objects.equals(date, checkout.date) &&
				Objects.equals(book, checkout.book);
	}

	@Override
	public int hashCode() {
		return Objects.hash(person, date, book);
	}
}
