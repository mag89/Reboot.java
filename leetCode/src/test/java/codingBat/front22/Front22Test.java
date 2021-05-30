package codingBat.front22;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Front22Test {

    Front22 instance = new Front22();

    /*
    front22("kitten") → "kikittenki"
     */
    @Test
    void front22_1() {
        String expected = "kikittenki";
        String actual = instance.front22("kitten");
        Assert.assertEquals(expected, actual);
    }

    /*
    front22("Ha") → "HaHaHa"
     */
    @Test
    void front22_2() {
        String expected = "HaHaHa";
        String actual = instance.front22("Ha");
        Assert.assertEquals(expected, actual);
    }

    /*
    front22("abc") → "ababcab"
     */
    @Test
    void front22_3() {
        String expected = "ababcab";
        String actual = instance.front22("abc");
        Assert.assertEquals(expected, actual);
    }
}