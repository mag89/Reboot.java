package codingBat.mixStart;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MixStartTest {
    private MixStart instance = new MixStart();


    /*
    mixStart("mix snacks") → true
     */
    @Test
    void mixStart() {
        boolean actual = instance.mixStart("mix snacks");
        Assert.assertTrue(actual);
    }

    /*
    mixStart("pix snacks") → true
     */
    @Test
    void mixStart_2() {
        boolean actual = instance.mixStart("pix snacks");
        Assert.assertTrue(actual);
    }

    /*
    mixStart("piz snacks") → false
     */
    @Test
    void mixStart_3() {
        boolean actual = instance.mixStart("piz snacks");
        Assert.assertFalse(actual);
    }
}