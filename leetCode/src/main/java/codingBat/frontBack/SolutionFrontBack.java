package codingBat.frontBack;

public class SolutionFrontBack {
    /*
    Given a string, return a new string where the first and last chars have been exchanged.


    frontBack("code") → "eodc"
    frontBack("a") → "a"
    frontBack("ab") → "ba"
     */

    public String frontBack(String str) {
        if (str.equals("")) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        int sizeOfchars = chars.length;
        char firstChar = chars[0];

        if (sizeOfchars == 1) {
            return str;
        }

        if (sizeOfchars == 2) {
            char secondChar = chars[1];
            builder.append(secondChar);
            builder.append(firstChar);
            return builder.toString();
        }


        int lastIndexOfChars = chars.length - 1;
        char lastChar = chars[lastIndexOfChars];
        builder.append(lastChar);

        for (int i = 0; i < chars.length; i++) {
            if (i != 0 & i != lastIndexOfChars) {
                builder.append(chars[i]);
            }

        }
        builder.append(firstChar);
        return builder.toString();


    }

    public String frontBack2(String str) {
        int size = str.length();

        if (size <= 1) {
            return str;
        } else {
            char f = str.charAt(0);
            String mid = str.substring(1, size - 1);
            char l = str.charAt(size - 1);
            return l + mid + f;
        }


    }
}
