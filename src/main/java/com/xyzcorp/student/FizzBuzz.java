package com.xyzcorp.student;

public class FizzBuzz {
    public static String convert(int i) {
    	if (i % 5 == 0 && i % 3 == 0) return "FizzBuzz";
    	if (i % 3 == 0) return "Fizz";
    	if (i % 5 == 0) return "Buzz";
        return String.valueOf(i);
    }

    public static void main(String[] args) {
        printOneToOneHundredFizzBuzz();
    }

    //IO, Untestable
    private static void printOneToOneHundredFizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(convert(i));
        }
    }
}
