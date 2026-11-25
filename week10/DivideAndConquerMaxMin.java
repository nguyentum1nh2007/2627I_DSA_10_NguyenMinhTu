class Pair {
    int min;
    int max;

    public Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

public class DivideAndConquerMaxMin {
    public static Pair findMaxMin(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], arr[left]);
        }

        if (right == left + 1) {
            if (arr[left] > arr[right]) {
                return new Pair(arr[right], arr[left]);
            } else {
                return new Pair(arr[left], arr[right]);
            }
        }

        int mid = left + (right - left) / 2;
        Pair leftPair = findMaxMin(arr, left, mid);
        Pair rightPair = findMaxMin(arr, mid + 1, right);
        int overallMin = Math.min(leftPair.min, rightPair.min);
        int overallMax = Math.max(leftPair.max, rightPair.max);

        return new Pair(overallMin, overallMax);
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 99, -3, 24};
        if (arr == null || arr.length == 0) {
            System.out.println("Mảng rỗng!");
            return;
        }
        Pair result = findMaxMin(arr, 0, arr.length - 1);

        System.out.println("Gia tri nho nhat (Min): " + result.min);
        System.out.println("Gia tri lon nhat (Max): " + result.max);
    }
}