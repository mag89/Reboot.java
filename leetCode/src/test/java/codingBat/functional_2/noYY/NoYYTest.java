package codingBat.functional_2.noYY;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoYYTest {
    private final NoYY instance = new NoYY();


    //noYY(["a", "b", "c"]) → ["ay", "by", "cy"]
    @Test
    void noYY() {
        List<String> expected = Arrays.asList("ay", "by", "cy");
        List<String> actual = instance.noYY(Arrays.asList("a", "b", "c"));

        assertEquals(expected, actual);
    }

    //noYY(["a", "b", "cy"]) → ["ay", "by"]
    @Test
    void noYY_2() {
        List<String> expected = Arrays.asList("ay", "by");
        List<String> actual = instance.noYY(Arrays.asList("a", "b", "cy"));

        assertEquals(expected, actual);
    }

    //noYY(["xx", "ya", "zz"]) → ["xxy", "yay", "zzy"]
    @Test
    void noYY_3() {
        List<String> expected = Arrays.asList("xxy", "yay", "zzy");
        List<String> actual = instance.noYY(Arrays.asList("xx", "ya", "zz"));

        assertEquals(expected, actual);
    }

}