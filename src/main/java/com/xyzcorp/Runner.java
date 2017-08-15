package com.xyzcorp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        InputStream inputStream = Runner.class.getResourceAsStream("/library.txt");
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
