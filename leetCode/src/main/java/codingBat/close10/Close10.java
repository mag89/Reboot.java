package codingBat.close10;

public class Close10 {
    /*
    close10(8, 13) → 8
    close10(13, 8) → 8
    close10(13, 7) → 0
     */
    public int close10(int a, int b) {
        int y = Math.abs(10 - a);
        int x = Math.abs(10 - b);

        if (y < x) {
            return a;
        }

        if (y == x) {
            return 0;
        }

        return b;
    }
}
