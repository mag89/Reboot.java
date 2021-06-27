package codingBat.endUp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndUpTest {
    private EndUp indtance = new EndUp();

    //endUp("Hello") → "HeLLO"
    @Test
    public void endUp() {
        String expected = "HeLLO";
        String actual = indtance.endUp("Hello");

        Assert.assertEquals(expected, actual);

    }

    //endUp("hi there") → "hi thERE"
    @Test
    public void endUp_2() {
        String expected = "hi thERE";
        String actual = indtance.endUp("hi there");

        Assert.assertEquals(expected, actual);

    }

    //endUp("hi") → "HI"
    @Test
    public void endUp_3() {
        String expected = "HI";
        String actual = indtance.endUp("hi");

        Assert.assertEquals(expected, actual);

    }
}