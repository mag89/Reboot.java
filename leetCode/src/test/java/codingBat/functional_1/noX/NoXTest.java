package codingBat.functional_1.noX;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoXTest {
    private final NoX instance = new NoX();





    //noX(["ax", "bb", "cx"]) → ["a", "bb", "c"]
    @Test
    void noX() {
        List<String> expected = Arrays.asList("a", "bb", "c");
        List<String> actual = instance.noX(Arrays.asList("ax", "bb", "cx"));

        assertEquals(expected, actual);
    }

    //noX(["xxax", "xbxbx", "xxcx"]) → ["a", "bb", "c"]
    @Test
    void noX_2() {
        List<String> expected = Arrays.asList("a", "bb", "c");
        List<String> actual = instance.noX(Arrays.asList("xxax", "xbxbx", "xxcx"));

        assertEquals(expected, actual);
    }

    //noX(["x"]) → [""]
    @Test
    void noX_3() {
        List<String> expected = Arrays.asList("");
        List<String> actual = instance.noX(Arrays.asList("x"));

        assertEquals(expected, actual);
    }
}