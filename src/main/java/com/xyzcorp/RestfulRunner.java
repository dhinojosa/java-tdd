package com.xyzcorp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLStreamHandler;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class RestfulRunner {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL url = new URL("https://raw.githubusercontent.com/dhinojosa/java-tdd/master/src/main/resources/library.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Stream<String> lines = bufferedReader.lines();

        CalcFee calcFee = new CalcFee(10, LocalDate::now);
        Stream<Checkout> checkoutStream = LibraryParser.parseStream(lines);
        Stream<Checkout> sortedCheckoutStream = checkoutStream.sorted(
                Comparator.comparing(Checkout::getDate));
        sortedCheckoutStream.limit(5).forEach(c -> {
            System.out.println(c.getName() + " owes me " + calcFee.calculate(c.getDate()));
        });
    }
}
