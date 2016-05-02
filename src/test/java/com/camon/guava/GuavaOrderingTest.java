package com.camon.guava;

import com.camon.model.Person;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by camon on 2016-04-26.
 */
public class GuavaOrderingTest {

    @Test
    public void sort() {
        List<Integer> numbers = Arrays.asList(3, 2, 1, 5, 6, 8, 15);
        Collections.sort(numbers, Ordering.natural());
        System.out.println(numbers);

        Collections.sort(numbers, Ordering.natural().reverse());
        System.out.println(numbers);
    }

    @Test
    public void sortByComparator() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(19, "A"));
        persons.add(new Person(22, "Z"));
        persons.add(new Person(7, "F"));

        Ordering<Person> orderByAgeAsc = new Ordering<Person>() {
            @Override
            public int compare(Person left, Person right) {
                return Ints.compare(left.getAge(), right.getAge());
            }
        };

        Ordering<Person> orderByAgeDesc = new Ordering<Person>() {
            @Override
            public int compare(Person left, Person right) {
                return Ints.compare(right.getAge(), left.getAge());
            }
        };

        Ordering<Person> orderByName = new Ordering<Person>() {
            @Override
            public int compare(Person left, Person right) {
                return left.getName().compareTo(right.getName());
            }
        };

        Collections.sort(persons, orderByAgeAsc);
        System.out.println("orderByAgeAsc: " + persons);

        Collections.sort(persons, orderByAgeDesc);
        System.out.println("orderByAgeDesc: " + persons);

        Collections.sort(persons, orderByName);
        System.out.println("orderByName: " + persons);
    }

}
