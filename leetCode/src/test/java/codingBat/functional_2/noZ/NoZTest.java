package codingBat.functional_2.noZ;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoZTest {
    private final NoZ instance = new NoZ();


    //noZ(["aaa", "bbb", "aza"]) → ["aaa", "bbb"]
    @Test
    void noZ() {
        List<String> expected = Arrays.asList("aaa", "bbb");
        List<String> actual = instance.noZ(Arrays.asList("aaa", "bbb", "aza"));

        assertEquals(expected, actual);
    }

    //noZ(["hziz", "hzello", "hi"]) → ["hi"]
    @Test
    void noZ_2() {
        List<String> expected = Arrays.asList("hi");
        List<String> actual = instance.noZ(Arrays.asList("hziz", "hzello", "hi"));

        assertEquals(expected, actual);
    }

    //noZ(["hello", "howz", "are", "youz"]) → ["hello", "are"]
    @Test
    void noZ_3() {
        List<String> expected = Arrays.asList("hello", "are");
        List<String> actual = instance.noZ(Arrays.asList("hello", "howz", "are", "youz"));

        assertEquals(expected, actual);
    }
}