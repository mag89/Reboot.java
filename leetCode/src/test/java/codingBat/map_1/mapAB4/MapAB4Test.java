package codingBat.map_1.mapAB4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapAB4Test {
    private MapAB4 instance = new MapAB4();





    //mapAB4({"a": "aaa", "b": "bb", "c": "cake"}) → {"a": "aaa", "b": "bb", "c": "aaa"}
    @Test
    void mapAB4() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("a", "aaa");
            put("b", "bb");
            put("c", "aaa");
        }};
        Map<String, String> actual = instance.mapAB4(new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "bb");
            put("c", "cake");
        }});

        assertEquals(expected, actual);
    }

    //mapAB4({"a": "aa", "b": "bbb", "c": "cake"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
    @Test
    void mapAB4_2() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("a", "aa");
            put("b", "bbb");
            put("c", "bbb");
        }};
        Map<String, String> actual = instance.mapAB4(new HashMap<String, String>() {{
            put("a", "aa");
            put("b", "bbb");
            put("c", "cake");
        }});

        assertEquals(expected, actual);
    }

    //mapAB4({"a": "aa", "b": "bbb"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
    @Test
    void mapAB4_3() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("a", "aa");
            put("b", "bbb");
            put("c", "bbb");
        }};
        Map<String, String> actual = instance.mapAB4(new HashMap<String, String>() {{
            put("a", "aa");
            put("b", "bbb");

        }});

        assertEquals(expected, actual);
    }

    //mapAB4({"a": "aaa", "b": "bbb"}) → {"a": "", "b": "", "c": "bbb"}
    @Test
    void mapAB4_4() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("a", "");
            put("b", "");
        }};
        Map<String, String> actual = instance.mapAB4(new HashMap<String, String>() {{
            put("a", "aaa");
            put("b", "bbb");
        }});

        assertEquals(expected, actual);
    }
}