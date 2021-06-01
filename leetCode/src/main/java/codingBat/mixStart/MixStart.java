package codingBat.mixStart;

public class MixStart {
    /*
    Return true if the given string begins with "mix", except the 'm' can be anything, so "pix", "9ix" .. all count.
     */

    public boolean mixStart(String str) {
        boolean res = false;

        if (str.length() > 3) {
            res = str.substring(1, 3).equals("ix");
        }
        if (str.length() == 3 && str.substring(1).equals("ix")) {
            res = true;
        }

        return res;
    }

}
