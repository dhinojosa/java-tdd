package com.xyzcorp.instructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Runner {

    public static void main(String[] args) throws URISyntaxException, IOException {
        BufferedReader bufferedReader =
                Files.newBufferedReader(Paths.get(Runner.class.getResource(
                        "/library.txt").toURI()));
        Stream<String> stringStream = bufferedReader.lines();
        List<LibraryRecord> records = LibraryParser.parseStream(stringStream);
        records.sort(Comparator.comparing(LibraryRecord::getCheckoutDate));
        List<LibraryRecord> topFiveList = records.subList(0, 5);

        ExpirationReporter expirationReporter = new ExpirationReporter(LocalDate::now, 5);

        for (LibraryRecord record: topFiveList) {
            System.out.println(record.getName() + " owes the library: $" + expirationReporter.getAmountDue(record.getCheckoutDate()));
        }
    }
}
