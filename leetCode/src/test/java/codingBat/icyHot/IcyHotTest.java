package codingBat.icyHot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IcyHotTest {
    private IcyHot instance = new IcyHot();

    /*
    icyHot(120, -1) → true
     */
    @Test
    void icyHot() {
        boolean actual = instance.icyHot(120, -1);
        Assert.assertTrue(actual);
    }

    /*
    icyHot(-1, 120) → true
     */
    @Test
    void icyHot_2() {
        boolean actual = instance.icyHot(-1, 120);
        Assert.assertTrue(actual);
    }

    /*
    icyHot(2, 120) → false
     */
    @Test
    void icyHot_3() {
        boolean actual = instance.icyHot(2, 120);
        Assert.assertFalse(actual);
    }
}