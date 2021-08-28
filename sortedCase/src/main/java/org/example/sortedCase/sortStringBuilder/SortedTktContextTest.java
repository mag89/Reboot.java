package org.example.sortedCase.sortStringBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortedTktContextTest {
    private final StringBuilder sb1 = new StringBuilder();
    private final SortedTktContext instance = new SortedTktContext();

    {
        sb1
                .append("fileName001\t777\n")
                .append("fileName010\t772\n")
                .append("fileName006\t774\n")
                .append("fileName004\t717\n")
                .append("fileName009\t774\n")
                .append("fileName003\t775\n")
                .append("fileName007\t777\n")
                .append("fileName008\t778\n")
                .append("fileName005\t777\n")
                .append("fileName002\t777\n");
    }

    @Test
    void getSortedContextByFC() {
        String expected =
                "fileName001\t777\n" +
                "fileName002\t777\n" +
                "fileName003\t775\n" +
                "fileName004\t717\n" +
                "fileName005\t777\n" +
                "fileName006\t774\n" +
                "fileName007\t777\n" +
                "fileName008\t778\n" +
                "fileName009\t774\n" +
                "fileName010\t772\n";

        StringBuilder actual = instance.getSortedContextByFC(sb1);

        Assertions.assertEquals(expected, actual.toString());
    }
}