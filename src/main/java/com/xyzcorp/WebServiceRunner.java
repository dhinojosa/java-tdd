package com.xyzcorp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class WebServiceRunner {
    public static void main(String[] args) throws IOException {


        String urlString = "https://raw.githubusercontent.com/dhinojosa/java-tdd/master/src/main/resources/library.txt";
        URL url = new URL(urlString);
        InputStream inputStream = url.openConnection().getInputStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        List<CheckoutRecord> checkoutRecordList = BookLendingParser.parse(bufferedReader.lines());
        checkoutRecordList.stream()
                          .sorted(Comparator.comparing(CheckoutRecord::getCheckoutDate))
                          .map(cr -> {
                              int penalty = PenaltyCalculator.calculate(100, LocalDate.now(), cr.getCheckoutDate());
                              return cr.getName() + ":" + penalty;
                          }).limit(5).forEach(System.out::println);
    }
}
