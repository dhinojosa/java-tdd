package com.xyzcorp.instructor;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LibraryReaderTest {
    
    //Opt 2
    //Inputs?
    // 1. Stream of Strings
    // 2. Delimiter
    //Outputs?


    @Test
    public void testStreamOfElementWithDelimiter() {
        String data = "Sarah Smith~To Kill a Mockingbird~2014-11-19";
        Stream<String> stream = Stream.of(data);
        
        LibraryReader libraryReader = new LibraryReader(stream, "~");
        Stream<LibraryRecord> recordList = libraryReader.getContents();
        LibraryRecord libraryRecord = recordList.findFirst().get();
        assertThat(libraryRecord.getName()).isEqualTo("Sarah Smith");
    }


    @Test
    public void testStreamOfElementWithDifferentPersonWithDelimiter() {
        Stream<String> stream = Stream.of("Vivek Nag~Alchemist~2009-04-20",
                "Daniel Hinojosa~Beautiful Flowers~2013-10-20");

        LibraryReader libraryReader = new LibraryReader(stream, "~");
        Stream<LibraryRecord> recordList = libraryReader.getContents();
        LibraryRecord libraryRecord = recordList.skip(1).findFirst().get();
        assertThat(libraryRecord.getName()).isEqualTo("Daniel Hinojosa");
    }

    @Test
    public void testStreamOfElementWithDelimiterRetrievingDate() {
        String data = "Sarah Smith~To Kill a Mockingbird~2014-11-19";
        Stream<String> stream = Stream.of(data);

        LibraryReader libraryReader = new LibraryReader(stream, "~");
        Stream<LibraryRecord> recordList = libraryReader.getContents();
        LibraryRecord libraryRecord = recordList.findFirst().get();
        assertThat(libraryRecord.getCheckoutDate()).isEqualTo(LocalDate.of(2014,11,19));
    }


}
