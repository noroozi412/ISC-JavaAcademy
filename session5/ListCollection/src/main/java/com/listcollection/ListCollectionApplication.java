package com.listcollection;

import com.listcollection.Service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListCollectionApplication.class, args);
        PersonService personService = new PersonService();

        System.out.println("Original list:");
        personService.getPeople().forEach(System.out::println);

        System.out.println("Sorted by city:");
        personService.sortByCity().forEach(System.out::println);

        System.out.println("Partitioned by age:");
        personService.partitionByAge().forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("Grouped by city:");
        personService.groupByCity().forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("Average age: " + personService.averageAge());
    }
    }


