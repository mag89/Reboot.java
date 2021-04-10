package org.example.lambda;

import java.io.FileOutputStream;
import java.io.IOException;

public class LambdaExemples2 {

    public static void main(String[] args) throws IOException {

/**
 * Java lambda expression can implement interfaces with
 * a single unimplemented method (abstract) method,
 * but as many default or static methods as yuo like.
 * **/


        // in MyInterface 3 methods, but only one method is abstract
        MyInterface myInterface = (String text) -> {
            System.out.println(text);
        };
        //or
        MyInterface myInterface2 = System.out::println;


        myInterface.printIt("Hello World!");

        myInterface.printUtf8To("Hello File!", new FileOutputStream("dataFile.txt"));


        MyInterface.printItToSystemOut("Hello from static context");


    }
}
