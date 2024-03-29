package org.example.Java8Code;

import java.util.stream.IntStream;

public class Print_first_10_even_numbers {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).map(i -> i * 2).forEach(System.out::println);
    }
}
