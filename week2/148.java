import java.util.Arrays;

public class EqualPairs {
    public static int countEqualPairs(int[] a) {
        Arrays.sort(a);
        int pairs = 0;
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                count++;
            } else {
                pairs += (count * (count - 1)) / 2;
                count = 1;
            }
        }
        pairs += (count * (count - 1)) / 2;
        return pairs;
    }
}