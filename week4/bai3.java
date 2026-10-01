import java.util.List;
class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        int valueToInsert = arr.get(n - 1);
        boolean inserted = false;

        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) > valueToInsert) {
                arr.set(i + 1, arr.get(i));
                printArray(arr);
            } else {
                arr.set(i + 1, valueToInsert);
                printArray(arr);
                inserted = true;
                break;
            }
        }

        if (!inserted) {
            arr.set(0, valueToInsert);
            printArray(arr);
        }
    }

    private static void printArray(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + (i == arr.size() - 1 ? "" : " "));
        }
        System.out.println();
    }
}