package codingBat.max1020;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Max1020Test {
    private Max1020 instance = new Max1020();


    //max1020(11, 19) → 19
    @Test
    public void max1020() {
        int expected = 19;
        int actual = instance.max1020(11, 19);

        Assert.assertEquals(expected, actual);
    }

    //max1020(19, 11) → 19
    @Test
    public void max1020_2() {
        int expected = 19;
        int actual = instance.max1020(19, 11);

        Assert.assertEquals(expected, actual);
    }

    //max1020(11, 9) → 11
    @Test
    public void max1020_3() {
        int expected = 11;
        int actual = instance.max1020(11, 9);

        Assert.assertEquals(expected, actual);
    }

    //max1020(21, 9) → 0
    @Test
    public void max1020_4() {
        int expected = 0;
        int actual = instance.max1020(21, 9);

        Assert.assertEquals(expected, actual);
    }

}