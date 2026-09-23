import java.util.Arrays;

public class ClosestPair {
    public static void findClosestPair(double[] a) {
        if (a == null || a.length < 2) {
            System.out.println("Error");
            return;
        }

        Arrays.sort(a);

        double minDiff = Double.MAX_VALUE;
        double num1 = a[0];
        double num2 = a[1];

        for (int i = 1; i < a.length; i++) {
            double diff = Math.abs(a[i] - a[i - 1]);

            if (diff < minDiff) {
                minDiff = diff;
                num1 = a[i - 1];
                num2 = a[i];
            }
        }

        System.out.println("Closest Pair: " + num1 + " and " + num2);
        System.out.println("Distance: " + minDiff);
    }

    public static void main(String[] args) {
        double[] a = { 15.2, 2.1, 4.3, 7.8, 10.5, 4.5 };
        findClosestPair(a);
    }
}