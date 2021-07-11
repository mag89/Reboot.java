package codingBat.functional_2.no34;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class No34Test {
    private final No34 instance = new No34();





    //no34(["a", "bb", "ccc"]) → ["a", "bb"]
    @Test
    void no34() {
        List<String> expected = Arrays.asList("a", "bb");
        List<String> actual = instance.no34(Arrays.asList("a", "bb", "ccc"));

        assertEquals(expected, actual);
    }

    //no34(["a", "bb", "ccc", "dddd"]) → ["a", "bb"]
    @Test
    void no34_2() {
        List<String> expected = Arrays.asList("a", "bb");
        List<String> actual = instance.no34(Arrays.asList("a", "bb", "ccc", "dddd"));

        assertEquals(expected, actual);
    }

    //no34(["ccc", "dddd", "apple"]) → ["apple"]
    @Test
    void no34_3() {
        List<String> expected = Arrays.asList("apple");
        List<String> actual = instance.no34(Arrays.asList("ccc", "dddd", "apple"));

        assertEquals(expected, actual);
    }
}