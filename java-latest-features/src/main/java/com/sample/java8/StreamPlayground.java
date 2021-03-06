package com.sample.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Contains examples of how to use Java 8 lambdas and streams for iterating over
 * a list
 * 
 * @author kishore
 *
 */
public class StreamPlayground {
    static int[] intArray = IntStream.rangeClosed(0, 50).toArray();
    static List<Integer> intStringArray = IntStream.range(0, 50).boxed().collect(Collectors.toList());

    public static void main(String[] args) {
        runFilter();
        runMap();
        runReduce();
    }

    private static void runFilter() {
        System.out.println("################ Filter Example Started ###############");

        // Filter elements that are even
        List<Integer> collect = intStringArray.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println("List Size: " + collect.size());

        System.out.println("################ Filter Example Ended   ###############");
        System.out.println();

    }

    private static void runMap() {
        System.out.println("################ Map Example Started    ###############");

        // Multiply every element in list by 2 and store in a List
        List<Integer> collect = intStringArray.stream().map(num -> num * 2).collect(Collectors.toList());

        System.out.println("List Size: " + collect.size());

        System.out.println("################ Map Example Ended      ###############");
        System.out.println();

    }

    private static void runReduce() {
        System.out.println("################ Reduce Example Started ###############");

        // Finding sum of all elements
        int sum = intStringArray.stream().reduce(0, (num1, num2) -> num1 + num2);
        System.out.println("The sum is : " + sum);

        // To get the product of all elements in given range excluding the rightmost
        // element
        int product = intStringArray.stream().reduce((num1, num2) -> num1 * num2).orElse(-1);

        System.out.println("The product is : " + product);

        System.out.println("################ Reduce Example Ended   ###############");
        System.out.println();

    }

}
