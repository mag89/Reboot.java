package codingBat.warmup_2.stringTimes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringTimesTest {
    private StringTimes instance = new StringTimes();

    //stringTimes("Hi", 2) → "HiHi"
    @Test
    public void stringTimes() {
        String expected = "HiHi";
        String actual = instance.stringTimes("Hi", 2);

        Assert.assertEquals(expected, actual);
    }


    //stringTimes("Hi", 3) → "HiHiHi"
    @Test
    public void stringTimes_2() {
        String expected = "HiHiHi";
        String actual = instance.stringTimes("Hi", 3);

        Assert.assertEquals(expected, actual);
    }

    //stringTimes("Hi", 1) → "Hi"
    @Test
    public void stringTimes_3() {
        String expected = "Hi";
        String actual = instance.stringTimes("Hi", 1);

        Assert.assertEquals(expected, actual);
    }
}