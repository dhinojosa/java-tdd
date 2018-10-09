package com.xyzcorp.instructor;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LibraryParserTest {

    @Test
    public void testParseStreamThatIsEmpty() {
        Stream<String> emptyStream = Stream.empty();
        List<LibraryRecord> records = LibraryParser.parseStream(emptyStream);
        assertThat(records).isEmpty();
    }

    @Test
    public void testParseStreamOneElement() {
        //Simplest?
        Stream<String> stringStream = Stream.of("Jim Czenkusch~Warlock " +
                "inspite of itself~2016-04-30");
        List<LibraryRecord> records = LibraryParser.parseStream(stringStream);
        assertThat(records.get(0).getName()).isEqualTo("Jim Czenkusch");
    }

    @Test
    public void testParseStreamThreeElement() {
        //Simplest?
        Stream<String> stringStream = Stream.of(
                "Jim Czenkusch~Warlock inspite of itself~2016-04-30",
                "Amit Sharma~Effective Java~2016-05-31",
                "Lloyd Moore~Paradise Lost~2016-01-10");

        List<LibraryRecord> records = LibraryParser.parseStream(stringStream);
        assertThat(records.get(0).getName()).isEqualTo("Jim Czenkusch");
        assertThat(records.get(2).getTitle()).isEqualTo("Paradise Lost");
    }

    @Test
    public void testParseLineWithTwoFieldsOnly() {
        assertThatThrownBy(() -> LibraryParser.parseLine("Paradise Lost~2018-04-10"))
                .hasMessage("Line should have 3 fields")
                .isInstanceOf(IllegalArgumentException.class);
    }

    //More work to do! Test MORE! Test Aggressively!
}
