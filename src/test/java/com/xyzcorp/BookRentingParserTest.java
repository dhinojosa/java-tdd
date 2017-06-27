package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.ParseException;

import org.junit.Test;

public class BookRentingParserTest {

	@Test
	public void testParseSingleLineIntoCustomer() throws Exception {
		Customer customer = BookRentingParser.parseLine("Timothy Cheng~Hamlet~2015-12-15");
		assertThat(customer.getName()).isEqualTo("Timothy Cheng");
	}

	@Test
	public void testParseSingleLineIntoCustomerWithSimone() throws Exception {
		Customer customer = BookRentingParser.parseLine("Simone Paganini~Lord of the Rings~2017-3-15");
		assertThat(customer.getName()).isEqualTo("Simone Paganini");
	}

	@Test
	public void testParseEmptyString() throws Exception {
		assertThatThrownBy(() -> BookRentingParser.parseLine(""))
		        .hasMessage("String cannot be empty")
				.isInstanceOf(ParseException.class);
	}
}
