package codingBat.map_1.topping2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Topping2Test {
    private Topping2 instance = new Topping2();







    //topping2({"ice cream": "cherry"}) → {"yogurt": "cherry", "ice cream": "cherry"}
    @Test
    public void topping2() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("yogurt", "cherry");
            put("ice cream", "cherry");
        }};
        Map<String, String> actual = instance.topping2(new HashMap<String, String>() {{
            put("ice cream", "cherry");
        }});

        Assert.assertEquals(expected, actual);
    }

    //topping2({"spinach": "dirt", "ice cream": "cherry"}) → {"yogurt": "cherry", "spinach": "nuts", "ice cream": "cherry"}
    @Test
    public void topping2_2() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("yogurt", "cherry");
            put("spinach", "nuts");
            put("ice cream", "cherry");
        }};
        Map<String, String> actual = instance.topping2(new HashMap<String, String>() {{
            put("spinach", "dirt");
            put("ice cream", "cherry");
        }});

        Assert.assertEquals(expected, actual);
    }

    //topping2({"yogurt": "salt"}) → {"yogurt": "salt"}
    @Test
    public void topping2_3() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("yogurt", "salt");
        }};
        Map<String, String> actual = instance.topping2(new HashMap<String, String>() {{
            put("yogurt", "salt");
        }});

        Assert.assertEquals(expected, actual);
    }
}