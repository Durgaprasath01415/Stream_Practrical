package org.example.Java8Code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class join_the_strings_with_prefix_suffix_and_delimiter {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");

        String joinedString = listOfStrings.stream().collect(Collectors.joining(", ", "[", "]"));

        System.out.println(joinedString);
    }
}
