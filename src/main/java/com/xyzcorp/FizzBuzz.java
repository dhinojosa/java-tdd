package com.xyzcorp;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static String convert(int i) {
        if (i == 3) return "Fizz";
        return String.valueOf(i);
    }

    public static void main(String[] args) {
        IntStream.range(1, 100).mapToObj(FizzBuzz::convert).forEach(System
                .out::println);

        for (int i = 1; i < 101; i++) {
            System.out.println(convert(i));
        }
    }
}
