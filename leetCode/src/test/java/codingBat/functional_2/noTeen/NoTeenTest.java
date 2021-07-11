package codingBat.functional_2.noTeen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoTeenTest {
    private final NoTeen instance = new NoTeen();





    //noTeen([12, 13, 19, 20]) → [12, 20]
    @Test
    void noTeen() {
        List<Integer> expected = Arrays.asList(12, 20);
        List<Integer> actual = instance.noTeen(Arrays.asList(12, 13, 19, 20));

        assertEquals(expected, actual);
    }

    //noTeen([1, 14, 1]) → [1, 1]
    @Test
    void noTeen_2() {
        List<Integer> expected = Arrays.asList(1, 1);
        List<Integer> actual = instance.noTeen(Arrays.asList(1, 14, 1));

        assertEquals(expected, actual);
    }

    //noTeen([15]) → []
    @Test
    void noTeen_3() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = instance.noTeen(Arrays.asList(15));

        assertEquals(expected, actual);
    }
}