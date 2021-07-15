package codingBat.recursion_1.bunnyEars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BunnyEarsTest {
    private final BunnyEars instance = new BunnyEars();



    //bunnyEars(0) → 0
    @Test
    void bunnyEars() {
        int expected = 0;
        int actual = instance.bunnyEars(0);

        assertEquals(expected, actual);
    }

    //bunnyEars(1) → 2
    @Test
    void bunnyEars_2() {
        int expected = 2;
        int actual = instance.bunnyEars(1);

        assertEquals(expected, actual);
    }

    //bunnyEars(2) → 4
    @Test
    void bunnyEars_3() {
        int expected = 4;
        int actual = instance.bunnyEars(2);

        assertEquals(expected, actual);
    }


    @Test
    void bunnyEars_4() {
        int expected = 6;
        int actual = instance.bunnyEars(3);

        assertEquals(expected, actual);
    }
}