package codingBat.functional_1.addStar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class addStarTest {
    private AddStar instance = new AddStar();



    //    addStar(["a", "bb", "ccc"]) → ["a*", "bb*", "ccc*"]
    @Test
    void addStar() {
        List<String> expected = Arrays.asList("a*", "bb*", "ccc*");
        List<String> actual = instance.addStar(Arrays.asList("a", "bb", "ccc"));

        Assertions.assertEquals(expected, actual);

    }

    //    addStar(["hello", "there"]) → ["hello*", "there*"]
    @Test
    void addStar_2() {
        List<String> expected = Arrays.asList("hello*", "there*");
        List<String> actual = instance.addStar(Arrays.asList("hello", "there"));

        Assertions.assertEquals(expected, actual);

    }


    //    addStar(["*"]) → ["**"]
    @Test
    void addStar_3() {
        List<String> expected = Arrays.asList("**");
        List<String> actual = instance.addStar(Arrays.asList("*"));

        Assertions.assertEquals(expected, actual);

    }
}