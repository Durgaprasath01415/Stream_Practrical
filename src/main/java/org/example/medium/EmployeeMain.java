package org.example.medium;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeMain {

    public static void main(String[] args) {
        List<Employee> empList = getEmpList();
        empList.stream().filter(e -> e.getGender().equalsIgnoreCase("female")).forEach(System.out::println);
        empList.stream().filter(e->e.getNewJoiner().equalsIgnoreCase("true")).forEach(System.out::println);
        empList.stream().sorted(Comparator.comparing(Employee::getRating)).forEach(System.out::println);
        empList.stream().sorted(Comparator.comparing(Employee::getRating).reversed()).forEach(System.out::println);
        empList.stream().sorted(Comparator.comparing(Employee::getRating))
                .sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
        boolean b = empList.stream().allMatch(e -> e.getSalary() > 1000);
        System.out.println(b);
        OptionalInt max = empList.stream().mapToInt(Employee::getSalary).max();
        System.out.println(max);
        empList.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);
        empList.stream().max(Comparator.comparing(Employee::getRating)).ifPresent(System.out::println);
        empList.stream().min(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);
        empList.stream().min(Comparator.comparing(Employee::getRating)).ifPresent(System.out::println);
        Map<String, List<Employee>> collect = empList.stream().collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(collect);
    }

    public static List<Employee> getEmpList() {
        return Arrays.asList(
                new Employee("59-385-1088", "Zacharias", "Schwerin", "zchwerin@gmail.com", "Male", "True", 101146, 0),
                new Employee("73-274-6476", "Kyle", "Frudd", "kfrudd1@ovh.net", "Male", "FALSE", 29310, 2),
                new Employee("85-939-9584", "Axe", "Gumb", "agumb2@twitter.com", "Female", "FALSE", 62291, 4),
                new Employee("08-180-8292", "Robinet", "Batterham", "rbatterham3@last.fm", "Male", "FALSE", 142439, 4),
                new Employee("21-825-2623", "Ulick", "Burrel", "uburrel4@google.ru", "Male", "FALSE", 128764, 5),
                new Employee("66-708-5539", "Tailor", "Ridding", "Ridding", "Female", "FALSE", 152924, 4),
                new Employee("81-697-2363", "Joete", "Braybrooke", "jbraybrooke6@prnewswire.com", "Male", "TRUE", 128907, 0),
                new Employee("63-019-1110", "Elroy", "Baverstock", "ebaverstock7@ehow.com", "Male", "TRUE", 2510, 0)
        );
    }


}
