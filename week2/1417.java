public class FarthestPair {
    public static void findFarthestPair(double[] a) {
        if (a == null || a.length < 2) {
            System.out.println("Error");
            return;
        }

        double min = a[0];
        double max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        System.out.println("Farthest Pair: " + min + " và " + max);
        System.out.println("Distance: " + Math.abs(max - min));
    }

    public static void main(String[] args) {
        double[] a = { 15.2, 2.1, 4.3, 7.8, 10.5, -3.4 };
        findFarthestPair(a);
    }
}