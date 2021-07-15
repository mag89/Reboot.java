package codingBat.recursion_1.factorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    private final Factorial instance = new Factorial();




    //factorial(1) → 1
    @Test
    void factorial() {
        int expected = 1;
        int actual = instance.factorial(1);

        assertEquals(expected, actual);
    }

    //factorial(2) → 2
    @Test
    void factorial_2() {
        int expected = 2;
        int actual = instance.factorial(2);

        assertEquals(expected, actual);
    }

    //factorial(3) → 6
    @Test
    void factorial_3() {
        int expected = 6;
        int actual = instance.factorial(3);

        assertEquals(expected, actual);
    }
}