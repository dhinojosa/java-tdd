package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LibraryParserTest {

    @Test
    public void testParseLine() {
        //"Zoom~Two".split("~");
        //LocalDate.parse("2012-02-12");

        String line = "Hao Guan~Ender's Game~2012-02-12";
        Checkout co = LibraryParser.parseLine(line);
        assertThat(co.getName()).isEqualTo("Hao Guan");
        assertThat(co.getTitle()).isEqualTo("Ender's Game");
        assertThat(co.getDate()).isEqualTo(LocalDate.of(2012,2,12));
    }

    @Test
    public void testParseLineWithAnotherPerson() {
        String line = "Vivek Nag~Alchemist~2009-04-20";
        Checkout co = LibraryParser.parseLine(line);
        assertThat(co.getName()).isEqualTo("Vivek Nag");
        assertThat(co.getTitle()).isEqualTo("Alchemist");
        assertThat(co.getDate()).isEqualTo(LocalDate.of(2009,4,20));
    }

    @Test
    public void testParseLineWithTwoFieldsRemovingDate() {
        String line = "Vivek Nag~Alchemist";
        assertThatThrownBy(() -> LibraryParser.parseLine(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Incorrect number of fields");
    }

    @Test
    public void testParseLineWithNull() {
        assertThatThrownBy(() -> LibraryParser.parseLine(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Line cannot be null");
    }

    @Test
    public void testParseStreamWithTwoElements() {
        String data = "Jim Price~The Girl In The Spider's Web~2015-08-15\n" +
                "Hao Guan~Ender's Game~2012-02-12";
        Stream<String> stream = Arrays.stream(data.split("\n"));
        Stream<Checkout> checkoutStream = LibraryParser.parseStream(stream);
        List<Checkout> checkoutList = checkoutStream.collect(Collectors.toList());
        assertThat(checkoutList.get(0).getName()).isEqualTo("Jim Price");
        assertThat(checkoutList.get(1).getName()).isEqualTo("Hao Guan");
        assertThat(checkoutList).hasSize(2);
    }
    //there are likely be a lot more tests
}
