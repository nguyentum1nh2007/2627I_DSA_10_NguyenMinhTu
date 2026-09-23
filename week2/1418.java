public class LocalMinimum {

    public static int findLocalMinimum(int[] a) {
        if (a == null || a.length == 0)
            return -1;

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            boolean leftIsGreater = (mid == 0) || (a[mid] < a[mid - 1]);
            boolean rightIsGreater = (mid == a.length - 1) || (a[mid] < a[mid + 1]);

            if (leftIsGreater && rightIsGreater) {
                return mid;
            } else if (mid > 0 && a[mid] > a[mid - 1]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 9, 7, 2, 8, 5, 6, 3, 4 };
        int index = findLocalMinimum(a);

        System.out.println("Index of local minimum: " + index);
        System.out.println("Local minimum: " + a[index]);
    }
}