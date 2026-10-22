import java.util.Scanner;

public class PriorityQueue {

    private static final int MAX_SIZE = 100;
    private static float[] arr = new float[MAX_SIZE];
    private static int point = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    private static void insert(float number) {
        if (point < MAX_SIZE - 1) {
            point++;
            arr[point] = number;
        }
    }

    private static int deleteMin() {
        quickSort(arr, 0, point);
        int min = (int) arr[point];
        arr[point] = 0.0f;
        point--;
        return min;
    }

    private static void quickSort(float[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(float[] arr, int low, int high) {
        float pivot = arr[low];
        int storeIndex = low;

        for (int i = low + 1; i <= high; i++) {
            if (arr[i] > pivot) { 
                storeIndex++;
                swap(arr, i, storeIndex);
            }
        }

        swap(arr, low, storeIndex);
        return storeIndex;
    }

    private static void swap(float[] arr, int i, int j) {
        float temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}