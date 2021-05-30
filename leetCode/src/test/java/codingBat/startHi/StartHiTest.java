package codingBat.startHi;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class StartHiTest {
    StartHi instance = new StartHi();

    /*
    startHi("hi there") → true
     */
    @Test
    void startHi_1() {
        boolean actual = instance.startHi("hi there");
        Assert.assertTrue(actual);
    }

    /*
    startHi("hi") → true
     */
    @Test
    void startHi_2() {
        boolean actual = instance.startHi("hi");
        Assert.assertTrue(actual);
    }

    /*
    startHi("hello hi") → false
     */
    @Test
    void startHi_3() {
        boolean actual = instance.startHi("hello hi");
        Assert.assertFalse(actual);
    }
}