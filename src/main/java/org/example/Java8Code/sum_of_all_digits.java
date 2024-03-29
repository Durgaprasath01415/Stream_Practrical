package org.example.Java8Code;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class sum_of_all_digits {

    public static void main(String[] args)
    {
        int i = 15623;

        Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));

        System.out.println(sumOfDigits);
    }
}
