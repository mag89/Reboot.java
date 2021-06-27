package codingBat.everyNth;

import org.junit.Test;

import static org.junit.Assert.*;

public class EveryNthTest {
    private EveryNth instance = new EveryNth();


    //everyNth("Miracle", 2) → "Mrce"
    @Test
    public void everyNth() {
        String expected = "Mrce";
        String actual = instance.everyNth("Miracle", 2);

        assertEquals(expected, actual);
    }

    //everyNth("abcdefg", 2) → "aceg"
    @Test
    public void everyNth_2() {
        String expected = "aceg";
        String actual = instance.everyNth("abcdefg", 2);

        assertEquals(expected, actual);
    }

    //everyNth("abcdefg", 3) → "adg"
    @Test
    public void everyNth_3() {
        String expected = "adg";
        String actual = instance.everyNth("abcdefg", 3);

        assertEquals(expected, actual);
    }
}