package codingBat.max1020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Max1020 {
    /*
    Given 2 positive int values, return the larger value that is in the range 10..20 inclusive, or return 0 if neither
    is in that range.

     */

    public int max1020(int a, int b) {

        boolean aInRange = isIn1020(a);
        boolean bInRange = isIn1020(b);

        if (aInRange && bInRange) {
            return Math.max(a, b);
        }

        if (!aInRange && !bInRange) {
            return 0;
        }

        if (!aInRange) {
            return b;
        } else {
            return a;
        }
    }

    private boolean isIn1020(int n) {
        return n >= 10 && n <= 20;
    }
}
