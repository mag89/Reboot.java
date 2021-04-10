package org.example.javaStreamExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        /**
         * Added in Jave 8
         * Provides a functional approach to processing bounded streams of objects.
         *
         * A java Stream is:
         *     Capable of internal iteration of its elements.
         *     Provides functionality for processing its elements during iteration.
         *
         * Java Stream Usage:
         *     1. Obtain a Stream.
         *     2. Call zero or more non-terminal operations on the Stream.
         *     3. Call a terminal operation on the Stream.
         *
         */

        List<String> list = new ArrayList<String>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        Stream<String> stream = list.stream(); //Obtained a Stream.
        //in this our case zero non-terminal operations has been called.

        stream.forEach((e) -> { // call terminal operation - forEach.
            System.out.println(e);
        });

        //also lambda expression can replace with method reference.
        stream.forEach(System.out::println);

        /**
         * Non-terminal vs Terminal Operations.
         *     * Non-terminal operations add element processing operations to the Stream,
         *     but does not start the iteration of the elements. (just configuring the elements for later)
         *
         *     * Terminal operations start the internal processing of the elements, and
         *     processes each element via the non-terminal and terminal operations set on the Stream.
         */


    }
}
