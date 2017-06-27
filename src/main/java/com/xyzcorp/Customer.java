package com.xyzcorp;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.MONTHS;

public class Customer {

	private String name;
	private LocalDate checkoutDate;

	public Customer(String name) {
		this.name = name;
	}

	public Customer(String name, LocalDate checkoutDate) {
		this.name = name;
		this.checkoutDate = checkoutDate;
	}

	public String getName() {
		return name;
	}

	public long getPenalty(LocalDate todaysDate) {
		long monthsBetween = MONTHS.between(checkoutDate, todaysDate);
		if (monthsBetween == 1 && 
				checkoutDate.getDayOfMonth() == todaysDate.getDayOfMonth()) return 0;
		return MONTHS.between(checkoutDate, todaysDate) * 10;
	}

	protected LocalDate getCheckoutDate() {
		return checkoutDate;
	}

}
