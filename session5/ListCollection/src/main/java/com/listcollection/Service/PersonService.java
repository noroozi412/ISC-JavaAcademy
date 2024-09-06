package com.listcollection.Service;
import com.listcollection.model.Address;
import com.listcollection.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonService {
    private List<Person> people = new ArrayList<>();

    public PersonService() {
        // Create 10 sample data
        people.add(new Person("John", "Doe", 25, new Address("New York", "USA")));
        people.add(new Person("Jane", "Doe", 30, new Address("Los Angeles", "USA")));
        people.add(new Person("Alice", "Smith", 20, new Address("Chicago", "USA")));
        people.add(new Person("Bob", "Johnson", 35, new Address("New York", "USA")));
        people.add(new Person("Eve", "Davis", 28, new Address("San Francisco", "USA")));
        people.add(new Person("Mike", "Williams", 22, new Address("Chicago", "USA")));
        people.add(new Person("Sarah", "Taylor", 32, new Address("Los Angeles", "USA")));
        people.add(new Person("Tom", "Harris", 29, new Address("New York", "USA")));
        people.add(new Person("Lily", "Brown", 26, new Address("San Francisco", "USA")));
        people.add(new Person("David", "Lee", 31, new Address("Chicago", "USA")));
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Person> sortByCity() {
        return people.stream()
                .sorted((p1, p2) -> p1.getAddress().getCity().compareTo(p2.getAddress().getCity()))
                .collect(Collectors.toList());
    }

    public Map<Boolean, List<Person>> partitionByAge() {
        return people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 18));
    }

    public Map<String, List<Person>> groupByCity() {
        return people.stream()
                .collect(Collectors.groupingBy(p -> p.getAddress().getCity()));
    }

    public double averageAge() {
        return people.stream()
                .collect(Collectors.averagingInt(Person::getAge));
    }
}