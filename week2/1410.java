public static int binarySearchSmallestIndex(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;
    int result = -1;

    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            hi = mid - 1;
        } else if (key > a[mid]) {
            lo = mid + 1;
        } else {
            result = mid;
            hi = mid - 1;
        }
    }
    return result;
}