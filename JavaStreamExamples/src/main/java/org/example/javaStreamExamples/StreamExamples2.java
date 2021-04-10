package org.example.javaStreamExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        Stream<String> stream = list.stream();

        Stream<String> lowercaseStream = stream.map((String element) -> { // Non-terminal operation map()
            return element.toLowerCase();
        });

        //you can`t call additional non-terminal operations on previous stream

        lowercaseStream.forEach(element -> System.out.println(element));

        //to avoid this constraint do this methods chain
        list.stream()
                .map((String element) -> {
                    return element.toLowerCase();
                })
                .map((String element) -> {
                    return element.toUpperCase();
                })
                .forEach(e -> System.out.println(e));

        //simplify the record
        System.out.println("simplify the record");
        list.stream()
                .map((element) -> element.toLowerCase())
                .map((element) -> element.toUpperCase())
                .forEach(e -> System.out.println(e));

        //further simplify the record
        System.out.println("further simplify the record");
        list.stream()
                .map(String::toLowerCase)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
