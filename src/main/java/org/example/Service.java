package org.example;

import org.example.Practical.Customer;
import org.example.Practical.Order;
import org.example.Practical.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Service {
    public static void main(String[] args) {
        Product pr = new Product(1L, "book 1", "Book", 12.0, null);
        Product pr2 = new Product(2L, "book 2", "Book", 13.0, null);
        Product pr3 = new Product(3L, "book 3", "Book", 14.0, null);
        Product pr4 = new Product(4L, "book 4", "Book", 10.0, null);
        Product pr5 = new Product(5L, "bady", "Baby", 10.0, null);
        Product pr6 = new Product(6L, "Toy 1", "Toys", 12.0, null);
        List<Product> productList = new ArrayList<>(Arrays.asList(pr, pr2, pr3, pr4, pr5, pr6));

        Set<Product> productSet = new HashSet<>();
        productSet.add(pr);
        productSet.add(pr2);
        productSet.add(pr3);
        productSet.add(pr4);
        productSet.add(pr5);

        //Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100
        List<Product> book = productList.stream().filter(e -> e.getCategory().equals("Book"))
                .filter(e -> e.getPrice() > 10).collect(Collectors.toList());
        System.out.println(book);

        Customer customer1 = new Customer(1L, "prasath", 2);
        Customer customer2 = new Customer(2L, "prasath", 3);
        Customer customer3 = new Customer(3L, "prasath", 1);

        Order order1 = new Order(1L, LocalDate.of(2021, 2, 10), LocalDate.of(2021, 3, 10), "On the way", customer1, productSet);
        Order order2 = new Order(2L, LocalDate.now(), LocalDate.MAX, "out for delivery", customer2, productSet);
        Order order3 = new Order(3L, LocalDate.now(), LocalDate.MAX, "Packing", customer3, productSet);
        Order order4 = new Order(4L, LocalDate.now(), LocalDate.MAX, "On the way", customer1, productSet);
        Order order5 = new Order(5L, LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 15), "On the way", customer1, productSet);
        Order order6 = new Order(6L, LocalDate.of(2021, 3, 14), LocalDate.of(2021, 3, 15), "On the way", customer1, productSet);
        List<Order> orderList = new ArrayList<>(Arrays.asList(order1, order2, order3, order4, order5, order6));

        //Exercise 2 — Obtain a list of order with products belong to category “Baby”
        List<Order> baby = orderList.stream().filter(e -> e.getProducts()
                        .stream().anyMatch(b -> b.getCategory().equalsIgnoreCase("Baby")))
                .collect(Collectors.toList());
        System.out.println(baby);

        //Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
        List<Double> toys = productList.stream().filter(e -> e.getCategory().equals("Toys")).map(e -> e.getPrice() * 0.9).collect(Collectors.toList());
        System.out.println(toys);

        //Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
        List<Order> collect = orderList.stream()
                .filter(e -> e.getCustomer().getTier().equals("2"))
                .filter(e -> e.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(e -> e.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
                .collect(Collectors.toList());
        System.out.println(collect);

        //Exercise 5 — Get the cheapest products of “Books” category
        Optional<Product> min = productList.stream()
                .filter(e -> e.getCategory().equals("Book"))
                .min(Comparator.comparing(Product::getPrice));
        Optional<Product> minValue = productList.stream()
                .filter(e -> e.getCategory().equals("Book"))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst();
        System.out.println(min);
        System.out.println(minValue);

        //Exercise 6 — Get the 3 most recent placed order
        List<Order> recent3Orders = orderList.stream().sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3).collect(Collectors.toList());
        System.out.println(recent3Orders);

        //Exercise 7 — Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
        List<Product> listProductOn15Mar2021 = orderList.stream().filter(e -> e.getOrderDate()
                        .equals(LocalDate.of(2021, 3, 15)))
                .peek(System.out::println)
                .flatMap(e -> e.getProducts().stream())
                .collect(Collectors.toList());
        System.out.println(listProductOn15Mar2021);

        //Exercise 8 — Calculate total lump sum of all orders placed in Feb 2021
        double sumOfPrice = orderList.stream()
                .filter(e -> e.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(e -> e.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
                .flatMap(e -> e.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println(sumOfPrice);

        //Exercise 9 — Calculate order average payment placed on 14-Mar-2021
        OptionalDouble average = orderList.stream()
                .filter(e -> e.getOrderDate().equals(LocalDate.of(2021, 3, 14)))
                .flatMap(e -> e.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .average();
        System.out.println(average);

        //Exercise 10 — Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”
        DoubleSummaryStatistics summary = productList.stream().filter(e -> e.getCategory().equals("Book"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
        System.out.println(summary);

        //Exercise 11 — Obtain a data map with order id and order’s product count
        Map<Long, Integer> map = orderList.stream().collect(Collectors.toMap(e -> e.getId(), e -> e.getProducts().size()));
        System.out.println(map);

        //Exercise 12 — Produce a data map with order records grouped by customer
        Map<Customer, List<Order>> groupingOfCustomer = orderList.stream().collect(Collectors.groupingBy(Order::getCustomer));
        System.out.println(groupingOfCustomer);

        //Exercise 13 — Produce a data map with order record and product total sum
        Map<Order, Double> mapOfOrderAndProduct = orderList.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        order -> order.getProducts().stream()
                                .mapToDouble(p -> p.getPrice()).sum()));
        System.out.println(mapOfOrderAndProduct);

        //Exercise 14 — Obtain a data map with list of product name by category
        Map<String, List<String>> mapOfProductName = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory
                        , Collectors.mapping(product -> product.getName(), Collectors.toList())));
        System.out.println(mapOfProductName);

        //Exercise 15 — Get the most expensive product by category
        Map<String, Optional<Product>> mapOfProductAndPrice = productList.stream().collect(Collectors.groupingBy(Product::getCategory
                , Collectors.maxBy(Comparator.comparing(Product::getPrice))));
        System.out.println(mapOfProductAndPrice);

    }

}
