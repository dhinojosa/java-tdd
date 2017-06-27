package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testCustomerWithPenaltyThatsTheSameAsTodayIsZero() 
			throws Exception {
		Customer customer = new Customer
				("Antonio Banderas", LocalDate.of(2015, 12, 15));
		assertThat(customer.getPenalty(LocalDate.of(2015, 12, 15)))
		       .isEqualTo(0);
	}
	
	//NoRedBar
	@Test
	public void testCustomerWithPenaltyWhereWeAreExactlyAMonth() 
			throws Exception {
		Customer customer = new Customer
				("Antonio Banderas", LocalDate.of(2015, 12, 15));
		assertThat(customer.getPenalty(LocalDate.of(2016, 1, 15)))
		       .isEqualTo(0);
	}
	
	@Test
	public void testCustomerWithPenaltyWhereWeAreExactlyAMonthAndADay() 
			throws Exception {
		Customer customer = new Customer
				("Antonio Banderas", LocalDate.of(2015, 12, 15));
		assertThat(customer.getPenalty(LocalDate.of(2016, 1, 16)))
		       .isEqualTo(10);
	}

	@Test
	public void testCustomerWithPenaltyTwoMonthsHardcore() 
			throws Exception {
		Customer customer = new Customer
				("Antonio Banderas", LocalDate.of(2015, 12, 15));
		assertThat(customer.getPenalty(LocalDate.of(2016, 2, 15)))
		       .isEqualTo(20);
	}
	
	
}
