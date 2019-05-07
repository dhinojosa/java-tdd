package com.xyzcorp.instructor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        InputStream inputStream = Runner.class.getResourceAsStream(
                "/library.txt");
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Stream<String> stream = bufferedReader.lines();

        LibraryReader libraryReader = new LibraryReader(stream, "~");
        Stream<LibraryRecord> libraryRecordStream = libraryReader.getContents();

        CalculateFine calculateFine = CalculateFine.create(10);
        libraryRecordStream.sorted(Comparator.comparing(LibraryRecord::getCheckoutDate))
                           .limit(5)
                           .map(r -> r.getName() + ":" + calculateFine.calculate(r.getCheckoutDate()))
                           .forEach(System.out::println);
    }
}
