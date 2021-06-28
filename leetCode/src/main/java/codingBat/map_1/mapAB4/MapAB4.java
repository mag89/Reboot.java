package codingBat.map_1.mapAB4;

/*
Modify and return the given map as follows: if the keys "a" and "b" have values that have different lengths, then set
"c" to have the longer value. If the values exist and have the same length, change them both to the empty string in the
map.


mapAB4({"a": "aaa", "b": "bb", "c": "cake"}) → {"a": "aaa", "b": "bb", "c": "aaa"}
mapAB4({"a": "aa", "b": "bbb", "c": "cake"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
mapAB4({"a": "aa", "b": "bbb"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
 */

import java.util.Map;

public class MapAB4 {
    public Map<String, String> mapAB4(Map<String, String> map) {

        if (map.containsKey("a") && map.containsKey("b")) {
            String a = map.get("a");
            String b = map.get("b");
            int lengthA = a.length();
            int lengthB = b.length();

            if (lengthA == lengthB) {
                map.put("a", "");
                map.put("b", "");

            } else {
                String s = lengthA > lengthB ? map.put("c", a) : map.put("c", b);
            }
        }
        return map;
    }
}
