package codingBat.functional_1.copies3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Copies3Test {
    private Copies3 instance = new Copies3();


    //copies3(["a", "bb", "ccc"]) → ["aaa", "bbbbbb", "ccccccccc"]
    @Test
    void copies3() {
        List<String> expected = Arrays.asList("aaa", "bbbbbb", "ccccccccc");
        List<String> actual = instance.copies3(Arrays.asList("a", "bb", "ccc"));

        assertEquals(expected, actual);
    }

    //copies3(["24", "a", ""]) → ["242424", "aaa", ""]
    @Test
    void copies3_2() {
        List<String> expected = Arrays.asList("242424", "aaa", "");
        List<String> actual = instance.copies3(Arrays.asList("24", "a", ""));

        assertEquals(expected, actual);
    }

    //copies3(["hello", "there"]) → ["hellohellohello", "theretherethere"]
    @Test
    void copies3_3() {
        List<String> expected = Arrays.asList("hellohellohello", "theretherethere");
        List<String> actual = instance.copies3(Arrays.asList("hello", "there"));

        assertEquals(expected, actual);
    }
}