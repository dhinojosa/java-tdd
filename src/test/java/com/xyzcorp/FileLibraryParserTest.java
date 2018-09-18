package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLibraryParserTest {

    @Test
    public void testParseFile() {
        String data = "Jim Price~The Girl In The Spider's Web~2015-08-15\n" +
                "Hao Guan~Ender's Game~2012-02-12";

        Stream<String> stream = Arrays.stream(data.split("\n"));
        FileLibraryParser fileLibraryParser =
                new FileLibraryParser(s ->
                        new Checkout("Bob", "Book", LocalDate.of(2018,1,1)));
        Stream<Checkout> checkouts = fileLibraryParser.parseStream(stream);
        assertThat(checkouts).hasSize(2);
    }
}
