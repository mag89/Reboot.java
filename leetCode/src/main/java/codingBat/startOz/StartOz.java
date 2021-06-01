package codingBat.startOz;

public class StartOz {

    /*

    Given a string, return a string made of the first 2 chars (if present), however include first char only if it is 'o'
    and include the second only if it is 'z', so "ozymandias" yields "oz".

     */

    public String startOz(String str) {
        if (str.equals("")) {
            return "";
        }

        if (str.startsWith("oz")) {
            return "oz";
        } else if (str.startsWith("o")) {
            return "o";
        } else if (str.charAt(1) == 'z') {
            return "z";
        }
        return "";

    }
}

