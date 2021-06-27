package codingBat.warmup_2.stringTimes;

public class StringTimes {

    /*

Given a string and a non-negative int n, return a larger string that is n copies of the original string.


stringTimes("Hi", 2) → "HiHi"
stringTimes("Hi", 3) → "HiHiHi"
stringTimes("Hi", 1) → "Hi"
     */

    public String stringTimes(String str, int n) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i<n; i++) {
            result.append(str);
        }
        return result.toString();
    }
}
