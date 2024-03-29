package org.example.Java8Code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class sort_them_according_to_increasing_order_of_their_length {

    public static void main(String[] args)
    {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

        listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }
}
