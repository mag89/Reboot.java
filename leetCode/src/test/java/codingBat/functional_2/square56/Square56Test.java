package codingBat.functional_2.square56;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Square56Test {

    private final Square56 instance = new Square56();

    //square56([3, 1, 4]) → [19, 11]
    @Test
    void square56() {
        List<Integer> expected = Arrays.asList(19, 11);
        List<Integer> actual = instance.square56(Arrays.asList(3, 1, 4));

        assertEquals(expected, actual);
    }

    //square56([1]) → [11]
    @Test
    void square56_2() {
        List<Integer> expected = Arrays.asList(11);
        List<Integer> actual = instance.square56(Arrays.asList(1));

        assertEquals(expected, actual);
    }

    //square56([2]) → [14]
    @Test
    void square56_3() {
        List<Integer> expected = Arrays.asList(14);
        List<Integer> actual = instance.square56(Arrays.asList(2));

        assertEquals(expected, actual);
    }

}