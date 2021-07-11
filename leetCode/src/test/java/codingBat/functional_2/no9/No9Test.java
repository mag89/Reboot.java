package codingBat.functional_2.no9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class No9Test {
    private final No9 instance = new No9();

    //no9([1, 2, 19]) → [1, 2]
    @Test
    void no9() {
        List<Integer> expected = Arrays.asList(1, 2);
        List<Integer> actual = instance.no9(Arrays.asList(1, 2, 19));

        assertEquals(expected, actual);
    }

    //no9([9, 19, 29, 3]) → [3]
    @Test
    void no9_2() {
        List<Integer> expected = Arrays.asList(3);
        List<Integer> actual = instance.no9(Arrays.asList(9, 19, 29, 3));

        assertEquals(expected, actual);
    }

    //no9([1, 2, 3]) → [1, 2, 3]
    @Test
    void no9_3() {
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = instance.no9(Arrays.asList(1, 2, 3));

        assertEquals(expected, actual);
    }
}