package codingBat.loneTeen;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LoneTeenTest {
    private LoneTeen instance = new LoneTeen();

    /*
    loneTeen(13, 99) → true
     */
    @Test
    void loneTeen() {
        boolean actual = instance.loneTeen(13, 99);
        Assert.assertTrue(actual);
    }

    /*
    loneTeen(21, 19) → true
     */
    @Test
    void loneTeen_2() {
        boolean actual = instance.loneTeen(21, 19);
        Assert.assertTrue(actual);
    }

    /*
    loneTeen(13, 13) → false
     */
    @Test
    void loneTeen_3() {
        boolean actual = instance.loneTeen(13, 13);
        Assert.assertFalse(actual);
    }
}