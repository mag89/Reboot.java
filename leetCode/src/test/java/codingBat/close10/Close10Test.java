package codingBat.close10;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Close10Test {
    private Close10 instance = new Close10();

    // close10(8, 13) → 8
    @Test
    public void close10() {
        int expected = 8;
        int actual = instance.close10(8, 13);

        Assert.assertEquals(expected, actual);
    }

    //    close10(13, 8) → 8
    @Test
    public void close10_2() {
        int expected = 8;
        int actual = instance.close10(13, 8);

        Assert.assertEquals(expected, actual);
    }


    //    close10(13, 7) → 0
    @Test
    public void close10_3() {
        int expected = 0;
        int actual = instance.close10(13, 7);

        Assert.assertEquals(expected, actual);
    }
}