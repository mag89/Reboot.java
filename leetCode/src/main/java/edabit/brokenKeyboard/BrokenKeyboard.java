package edabit.brokenKeyboard;
/*
Given what is supposed to be typed and what is actually typed, write a function that returns the broken key(s)
 */

import java.util.stream.IntStream;

public class BrokenKeyboard {
    public static String[] findBrokenKeys(String str1, String str2) {
        int l = str1.length();
        String[] tempResult = new String[l];

        int sizeOfResult = 0;
        for (int i = 0; i < l; i++) {
            String letter = str1.substring(i, i + 1);
            if (str1.charAt(i) != str2.charAt(i)) {

                boolean containce = false;
                for (String s : tempResult) {
                    if (s != null && s.equals(letter)) {
                        containce = true;
                        break;
                    }
                }
                if (!containce) {
                    sizeOfResult++;
                    tempResult[i] = letter;

                }
            }
        }


        String[] result = new String[sizeOfResult];
        int index = 0;
        for (int i = 0; i < l; i++) {
            if (tempResult[i] != null) {
                result[index] = tempResult[i];
                index++;
            }
        }

        return result;
    }


    public static String[] findBrokenKeys2(String str1, String str2) {
        String result = "";

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i) && !result.contains(str1.charAt(i) + "")) {
                result += str1.charAt(i) + "";
            }
        }
        return result.split("");
    }


    public static String[] findBrokenKeys3(String str1, String str2) {
        return IntStream.range(0, str1.length()).filter(i -> str1.charAt(i) != str2.charAt(i))
                .mapToObj(i -> str1.charAt(i) + "").distinct().toArray(String[] :: new);
    }


}
