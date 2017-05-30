package com.evolutionnext;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingParserTest {

    @Test
    public void testStreamStringFromAResource() throws Exception {
        String data = "Sarah Smith~To Kill a Mockingbird~2014-11-19\n" +
                      "Mimansha Bhargav~Lost Symbol~2015-01-05";

        List<String> result = Stream.of(data.split("\n")).collect(Collectors.toList());
        assertThat(result).hasSize(2);
    }

    @Test
    public void testStreamWithParseLine() throws Exception {
        String data = "Sarah Smith~To Kill a Mockingbird~2014-11-19\n" +
                "Mimansha Bhargav~Lost Symbol~2015-01-05\n" +
                "Feroz Rehman~Ender's Game~2013-02-20";

        List<Booking> result = Stream
                .of(data.split("\n"))
                .map(s -> BookingParser.parseLine(s))
                .sorted(new Comparator<Booking>() {
                    @Override
                    public int compare(Booking o1, Booking o2) {
                        return o1.getDate().compareTo(o2.getDate());
                    }
                })
                .limit(5)
                .collect(Collectors.toList());
        assertThat(result).hasSize(3);
        assertThat(result.get(0).getName()).isEqualTo("Feroz Rehman");
    }

//    @Test
//    public void testParseOfStreamResourceToBreakItUp() throws Exception {
//        String data = "Sarah Smith~To Kill a Mockingbird~2014-11-19\n" +
//                "Mimansha Bhargav~Lost Symbol~2015-01-05";
//
//        List<String> result = Stream.of(data.split("\n")).map(s -> parseLine(s)).collect(Collectors.toList());
//        assertThat(result).hasSize(2);
//    }

    @Test
    public void testParseSingleLineThatIsPerfect() {
        String data = "Beth Brown~The Leftovers~2013-03-31";
        Booking booking = BookingParser.parseLine(data);
        assertThat(booking.getName()).isEqualTo("Beth Brown");
        assertThat(booking.getDate()).isEqualTo(LocalDate.of(2013,03,31));
    }

    @Test
    public void testParseSingleLineThatIsDifferentData() {
        String data = "Natalia Maciejowska~Solaris~2017-05-30";
        Booking booking = BookingParser.parseLine(data);
        assertThat(booking.getName()).isEqualTo("Natalia Maciejowska");
        assertThat(booking.getDate()).isEqualTo(LocalDate.of(2017,05,30));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testParseSingleLineThatHasABadDate() {
        String data = "Natalia Maciejowska~Solaris~2017-45-30";
        thrown.expect(DateTimeParseException.class);
        BookingParser.parseLine(data);
    }

    @Test
    public void testParseSingleLineThatHasAMoreThanThreeField() {
        String data = "Natalia Maciejowska~Solaris~2017-05-30~Quick Reader";
        Booking booking = BookingParser.parseLine(data);
        assertThat(booking.getName()).isEqualTo("Natalia Maciejowska");
        assertThat(booking.getDate()).isEqualTo(LocalDate.of(2017,05,30));
    }

    @Test
    public void testParseSingleLineThatHasALessThanThreeFields() {
        String data = "Natalia Maciejowska~2017-05-30";
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Invalid number of fields");
        BookingParser.parseLine(data);
    }
}
