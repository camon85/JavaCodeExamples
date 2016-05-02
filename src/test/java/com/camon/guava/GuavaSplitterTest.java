package com.camon.guava;

import com.google.common.base.Splitter;
import org.junit.Test;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2016-05-02.
 */
public class GuavaSplitterTest {

    private static final String FRUITS = "orange ,   apple, , grape,   , lemon, banana     ";

    @Test
    public void stringToList() {
        List<String> split = Splitter.on(',')
                .splitToList(FRUITS);

        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void removeWhiteSpaces() {
        List<String> split = Splitter.on(',')
                .trimResults()
                .splitToList(FRUITS);

        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void removeEmptyString() {
        List<String> split = Splitter.on(',')
                .omitEmptyStrings()
                .splitToList(FRUITS);

        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void stringToMap() {
        String input = "id=camon&name=jooyong";
        Map<String, String> result = Splitter.on("&")
                .withKeyValueSeparator("=")
                .split(input);

        for (String s : result.keySet()) {
            System.out.println("key:" + s);
            System.out.println("value: " + result.get(s));
        }
    }
}
