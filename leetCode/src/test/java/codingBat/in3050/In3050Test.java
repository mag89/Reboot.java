package codingBat.in3050;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class In3050Test {
    private In3050 instance = new In3050();

    //in3050(30, 31) → true
    @Test
    public void in3050() {
        boolean actual = instance.in3050(30, 31);

        Assert.assertTrue(actual);
    }

    //in3050(30, 41) → false
    @Test
    public void in3050_2() {
        boolean actual = instance.in3050(30, 41);

        Assert.assertFalse(actual);
    }

    //in3050(40, 50) → true
    @Test
    public void in3050_3() {
        boolean actual = instance.in3050(40, 50);

        Assert.assertTrue(actual);
    }


}