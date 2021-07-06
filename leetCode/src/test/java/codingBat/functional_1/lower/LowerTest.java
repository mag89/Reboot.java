package codingBat.functional_1.lower;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LowerTest {
    private final Lower instance = new Lower();


    //lower(["Hello", "Hi"]) → ["hello", "hi"]
    @Test
    void lower() {
        List<String> expected = Arrays.asList("hello", "hi");
        List<String> actual = instance.lower(Arrays.asList("Hello", "Hi"));

        assertEquals(expected, actual);
    }

    //lower(["AAA", "BBB", "ccc"]) → ["aaa", "bbb", "ccc"]
    @Test
    void lower_2() {
        List<String> expected = Arrays.asList("aaa", "bbb", "ccc");
        List<String> actual = instance.lower(Arrays.asList("AAA", "BBB", "ccc"));

        assertEquals(expected, actual);
    }

    //lower(["KitteN", "ChocolaTE"]) → ["kitten", "chocolate"]
    @Test
    void lower_3() {
        List<String> expected = Arrays.asList("kitten", "chocolate");
        List<String> actual = instance.lower(Arrays.asList("KitteN", "ChocolaTE"));

        assertEquals(expected, actual);
    }
}