package codingBat.map_1.mapBully;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapBullyTest {
    private MapBully instance = new MapBully();

    //mapBully({"a": "candy", "b": "dirt"}) → {"a": "", "b": "candy"}
    @Test
    public void mapBully() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "");
            put("b", "candy");
        }};

        Map<String, String> actual = instance.mapBully(new HashMap<String, String>() {{
            put("a", "candy");
            put("b", "dirt");
        }});

        Assert.assertEquals(expected, actual);
    }

    //mapBully({"a": "candy"}) → {"a": "", "b": "candy"}
    @Test
    public void mapBully_2() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "");
            put("b", "candy");
        }};

        Map<String, String> actual = instance.mapBully(new HashMap<String, String>() {{
            put("a", "candy");
        }});

        Assert.assertEquals(expected, actual);
    }

    //mapBully({"a": "candy", "b": "carrot", "c": "meh"}) → {"a": "", "b": "candy", "c": "meh"}
    @Test
    public void mapBully_3() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "");
            put("b", "candy");
            put("c", "meh");
        }};

        Map<String, String> actual = instance.mapBully(new HashMap<String, String>() {{
            put("a", "candy");
            put("b", "carrot");
            put("c", "meh");
        }});

        Assert.assertEquals(expected, actual);
    }

    //mapBully({"a": "sparkle", "c": "meh"}) → {"a": "", "b": "sparkle", "c": "meh"}
    @Test
    public void mapBully_4() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "");
            put("b", "sparkle");
            put("c", "meh");
        }};

        Map<String, String> actual = instance.mapBully(new HashMap<String, String>() {{
            put("a", "");
            put("b", "sparkle");
            put("c", "meh");
        }});

        Assert.assertEquals(expected, actual);
    }

}