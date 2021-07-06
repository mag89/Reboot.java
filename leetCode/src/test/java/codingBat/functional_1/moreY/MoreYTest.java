package codingBat.functional_1.moreY;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class MoreYTest {
    private MoreY instance = new MoreY();

    //moreY(["a", "b", "c"]) → ["yay", "yby", "ycy"]
    @Test
    void moreY() {
        List<String> expected = Arrays.asList("yay", "yby", "ycy");
        List<String> actual = instance.moreY(Arrays.asList("a", "b", "c"));

        assertEquals(expected, actual);
    }

    //moreY(["yay"]) →  ["yyayy"]
    @Test
    void moreY_2() {
        List<String> expected = Arrays.asList("yyayy");
        List<String> actual = instance.moreY(Arrays.asList("yay"));

        assertEquals(expected, actual);
    }

    //moreY(["hello", "there"]) → ["yhelloy", "ytherey"]
    @Test
    void moreY_3() {
        List<String> expected = Arrays.asList("yhelloy", "ytherey");
        List<String> actual = instance.moreY(Arrays.asList("hello", "there"));

        assertEquals(expected, actual);
    }
}