package codingBat.delDel;

public class DelDel {
    /*

    Given a string, if the string "del" appears starting at index 1, return a string where that "del" has been deleted.
    Otherwise, return the string unchanged.
     */

    public String delDel(String str) {

        if (str.length() > 3 && str.substring(1, 4).equals("del")) {

            StringBuilder result = new StringBuilder();
            return result.append(str.charAt(0)).append(str.substring(4)).toString();
        }

        return str;
    }

}
