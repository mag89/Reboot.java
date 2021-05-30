package codingBat.backAround;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackAroundTest {
    private BackAround instance = new BackAround();

    /*
    backAround("cat") → "tcatt"
     */
    @Test
    void backAround1() {
        String expected = "tcatt";
        String actual = instance.backAround("cat");

        Assert.assertEquals(expected, actual);
    }

    /*
    backAround("Hello") → "oHelloo"
     */
    @Test
    void backAround2() {
        String expected = "oHelloo";
        String actual = instance.backAround("Hello");

        Assert.assertEquals(expected, actual);


    }

    /*
    backAround("a") → "aaa"
     */
    @Test
    void backAround3() {
        String expected = "aaa";
        String actual = instance.backAround("a");

        Assert.assertEquals(expected, actual);


    }
}