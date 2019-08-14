package com.sample.java.algorithms;

import java.util.Random;
import java.util.stream.IntStream;

public class BigONotationPlayground {

    public static void main(String[] args) {
        runOrderOf1Example();
        runOrderOfNExample();
        runOrderOfNSquareExample();
    }

    /**
     * No matter how big the array size is, the time it takes to add an element to
     * the array is the same. This is called O(1) Order of 1.
     */
    private static void runOrderOf1Example() {
        System.out.println("################ Order of 1 Example Started ###############");
        System.out.println();

        int[] intArray = IntStream.rangeClosed(0, 50).toArray();
        int[] intArray2 = IntStream.rangeClosed(0, 5000).toArray();

        long startTime = System.currentTimeMillis();
        intArray[0] = 200;
        System.out.println("Time took: " + (System.currentTimeMillis() - startTime));

        long startTime2 = System.currentTimeMillis();
        intArray2[100] = 200;
        System.out.println("Time took: " + (System.currentTimeMillis() - startTime2));

        System.out.println("################ Order of 1 Example Ended ###############");

    }

    /**
     * O(N) Order of N is an algorithm where the time to completion is directly
     * proportional to the size of the data
     * 
     * Linear Search is an example of Order of N
     * 
     * Linear Search is a type of search where you have to scan the entire list
     * to find all values that match a particular value.
     */
    private static void runOrderOfNExample() {
        System.out.println("################ Order of N Example Started ###############");
        System.out.println();

        int[] intArray = new Random().ints(100000, 0, 2500).toArray();
        intArray[0] = 25;
        intArray[100000 - 1] = 25;

        int[] intArray2 = new Random().ints(1000000, 0, 2500).toArray();
        intArray2[0] = 25;
        intArray2[1000000 - 1] = 25;

        int[] intArray3 = new Random().ints(5000000, 0, 2500).toArray();
        intArray3[0] = 25;
        intArray3[5000000 - 1] = 25;

        findAll25s(intArray);
        findAll25s(intArray2);
        findAll25s(intArray3);

        System.out.println("################ Order of N Example Ended ###############");
    }

    private static void findAll25s(int[] intArray) {
        long startTime = System.currentTimeMillis();
        boolean found = false;
        @SuppressWarnings("unused")
        String indexsWithValue = "";
        
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 25) {
                found = true;
                indexsWithValue += i + " ";

            }
        }
        System.out.println("Found value: " + found);
        System.out.println("Time took: " + (System.currentTimeMillis() - startTime));
        System.out.println();

    }

    /**
     * O(N^2) Order of N square is an algorithm where the time to completion is
     * directly proportional to the square the size of the data. 
     * 
     * Bubble sort is an example of O(N^2) 
     * 
     * Bubble Sort is the simplest sorting algorithm that works
     * by repeatedly swapping the adjacent elements if they are in wrong order
     */
    private static void runOrderOfNSquareExample() {
        System.out.println("################ Order of N ^ 2 Started ###############");
        System.out.println();

        int[] intArray = new Random().ints(100, 0, 10).toArray();
        int[] intArray2 = new Random().ints(1000, 0, 10).toArray();
        int[] intArray3 = new Random().ints(5000, 0, 10).toArray();
        
        bubbleSort(intArray);
        bubbleSort(intArray2);
        bubbleSort(intArray3);

        System.out.println("################ Order of N ^ 2 Ended ###############");
    }
    
    private static void bubbleSort(int[] intArray) {
        long startTime = System.currentTimeMillis();
        
        for (int i = intArray.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    swapValues(intArray, j, j + 1);
                }
            }
        }
        System.out.println("Time took: " + (System.currentTimeMillis() - startTime));
        System.out.println();

    }

    private static void swapValues(int[] theArray, int indexOne, int indexTwo) {

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }


}
