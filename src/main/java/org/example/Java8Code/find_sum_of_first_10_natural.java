package org.example.Java8Code;

import java.util.stream.IntStream;

public class find_sum_of_first_10_natural {

    public static void main(String[] args) {
        int sum = IntStream.range(1, 11).sum();

        System.out.println(sum);
    }
}
