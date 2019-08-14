package com.sample.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * Java 8 introduced the concept of Streams as an efficient way of carrying out
 * bulk operations on data. And parallel Streams can be obtained in environments
 * that support concurrency. These streams can come with improved performance –
 * at the cost of multi-threading overhead.
 * 
 * Good discussion on parallel processing - https://stackoverflow.com/questions/20375176/should-i-always-use-a-parallel-stream-when-possible
 * 
 * @author kishore
 * 
 */
public class ParallelStreamsPlayground {
    static List<Integer> intStringArray = IntStream.range(0, 5000).boxed().collect(Collectors.toList());

    public static void main(String[] args) {
        runParallel();
        runSerial();
    }

    /**
     * Parallel Processing doesn't guarantee that it processes a task faster than serial processing
     */
    private static void runParallel() {
        System.out.println("################ Parallel Example Started ###############");
        long startTime = System.currentTimeMillis();
        
        intStringArray
            .parallelStream()
            .map(num -> num * 2)
            .collect(Collectors.toList());
        
        System.out.println("Time took: " + (System.currentTimeMillis() - startTime));
        System.out.println("################ Parallel Example Ended ###############");

    }
    
    private static void runSerial() {
        System.out.println("################ Serial Example Started ###############");
        long startTime = System.currentTimeMillis();

        intStringArray
            .stream()
            .map(num -> num * 2)
            .collect(Collectors.toList());
        
        System.out.println("Time took: " + (System.currentTimeMillis() - startTime));

        System.out.println("################ Serial Example Ended ###############");
    }
    
    
    
    /* Running the above examples we can see in the output that, parallelProcessing took more than 5 milliseconds to 
     * execute the task, where as serial processing took 1 milli second
     * 
        ################ Parallel Example Started ###############
        Time took: 5
        ################ Parallel Example Ended ###############
        ################ Serial Example Started ###############
        Time took: 1
        ################ Serial Example Ended ###############

     */
}
