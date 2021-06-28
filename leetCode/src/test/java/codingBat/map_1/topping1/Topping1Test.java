package codingBat.map_1.topping1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Topping1Test {
    private Topping1 instance = new Topping1();


    //topping1({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
    @Test
    public void topping1() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("bread", "butter");
            put("ice cream", "cherry");
        }};
        Map<String, String> actual = instance.topping1(new HashMap<String, String>() {{
            put("ice cream", "peanuts");
        }});

        Assert.assertEquals(expected, actual);
    }

    //topping1({}) → {"bread": "butter"}
    @Test
    public void topping1_2() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("bread", "butter");
        }};
        Map<String, String> actual = instance.topping1(new HashMap<String, String>());

        Assert.assertEquals(expected, actual);
    }

    //topping1({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}
    @Test
    public void topping1_3() {
        Map<String, String> expected = new HashMap<String, String>() {{
            put("bread", "butter");
            put("ice cream", "cherry");
        }};
        Map<String, String> actual = instance.topping1(new HashMap<String, String>() {{
            put("ice cream", "peanuts");
        }});

        Assert.assertEquals(expected, actual);
    }
}