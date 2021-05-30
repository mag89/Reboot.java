package codingBat.front3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SolutionFront3Test {
    private SolutionFront3 instance = new SolutionFront3();

    /*
    front3("Java") → "JavJavJav"
     */
    @Test
    void front31() {

        String actual = instance.front3("Java");
        String expect = "JavJavJav";

        Assert.assertEquals(expect, actual);
    }

    /*
    front3("Chocolate") → "ChoChoCho"
     */
    @Test
    void front32() {

        String actual = instance.front3("Chocolate");
        String expect = "ChoChoCho";

        Assert.assertEquals(expect, actual);
    }

    /*
    front3("abc") → "abcabcabc"
     */
    @Test
    void front33() {

        String actual = instance.front3("acb");
        String expect = "acbacbacb";

        Assert.assertEquals(expect, actual);
    }

    /*
    front3("ab") → "ababab"
     */
    @Test
    void front34() {
        String actual = instance.front3("ab");
        String expect = "ababab";

        Assert.assertEquals(expect, actual);
    }

    /*
    front3("a") → "aaa"
     */
    @Test
    void front35() {
        String actual = instance.front3("a");
        String expect = "aaa";

        Assert.assertEquals(expect, actual);
    }

    /*
    front3("") → ""
     */
    @Test
    void front36() {
        String actual = instance.front3("");
        String expect = "";

        Assert.assertEquals(expect, actual);
    }
}