package com.xyzcorp;

import java.time.LocalDate;
import java.util.function.IntPredicate;

public class CheckoutRecord {

	private final LocalDate checkoutDate;
	private String name;

	public CheckoutRecord(String name, LocalDate date) {
		this.name = name;
		this.checkoutDate = date;
	}

	public String getName() {
		return name;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

}
