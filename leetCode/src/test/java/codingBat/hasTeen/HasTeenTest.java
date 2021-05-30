package codingBat.hasTeen;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HasTeenTest {
    private HasTeen instance = new HasTeen();

    /*
    hasTeen(13, 20, 10) → true
     */
    @Test
    void hasTeen() {
        boolean actual = instance.hasTeen(13, 20, 10);
        Assert.assertTrue(actual);
    }

    /*
    hasTeen(20, 19, 10) → true
     */
    @Test
    void hasTeen_2() {
        boolean actual = instance.hasTeen(20, 19, 10);
        Assert.assertTrue(actual);
    }

    /*
    hasTeen(20, 10, 13) → true
     */
    @Test
    void hasTeen_3() {
        boolean actual = instance.hasTeen(20, 10, 13);
        Assert.assertTrue(actual);
    }
}