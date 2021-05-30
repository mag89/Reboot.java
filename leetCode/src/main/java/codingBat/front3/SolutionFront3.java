package codingBat.front3;

public class SolutionFront3 {

    /*
    Given a string, we'll say that the front is the first 3 chars of the string. If the string length is less than 3,
     the front is whatever is there. Return a new string which is 3 copies of the front.
     */

    public String front3(String str) {
        StringBuilder result = new StringBuilder();

        if (str.length() < 3) {
            return result.append(str).append(str).append(str).toString();
        }

        String first3char = str.substring(0, 3);

        return result.append(first3char).append(first3char).append(first3char).toString();
    }
}
