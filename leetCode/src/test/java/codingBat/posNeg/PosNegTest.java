package codingBat.posNeg;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PosNegTest {
    private PosNeg instance = new PosNeg();


    /*
    posNeg(1, -1, false) → true
     */
    @Test
    void posNeg1() {
        boolean actual = instance.posNeg(1, -1, false);
        Assert.assertTrue(actual);
    }

    /*
posNeg(-1, 1, false) → true
     */
    @Test
    void posNeg2() {
        boolean actual = instance.posNeg(-1, 1, false);
        Assert.assertTrue(actual);

    }

    /*
posNeg(-4, -5, true) → true
     */
    @Test
    void posNeg3() {
        boolean actual = instance.posNeg(-4, -5, true);
        Assert.assertTrue(actual);

    }

    /*

     */
//    @Test
//    void posNeg4() {
//        boolean actual = instance.posNeg();
//        Assert.assertFalse(actual);
//    }
}