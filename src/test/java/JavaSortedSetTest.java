import org.junit.Test;

import java.util.*;

/**
 * Created by jooyong on 2016-01-14.
 */
// http://www.tutorialspoint.com/java/java_sortedset_interface.htm
// http://www.java2s.com/Tutorials/Java/Java_Collection/0110__Java_Sorted_Set.htm
public class JavaSortedSetTest {
    @Test
    public void simple() {
        SortedSet<String> fruitSet = new TreeSet<>();
        fruitSet.add("orange");
        fruitSet.add("apple");
        fruitSet.add("grape");
        fruitSet.add("lemon");
        fruitSet.add("banana");

        // iterator style
        Iterator<String> iterator = fruitSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // foreach style
        for (String fruit : fruitSet) {
            System.out.println(fruit);
        }

        // java8 style
        fruitSet.forEach((fruit) -> System.out.println(fruit));

        // java8 style
        fruitSet.forEach(System.out::println);
    }

    @Test
    public void reverseOrder() {
        SortedSet<String> fruitSet = new TreeSet<>(Collections.reverseOrder());
        fruitSet.add("orange");
        fruitSet.add("apple");
        fruitSet.add("grape");
        fruitSet.add("lemon");
        fruitSet.add("banana");

        // java8 style
        fruitSet.forEach(System.out::println);
    }

    @Test
    public void subset() {
        SortedSet<String> fruitSet = new TreeSet<>();
        fruitSet.add("orange");
        fruitSet.add("apple");
        fruitSet.add("grape");
        fruitSet.add("lemon");
        fruitSet.add("banana");

        System.out.println(fruitSet);
        System.out.println(fruitSet.first());
        System.out.println(fruitSet.last());
        System.out.println(fruitSet.headSet("grape"));
        System.out.println(fruitSet.subSet("apple", "grape"));
        System.out.println(fruitSet.tailSet("grape"));
    }

    @Test
    public void comparetor() {
        // 나이 오름차순
        SortedSet<Person> personsByAgeAsc = new TreeSet<>(Comparator.comparing(Person::getAge));
        personsByAgeAsc.add(new Person(19, "A"));
        personsByAgeAsc.add(new Person(22, "Z"));
        personsByAgeAsc.add(new Person(7, "F"));
        personsByAgeAsc.add(new Person(45, "D"));
        System.out.println("personsByAgeAsc: " + personsByAgeAsc);

        // 나이 내림차순
        SortedSet<Person> personsByAgeDesc = new TreeSet<>(Comparator.comparing(Person::getAge).reversed());
        personsByAgeDesc.add(new Person(19, "A"));
        personsByAgeDesc.add(new Person(22, "Z"));
        personsByAgeDesc.add(new Person(7, "F"));
        personsByAgeDesc.add(new Person(45, "D"));
        System.out.println("personsByAgeDesc: " + personsByAgeDesc);

        // 이름 오름차순
        SortedSet<Person> personsByName = new TreeSet<>(Comparator.comparing(Person::getName));
        personsByName.add(new Person(19, "A"));
        personsByName.add(new Person(22, "Z"));
        personsByName.add(new Person(7, "F"));
        personsByName.add(new Person(45, "D"));
        System.out.println("personsByName: " + personsByName);

    }

    class Person {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
