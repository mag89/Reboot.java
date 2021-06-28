package codingBat.map_1.mapShare;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapShareTest {
    private MapShare instance = new MapShare();


    //mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
    @Test
    public void mapShare() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "aaa");
        }};
        Map<String, String> actual = instance.mapShare(new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "bbb");
            put("c", "ccc");

        }});

        Assert.assertEquals(expected, actual);
    }

    //mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
    @Test
    public void mapShare_2() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("b", "xyz");
        }};
        Map<String, String> actual = instance.mapShare(new HashMap<String, String>() {{
            put("b", "xyz");
            put("c", "ccc");

        }});

        Assert.assertEquals(expected, actual);
    }

    //mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
    @Test
    public void mapShare_3() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "aaa");
            put("d", "hi");
        }};
        Map<String, String> actual = instance.mapShare(new HashMap<String, String>() {{
            put("a", "aaa");
            put("c", "meh");
            put("d", "hi");

        }});

        Assert.assertEquals(expected, actual);
    }
}