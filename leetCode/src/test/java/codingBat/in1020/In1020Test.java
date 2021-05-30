package codingBat.in1020;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class In1020Test {
    private In1020 instance = new In1020();

    /*
    n1020(12, 99) → true
     */
    @Test
    void in1020() {
        boolean actual = instance.in1020(12, 99);
        Assert.assertTrue(actual);
    }

    /*
    in1020(21, 12) → true
     */
    @Test
    void in1020_2() {
        boolean actual = instance.in1020(21, 12);
        Assert.assertTrue(actual);
    }

    /*
    in1020(8, 99) → false
     */
    @Test
    void in1020_3() {
        boolean actual = instance.in1020(8, 99);
        Assert.assertFalse(actual);
    }
}