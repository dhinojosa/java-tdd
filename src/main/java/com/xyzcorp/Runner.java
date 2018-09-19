package com.xyzcorp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) throws URISyntaxException, IOException {
        CalcFee calcFee = new CalcFee(10, LocalDate::now);
        URI uri = Runner.class.getResource("/library.txt").toURI();
        Stream<String> lines = Files.lines(Paths.get(uri));
        Stream<Checkout> checkoutStream = LibraryParser.parseStream(lines);
        Stream<Checkout> sortedCheckoutStream = checkoutStream.sorted(
                Comparator.comparing(Checkout::getDate));
        sortedCheckoutStream.limit(5).forEach(c -> {
            System.out.println(c.getName() + " owes me " + calcFee.calculate(c.getDate()));
        });


    }
}
