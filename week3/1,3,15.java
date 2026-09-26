import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KthFromLast {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> queue = new Queue<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            queue.enqueue(item);
            if (queue.size() > k) {
                queue.dequeue();
            }
        }

        if (queue.size() == k) {
            StdOut.println(queue.dequeue());
        }
    }
}