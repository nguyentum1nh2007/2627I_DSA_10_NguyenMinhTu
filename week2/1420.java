public class BitonicSearch {

    private static int findPeak(int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < a[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int binarySearchIncreasing(int[] a, int key, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int binarySearchDecreasing(int[] a, int key, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                lo = mid + 1;
            } else if (key > a[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int search(int[] a, int key) {
        if (a == null || a.length == 0)
            return -1;

        int peak = findPeak(a);

        if (a[peak] == key)
            return peak;

        int index = binarySearchIncreasing(a, key, 0, peak - 1);
        if (index != -1)
            return index;

        return binarySearchDecreasing(a, key, peak + 1, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 5, 9, 12, 10, 8, 4, 2, 0 };
        int key = 8;

        int result = search(a, key);
        if (result != -1) {
            System.out.println("Tìm thấy " + key + " tại chỉ số: " + result);
        } else {
            System.out.println("Không tìm thấy " + key + " trong mảng.");
        }
    }
}