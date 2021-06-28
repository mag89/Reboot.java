package codingBat.map_1.mapAB3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapAB3Test {
    private MapAB3 instance = new MapAB3();


    //mapAB3({"a": "aaa", "c": "cake"}) → {"a": "aaa", "b": "aaa", "c": "cake"}
    @Test
    void mapAB3() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "aaa");
            put("c", "cake");
        }};
        Map<String, String> actual = instance.mapAB3(new HashMap<String, String>() {{
            put("a", "aaa");
            put("c", "cake");
        }});

        assertEquals(expected, actual);
    }

    //mapAB3({"b": "bbb", "c": "cake"}) → {"a": "bbb", "b": "bbb", "c": "cake"}
    @Test
    void mapAB3_2() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "bbb");
            put("b", "bbb");
            put("c", "cake");
        }};
        Map<String, String> actual = instance.mapAB3(new HashMap<String, String>() {{
            put("b", "bbb");
            put("c", "cake");
        }});

        assertEquals(expected, actual);
    }

    //mapAB3({"a": "aaa", "b": "bbb", "c": "cake"}) → {"a": "aaa", "b": "bbb", "c": "cake"}
    @Test
    void mapAB3_3() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "bbb");
            put("c", "cake");
        }};
        Map<String, String> actual = instance.mapAB3(new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "bbb");
            put("c", "cake");
        }});

        assertEquals(expected, actual);
    }
}