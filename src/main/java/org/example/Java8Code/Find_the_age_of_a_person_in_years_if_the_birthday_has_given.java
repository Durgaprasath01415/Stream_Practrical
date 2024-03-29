package org.example.Java8Code;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Find_the_age_of_a_person_in_years_if_the_birthday_has_given {

    public static void main(String[] args) {
        LocalDate birthDay = LocalDate.of(1985, 01, 23);
        LocalDate today = LocalDate.now();

        System.out.println(ChronoUnit.YEARS.between(birthDay, today));
    }
}
