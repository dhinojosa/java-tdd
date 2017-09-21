package com.xyzcorp;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.easymock.EasyMock.createMock;

public class ParserTest {

    @Test
    void testParsePerfectLine() {
        Checkout expected = new Checkout(new Person("Beth Brown"),
                LocalDate.of(2013, 3, 31),
                new Book("The Leftovers"));

        String data = "Beth Brown~The Leftovers~2013-03-31";
        Parser parser = new Parser("~");
        Checkout checkout = parser.parse(data);
        assertThat(checkout).isEqualTo(expected);
    }

    @Test
    void testParseOnlyTwoFields() {
        String data = "Beth Brown~The Leftovers";
        Parser parser = new Parser("~");
        assertThatThrownBy(() -> parser.parse(data))
                .hasMessage(Parser.WRONG_NUMBER_OF_FIELDS_MSG)
                .isInstanceOf(IllegalArgumentException.class);
    }


    //GreenBar
    @Test
    void testDifferentDelimeters() {
        Checkout expected = new Checkout(new Person("Beth Brown"),
                LocalDate.of(2013, 3, 31),
                new Book("The Leftovers"));
        String data = "Beth Brown!The Leftovers!2013-03-31";
        Parser parser = new Parser("!");
        Checkout checkout = parser.parse(data);
        assertThat(checkout).isEqualTo(expected);
    }

    @Test
    void testParseOfABadFormattedDate() {
        String data = "Beth Brown~The Leftovers~4/3/2014";
        Parser parser = new Parser("~");
        assertThatThrownBy(() -> parser.parse(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Parser.INVALID_DATE_FORMAT_MSG);
    }


    @Test
    public void testParseFile() {
        Parser parser = new Parser("~");
        Stream<String> strings = Stream.of("Beth Brown~The Leftovers~2013-03-31",
                "Timothy Cheng~Hamlet~2015-12-15");
        Stream<Checkout> checkouts = parser.parseStream(strings);

        assertThat(checkouts).contains(new Checkout(new Person("Beth Brown"),
                LocalDate.of(2013, 3, 31),
                new Book("The Leftovers"))).hasSize(2);
    }

    @Test
    public void testIntegrationTestUsingStream() {
        InputStream inputStream = getClass().getResourceAsStream("/library.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Parser parser = new Parser("~");
        Stream<Checkout> checkoutStream = parser.parseStream(bufferedReader.lines());
        assertThat(checkoutStream).contains(new Checkout(new Person("Beth Brown"),
                LocalDate.of(2013, 3, 31),
                new Book("The Leftovers"))).hasSize(17);
    }


    //A lot more to do....
}
