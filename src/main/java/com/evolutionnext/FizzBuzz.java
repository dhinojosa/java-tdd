package com.evolutionnext;

public class FizzBuzz {
    public static String translate(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        if (num % 3 == 0) stringBuilder.append("Fizz");
        if (num % 5 == 0) stringBuilder.append("Buzz");
        return (stringBuilder.length() == 0) ? "" + num : stringBuilder.toString();
    }
}
