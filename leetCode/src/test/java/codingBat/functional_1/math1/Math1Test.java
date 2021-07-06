package codingBat.functional_1.math1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Math1Test {
    private Math1 instance = new Math1();




    //math1([1, 2, 3]) → [20, 30, 40]
    @Test
    void math1() {
        List<Integer> expectesd = Arrays.asList(20, 30, 40);
        List<Integer> actual = instance.math1(Arrays.asList(1, 2, 3));

        assertEquals(expectesd, actual);
    }

    //math1([6, 8, 6, 8, 1]) → [70, 90, 70, 90, 20]
    @Test
    void math1_2() {
        List<Integer> expectesd = Arrays.asList(70, 90, 70, 90, 20);
        List<Integer> actual = instance.math1(Arrays.asList(6, 8, 6, 8, 1));

        assertEquals(expectesd, actual);
    }

    //math1([10]) → [110]
    @Test
    void math1_3() {
        List<Integer> expectesd = Arrays.asList(110);
        List<Integer> actual = instance.math1(Arrays.asList(10));

        assertEquals(expectesd, actual);
    }
}