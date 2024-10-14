package com.test.base;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "ace4", "zce4", "Bob", "1FER", "0UUY", "#xxx", "!xxx");
        List<String> sortedNames = names.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(sortedNames);
    }
}
