package com.my.StreamTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 5, null, 10, 22, 6, 5);
        list.stream().filter(num -> num != null).distinct().sorted().forEach(System.out::println);

        int value = Stream.of(4, 3, 2, 1).reduce((sum, item) -> sum + item).get();
        System.out.println(value);

        List x = Arrays.asList("hello", "world");
        //Stream stream = x.stream();
        System.out.println(x);

        List<String[]> collect = Arrays.asList("hello", "world")
                .parallelStream()
                .map(word -> {
                    String[] ary = word.split("l");
                    return ary;
                })
                .collect(Collectors.toList());
        System.out.println(collect.get(0)[0]);

        List<String> list1 = Arrays.asList("h", "l", "e", "o")
                .stream()
                .map(num -> num + '/')
                .collect(Collectors.toList());
        System.out.println(list1);

        String collect1 = Stream.of("1", "2", "4", "5")
                .map(num -> num + '/')
                .collect(Collectors.joining("--"));
        System.out.println(collect1);
    }


}


