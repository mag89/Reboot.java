package codingBat.functional_1.doubling1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Doubling1Test {
    private Doubling1 instance = new Doubling1();

    //doubling([1, 2, 3]) → [2, 4, 6]
    @Test
    void doubling() {
        List<Integer> expected = Arrays.asList(2, 4, 6);
        List<Integer> actual = instance.doubling(Arrays.asList(1, 2, 3));

        assertEquals(expected, actual);
    }

    //doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
    @Test
    void doubling_2() {
        List<Integer> expected = Arrays.asList(12, 16, 12, 16, -2);
        List<Integer> actual = instance.doubling(Arrays.asList(6, 8, 6, 8, -1));

        assertEquals(expected, actual);
    }

    //doubling([]) → []
    @Test
    void doubling_3() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = instance.doubling(new ArrayList<>());

        assertEquals(expected, actual);
    }
}