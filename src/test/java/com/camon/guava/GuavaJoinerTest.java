package com.camon.guava;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2016-05-02.
 */
public class GuavaJoinerTest {

    @Test
    public void listToString() {
        List<String> fruits = Arrays.asList("orange", "apple", "grape", "lemon", "banana");
        String result = Joiner.on(", ").join(fruits);
        System.out.println(result);
    }


    @Test
    public void join_withoutNull() {
        List<String> fruits = Arrays.asList("orange", "apple", "grape", null, "lemon", "banana");
        String result = Joiner.on(",").skipNulls().join(fruits);
        System.out.println(result);
    }

    @Test
    public void mapToString() {
        Map<String, String> maps = new HashMap<>();
        maps.put("id", "camon");
        maps.put("name", "jooyong");

        String result = Joiner.on("&")
                .withKeyValueSeparator("=")
                .join(maps);

        System.out.println(result);
    }

}
