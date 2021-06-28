package codingBat.map_1.topping3;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Topping3Test {
    private Topping3 instance = new Topping3();



    //topping3({"potato": "ketchup"}) → {"potato": "ketchup", "fries": "ketchup"}
    @Test
    public void topping3() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("potato", "ketchup");
            put("fries", "ketchup");
        }};
        Map<String, String> actual = instance.topping3(new HashMap<String, String>() {{
            put("potato", "ketchup");
        }});

        Assert.assertEquals(expected, actual);
    }

    //topping3({"potato": "butter"}) → {"potato": "butter", "fries": "butter"}
    @Test
    public void topping3_2() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("potato", "butter");
            put("fries", "butter");
        }};
        Map<String, String> actual = instance.topping3(new HashMap<String, String>() {{
            put("potato", "butter");
        }});

        Assert.assertEquals(expected, actual);
    }

    //topping3({"salad": "oil", "potato": "ketchup"}) → {"spinach": "oil", "salad": "oil", "potato": "ketchup", "fries": "ketchup"}
    @Test
    public void topping3_3() {
        Map<String, String> expected = new HashMap<String, String>(){{
            put("spinach", "oil");
            put("salad", "oil");
            put("potato", "ketchup");
            put("fries", "ketchup");
        }};
        Map<String, String> actual = instance.topping3(new HashMap<String, String>() {{
            put("salad", "oil");
            put("potato", "ketchup");
        }});

        Assert.assertEquals(expected, actual);
    }
}