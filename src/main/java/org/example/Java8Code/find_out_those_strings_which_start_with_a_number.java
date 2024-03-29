package org.example.Java8Code;

import java.util.Arrays;
import java.util.List;

public class find_out_those_strings_which_start_with_a_number {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");

        listOfStrings.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(System.out::println);
    }
}
