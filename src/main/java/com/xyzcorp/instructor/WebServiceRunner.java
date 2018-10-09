package com.xyzcorp.instructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class WebServiceRunner {

    public static void main(String[] args) throws URISyntaxException, IOException {
        BufferedReader bufferedReader = URLStreamConverter.convert("https://raw" +
                ".githubusercontent.com/dhinojosa/java-tdd/master/src/main" +
                "/resources/library.txt");

        List<LibraryRecord> records = LibraryParser.parseStream(bufferedReader.lines());
        records.sort(Comparator.comparing(LibraryRecord::getCheckoutDate));
        List<LibraryRecord> topFiveList = records.subList(0, 5);

        ExpirationReporter expirationReporter = new ExpirationReporter(LocalDate::now, 5);

        for (LibraryRecord record: topFiveList) {
            System.out.println(record.getName() + " owes the library: $" +
                    expirationReporter.getAmountDue(record.getCheckoutDate()));
        }
    }
}
