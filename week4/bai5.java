import java.util.List;

class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
            printArray(arr);
        }
    }

    private static void printArray(List<Integer> arr) {
        for (int k = 0; k < arr.size(); k++) {
            System.out.print(arr.get(k) + (k == arr.size() - 1 ? "" : " "));
        }
        System.out.println();
    }
}