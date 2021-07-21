package edabit.brokenKeyboard;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class BrokenKeyboardTest {
    private final BrokenKeyboard instance = new BrokenKeyboard();

    @Test
    public void test1() {
        assertThat(instance.findBrokenKeys3("happy birthday", "hawwy birthday"), is(new String[]{"p"}));
    }

    @Test
    public void test2() {
        assertThat(instance.findBrokenKeys3("starry night", "starrq light"), is(new String[]{"y", "n"}));
    }

    @Test
    public void test3() {
        assertThat(instance.findBrokenKeys3("beethoven", "affthoif5"), is(new String[]{"b", "e", "v", "n"}));
    }

    @Test
    public void test4() {
        assertThat(instance.findBrokenKeys3("mozart", "aiwgvx"), is(new String[]{"m", "o", "z", "a", "r", "t"}));
    }

    @Test
    public void test5() {
        System.out.println("It should work for numbers.");
        assertThat(instance.findBrokenKeys3("5678", "4678"), is(new String[]{"5"}));
    }

    @Test
    public void test6() {
        System.out.println("It should work for punctuation.");
        assertThat(instance.findBrokenKeys3("!!??$$", "$$!!??"), is(new String[]{"!", "?", "$"}));
    }
}