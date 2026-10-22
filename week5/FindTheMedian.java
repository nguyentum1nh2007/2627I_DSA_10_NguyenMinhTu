import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FindTheMedian {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        String[] tokens = line.trim().split("\\s+");
        float[] numbers = new float[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Float.parseFloat(tokens[i]);
        }

        quickSort(numbers, 0, numbers.length - 1);

        int mid = numbers.length / 2;
        System.out.println(numbers[mid]);
    }

    private static void quickSort(float[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(float[] arr, int left, int right) {
        float pivot = arr[left];
        int storeIndex = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                storeIndex++;
                swap(arr, i, storeIndex);
            }
        }

        swap(arr, left, storeIndex);
        return storeIndex;
    }
    private static void swap(float[] arr, int i, int j) {
        float temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}