package codingBat.functional_1.rightDigit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RightDigitTest {
    private final RightDigit instance = new RightDigit();

    //    rightDigit([1, 22, 93]) → [1, 2, 3]
    @Test
    void rightDigit() {
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = instance.rightDigit(Arrays.asList(1, 22, 93));

        assertEquals(expected, actual);
    }

    //    rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
    @Test
    void rightDigit_2() {
        List<Integer> expected = Arrays.asList(6, 8, 6, 8, 1);
        List<Integer> actual = instance.rightDigit(Arrays.asList(16, 8, 886, 8, 1));

        assertEquals(expected, actual);
    }

    //    rightDigit([10, 0]) → [0, 0]
    @Test
    void rightDigit_3() {
        List<Integer> expected = Arrays.asList(0, 0);
        List<Integer> actual = instance.rightDigit(Arrays.asList(10, 0));

        assertEquals(expected, actual);
    }
}