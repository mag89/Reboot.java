package org.example.lambda;

public class Main {

    public static void main(String[] args) {
        MyFunction myFunction = () -> {
            System.out.println("hello world");
        };

        myFunction.apply();


        MyFunction myFunction1 = () -> System.out.println("hello world1");

        myFunction1.apply();


        MyFunction1 myFunction11 = text -> System.out.println(text);

        myFunction11.apply("Hello World11");


        MyFunction1 myFunction12 = System.out::println;

        myFunction12.apply("Hello World12");
    }

}
