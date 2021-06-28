package codingBat.map_1.mapAB;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MapABTest {
    private MapAB instance = new MapAB();


    //mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
    @Test
    public void mapAB() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("a", "Hi");
            put("b", "There");
            put("ab", "HiThere");
        }};
        Map<String, String> actual = instance.mapAB(new HashMap<String, String>(){{
            put("a", "Hi");
            put("b", "There");
        }});

        Assert.assertEquals(expected, actual);
    }

    //mapAB({"a": "Hi"}) → {"a": "Hi"}
    @Test
    public void mapAB_2() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("a", "Hi");
        }};
        Map<String, String> actual = instance.mapAB(new HashMap<String, String>(){{
            put("a", "Hi");
        }});

        Assert.assertEquals(expected, actual);
    }

    //mapAB({"b": "There"}) → {"b": "There"}
    @Test
    public void mapAB_3() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("b", "There");
        }};
        Map<String, String> actual = instance.mapAB(new HashMap<String, String>(){{
            put("b", "There");
        }});

        Assert.assertEquals(expected, actual);
    }
}