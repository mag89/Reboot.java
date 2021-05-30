package codingBat.or35;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Or35Test {

    private Or35 instance = new Or35();

    /*
    or35(3) → true
     */
    @Test
    void or35_1() {
        boolean actual = instance.or35(3);

        Assert.assertTrue(actual);
    }

    /*
    or35(10) → true
     */
    @Test
    void or35_2() {
        boolean actual = instance.or35(10);

        Assert.assertTrue(actual);
    }

    /*
    or35(8) → false
     */
    @Test
    void or35_3() {
        boolean actual = instance.or35(8);

        Assert.assertFalse(actual);
    }
}