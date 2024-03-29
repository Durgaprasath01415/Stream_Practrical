package org.example.Java8Code;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Reverse_each_word_of_a_string {

    public static void main(String[] args) {
        String str = "Java Concept Of The Day";

        String reversedStr = Arrays.stream(str.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));

        System.out.println(reversedStr);
    }
}
