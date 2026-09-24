import java.util.*;
class Result {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int height : h1) sum1 += height;
        for (int height : h2) sum2 += height;
        for (int height : h3) sum3 += height;

        int i1 = 0, i2 = 0, i3 = 0;
        while (sum1 != sum2 || sum2 != sum3) {
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1.get(i1++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2.get(i2++);
            } else {
                sum3 -= h3.get(i3++);
            }
        }

        return sum1;
    }

}