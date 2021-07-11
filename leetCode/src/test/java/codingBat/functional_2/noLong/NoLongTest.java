package codingBat.functional_2.noLong;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class NoLongTest {
    private final NoLong instance = new NoLong();

    //noLong(["this", "not", "too", "long"]) → ["not", "too"]
    @Test
    void noLong() {
        List<String> expected = Arrays.asList("not", "too");
        List<String> actual = instance.noLong(Arrays.asList("this", "not", "too", "long"));

        assertEquals(expected, actual);
    }

    //noLong(["a", "bbb", "cccc"]) → ["a", "bbb"]
    @Test
    void noLong_2() {
        List<String> expected = Arrays.asList("a", "bbb");
        List<String> actual = instance.noLong(Arrays.asList("a", "bbb", "cccc"));

        assertEquals(expected, actual);
    }

    //noLong(["cccc", "cccc", "cccc"]) → []
    @Test
    void noLong_3() {
        List<String> expected = new ArrayList<>();
        List<String> actual = instance.noLong(Arrays.asList("cccc", "cccc", "cccc"));

        assertEquals(expected, actual);
    }
}