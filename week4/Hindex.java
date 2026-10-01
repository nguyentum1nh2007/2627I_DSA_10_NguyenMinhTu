import java.util.Arrays;
import java.util.Scanner;

public class Hindex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] citations = new int[n];
        for (int i = 0; i < n; i++) {
            citations[i] = sc.nextInt();
        }

        Arrays.sort(citations);

        int i = 0;
        while (i < n && citations[n - 1 - i] > i) {
            i++;
        }
        System.out.print(i);
    }
}