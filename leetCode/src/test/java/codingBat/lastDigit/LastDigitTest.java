package codingBat.lastDigit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LastDigitTest {
    private LastDigit instance = new LastDigit();




    //lastDigit(7, 17) → true
    @Test
    public void lastDigit() {
        boolean actual = instance.lastDigit(7, 17);

        Assert.assertTrue(actual);
    }

    //lastDigit(6, 17) → false
    @Test
    public void lastDigit_2() {
        boolean actual = instance.lastDigit(6, 17);

        Assert.assertFalse(actual);
    }

    //lastDigit(3, 113) → true
    @Test
    public void lastDigit_3() {
        boolean actual = instance.lastDigit(3, 113);

        Assert.assertTrue(actual);
    }
}