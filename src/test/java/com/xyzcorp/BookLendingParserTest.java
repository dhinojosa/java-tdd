package com.xyzcorp;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Category(value=UnitTest.class)
public class BookLendingParserTest {

    @Test
    public void testParseEmptyStream() throws Exception {
        Stream<String> emptyStream = Stream.empty();
        List<CheckoutRecord> records = BookLendingParser.parse(emptyStream);
    	    assertThat(records).isEmpty();
    }

    @Test
    public void testParseASingleLine() throws Exception {
        Stream<String> oneItemStream = Stream.of("Jim Price~The Girl In The Spider's Web~2015-08-15");
        List<CheckoutRecord> records = BookLendingParser.parse(oneItemStream);
    	    assertThat(records).hasSize(1);
    }

    @Test
    public void testParseASingleLineAndEnsureTheName() throws Exception {
        Stream<String> oneItemStream = Stream.of("Jim Price~The Girl In The Spider's Web~2015-08-15");
        List<CheckoutRecord> records = BookLendingParser.parse(oneItemStream);
    	    assertThat(records.get(0).getName()).isEqualTo("Jim Price");
    }

    @Test
    public void testParseASingleLineAndEnsureDiffName() throws Exception {
        Stream<String> oneItemStream = Stream.of("Rajiv Ghandhi~The Girl In The Spider's Web~2015-08-15");
        List<CheckoutRecord> records = BookLendingParser.parse(oneItemStream);
    	    assertThat(records.get(0).getName()).isEqualTo("Rajiv Ghandhi");
    }

    @Test
    public void testParseASingleLineAndEnsureTheDate() throws Exception {
        Stream<String> oneItemStream = Stream.of("Jim Price~The Girl In The Spider's Web~2015-08-15");
        List<CheckoutRecord> records = BookLendingParser.parse(oneItemStream);
    	    assertThat(records.get(0).getCheckoutDate()).isEqualTo(LocalDate.of(2015, 8, 15));
    }

    @Test
    public void testParseASingleLineThatIsEmpty() throws Exception {
        assertThatThrownBy(() -> {BookLendingParser.getCheckoutRecord("  ");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("String cannot be blank");
    }

    //BE MORE AGGRESSIVE, Do PROBABLY 5 - 10 more
}
