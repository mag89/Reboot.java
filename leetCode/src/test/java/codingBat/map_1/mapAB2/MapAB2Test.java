package codingBat.map_1.mapAB2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapAB2Test {
    private MapAB2 instance = new MapAB2();


    //    mapAB2({"a": "aaa", "b": "aaa", "c": "cake"}) → {"c": "cake"}
    @Test
    void mapAB2() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("c", "cake");
        }};
        Map<String, String> actual = instance.mapAB2(new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "aaa");
            put("c", "cake");
        }});

        assertEquals(expected, actual);
    }

    //    mapAB2({"a": "aaa", "b": "bbb"}) → {"a": "aaa", "b": "bbb"}
    @Test
    void mapAB2_2() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "bbb");
        }};
        Map<String, String> actual = instance.mapAB2(new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "bbb");
        }});

        assertEquals(expected, actual);
    }

    //    mapAB2({"a": "aaa", "b": "bbb", "c": "aaa"}) → {"a": "aaa", "b": "bbb", "c": "aaa"}
    @Test
    void mapAB2_3() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "bbb");
            put("c", "aaa");
        }};
        Map<String, String> actual = instance.mapAB2(new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "bbb");
            put("c", "aaa");
        }});

        assertEquals(expected, actual);
    }
}