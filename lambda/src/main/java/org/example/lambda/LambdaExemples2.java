package org.example.lambda;

import java.io.FileOutputStream;
import java.io.IOException;

public class LambdaExemples2 {
    static String thirdText = "Hey, a third text!";

    private String forthText = "Forth Text";

    private void doIt() {
        MyInterface myInterface3 = (String text) -> {
            System.out.println(text + " " + forthText);
        };

        myInterface3.printIt("Ather");

        forthText = "Bebebebebe!";

        myInterface3.printIt("Ather");
    }

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


        /**
         *Java lambda expression can references outside the expression through variables
         * and if it reference is local variable, the local variable must be final/effective final,
         * and cant be changed after lambda implementation
         *
         * Is same as true for static and regular fields, but it allowed change value after lambda implementation
         */

        final String otherText = "Hello: "; //the local variable does not changed value after has been set in first time,
        //because it used in lambda implementation, and must be final/effective final

        MyInterface myInterface3 = (String text) -> {
            System.out.println(otherText + text + " " + thirdText);
        };

        myInterface3.printIt("WORLD");

        //note this, a static field can be changed after lambda implementation
        thirdText = "Blabalblabla!";

        myInterface3.printIt("WORLD");

        //and this, with regular field
        LambdaExemples2 instance = new LambdaExemples2();
        instance.doIt();


    }
}
