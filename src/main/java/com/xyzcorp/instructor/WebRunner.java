package com.xyzcorp.instructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import java.util.stream.Stream;

public class WebRunner {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/dhinojosa/java-tdd/master/src/main/resources/library.txt");

        InputStream inputStream = url.openConnection().getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Stream<String> stream = bufferedReader.lines();


        //----Change above this---
        LibraryReader libraryReader = new LibraryReader(stream, "~");
        Stream<LibraryRecord> libraryRecordStream = libraryReader.getContents();

        CalculateFine calculateFine = CalculateFine.create(10);
        libraryRecordStream.sorted(Comparator.comparing(LibraryRecord::getCheckoutDate))
                           .limit(5)
                           .map(r -> r.getName() + ":" + calculateFine.calculate(r.getCheckoutDate()))
                           .forEach(System.out::println);
    }
}
