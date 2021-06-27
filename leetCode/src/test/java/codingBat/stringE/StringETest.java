package codingBat.stringE;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringETest {
    private StringE instance = new StringE();




    //stringE("Hello") → true
    @Test
    public void stringE() {

        boolean actual = instance.stringE("Hello");

        Assert.assertTrue(actual);
    }

    //stringE("Heelle") → true
    @Test
    public void stringE_2() {

        boolean actual = instance.stringE("Heelle");

        Assert.assertTrue(actual);
    }

    //stringE("Heelele") → false
    @Test
    public void stringE_3() {

        boolean actual = instance.stringE("Heelele");

        Assert.assertFalse(actual);
    }
}