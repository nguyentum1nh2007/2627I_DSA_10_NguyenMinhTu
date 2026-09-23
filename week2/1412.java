public static void printCommonElements(int[] a, int[] b) {
    int i = 0, j = 0;

    while (i < a.length && j < b.length) {
        if (a[i] < b[j]) {
            i++;
        } else if (a[i] > b[j]) {
            j++;
        } else {
            System.out.println(a[i]);
            int common = a[i];
            while (i < a.length && a[i] == common)
                i++;
            while (j < b.length && b[j] == common)
                j++;
        }
    }
}