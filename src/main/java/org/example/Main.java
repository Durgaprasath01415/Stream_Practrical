package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Print all the environment variables");
            System.getenv().forEach((k, v) -> System.out.println(k + ":" + v));
            System.out.println("Done printing all the variables");
            SpringApplication.run(Main.class,args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}