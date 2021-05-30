package codingBat.delDel;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelDelTest {
    private DelDel instance = new DelDel();

    /*
delDel("adelbc") → "abc"
     */
    @Test
    void delDel() {
        String actual = instance.delDel("adelbc");
        String expect = "abc";
        Assert.assertEquals(expect, actual);
    }

    /*
delDel("adelHello") → "aHello"
     */
    @Test
    void delDel_2() {
        String actual = instance.delDel("adelHello");
        String expect = "aHello";
        Assert.assertEquals(expect, actual);
    }

    /*
delDel("adedbc") → "adedbc"
     */
    @Test
    void delDel_3() {
        String actual = instance.delDel("adedbc");
        String expect = "adedbc";
        Assert.assertEquals(expect, actual);
    }

    /*
delDel("del") → "del"
     */
    @Test
    void delDel_4() {
        String actual = instance.delDel("del");
        String expect = "del";
        Assert.assertEquals(expect, actual);
    }
}