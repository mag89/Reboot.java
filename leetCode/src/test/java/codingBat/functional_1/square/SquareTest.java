package codingBat.functional_1.square;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class SquareTest {
    private Square instance = new Square();


    //square([1, 2, 3]) → [1, 4, 9]
    @Test
    void square() {
        List<Integer> expected = Arrays.asList(1, 4, 9);
        List<Integer> actual = instance.square(Arrays.asList(1, 2, 3));

        assertEquals(expected, actual);
    }

    //square([6, 8, -6, -8, 1]) → [36, 64, 36, 64, 1]
    @Test
    void square_2() {
        List<Integer> expected = Arrays.asList(36, 64, 36, 64, 1);
        List<Integer> actual = instance.square(Arrays.asList(6, 8, -6, -8, 1));

        assertEquals(expected, actual);
    }


    //square([]) → []
    @Test
    void square_3() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = instance.square(new ArrayList<>());

        assertEquals(expected, actual);
    }
}