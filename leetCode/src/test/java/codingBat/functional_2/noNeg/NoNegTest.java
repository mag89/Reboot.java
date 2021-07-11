package codingBat.functional_2.noNeg;

import codingBat.functional_2.noNeg.NoNeg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NoNegTest {
    private final NoNeg instance = new NoNeg();





    //noNeg([1, -2]) → [1]
    @Test
    void noNeg() {
        List<Integer> expected = Arrays.asList(1);
        List<Integer> actual = instance.noNeg(Arrays.asList(1, -2));

        Assertions.assertEquals(expected, actual);
    }

    //noNeg([-3, -3, 3, 3]) → [3, 3]
    @Test
    void noNeg_2() {
        List<Integer> expected = Arrays.asList(3, 3);
        List<Integer> actual = instance.noNeg(Arrays.asList(-3, -3, 3, 3));

        Assertions.assertEquals(expected, actual);
    }


    //noNeg([-1, -1, -1]) → []
    @Test
    void noNeg_3() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = instance.noNeg(Arrays.asList(-1, -1, -1));

        Assertions.assertEquals(expected, actual);
    }
}