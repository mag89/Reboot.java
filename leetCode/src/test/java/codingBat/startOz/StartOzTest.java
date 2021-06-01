package codingBat.startOz;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class StartOzTest {
    private StartOz instance = new StartOz();

    /*
    startOz("ozymandias") → "oz"
     */
    @Test
    void startOz() {
        String expected = "oz";
        String actual = instance.startOz("ozymandias");

        Assert.assertEquals(expected, actual);
    }

    /*
    startOz("bzoo") → "z"
     */
    @Test
    void startOz_2() {
        String expected = "z";
        String actual = instance.startOz("bzoo");

        Assert.assertEquals(expected, actual);
    }

    /*
    startOz("oxx") → "o"
     */
    @Test
    void startOz_3() {
        String expected = "o";
        String actual = instance.startOz("oxx");

        Assert.assertEquals(expected, actual);
    }

    /*
    startOz("abc") → ""
     */
    @Test
    void startOz_4() {
        String expected = "";
        String actual = instance.startOz("abc");

        Assert.assertEquals(expected, actual);
    }

    /*
    startOz("") → ""
     */
    @Test
    void startOz_5() {
        String expected = "";
        String actual = instance.startOz("");

        Assert.assertEquals(expected, actual);
    }
}