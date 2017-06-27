package com.xyzcorp;

import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BookRentingParserTest {

	@Test
	public void testParseSingleLineIntoCustomer() throws Exception {
		Customer customer = BookRentingParser.parseLine("Timothy Cheng~Hamlet~2015-12-15");
		assertThat(customer.getName()).isEqualTo("Timothy Cheng");
	}

	@Test
	public void testParseSingleLineIntoCustomerWithSimone() throws Exception {
		Customer customer = BookRentingParser.parseLine("Simone Paganini~Lord of the Rings~2017-03-15");
		assertThat(customer.getName()).isEqualTo("Simone Paganini");
	}

	@Test
	public void testParseSingleLineIntoCustomerWithSimoneAndGetDate() 
			throws Exception {
		Customer customer = BookRentingParser
				 .parseLine("Simone Paganini~Lord of the Rings~2017-03-15");
		assertThat(customer.getCheckoutDate())
		          .isEqualTo(LocalDate.of(2017, 3, 15));
	}
	
	@Test
	public void testParseEmptyString() throws Exception {
		assertThatThrownBy(() -> BookRentingParser.parseLine(""))
		        .hasMessage(BookRentingParser.STRING_CANNOT_BE_EMPTY)
				.isInstanceOf(ParseException.class);
	}
	
	@Test
	public void testParseNoTildes() throws Exception {
		assertThatThrownBy(() -> BookRentingParser.parseLine("Hello"))
		        .hasMessage(BookRentingParser.STRING_MUST_DELIMITED_WITH_A)
				.isInstanceOf(ParseException.class);
	}
	
	@Test
	public void testParseOneTilde() throws Exception {
		assertThatThrownBy(() -> BookRentingParser.parseLine("Hello~Zoom"))
		        .hasMessage(BookRentingParser.NOT_ENOUGH_FIELDS)
				.isInstanceOf(ParseException.class);
	}
	
	@Test
	public void testParseABadDate() throws Exception {
		assertThatThrownBy(() -> BookRentingParser.parseLine("Hello~Zoom~4012"))
		        .hasMessage(BookRentingParser.BAD_DATE)
				.isInstanceOf(ParseException.class);
	}
	
	//More red bar tests are required
	// Like: The checkout date is in the future
	//       When the year is unreasonable, the year 4000 or 2 B.C.
	

	
	
	
}
