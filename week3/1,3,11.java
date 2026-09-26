import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
    public static void main(String[] args) {
        Stack<Double> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) {
                vals.push(vals.pop() + vals.pop());
            } else if (s.equals("-")) {
                double v2 = vals.pop();
                double v1 = vals.pop();
                vals.push(v1 - v2);
            } else if (s.equals("*")) {
                vals.push(vals.pop() * vals.pop());
            } else if (s.equals("/")) {
                double v2 = vals.pop();
                double v1 = vals.pop();
                vals.push(v1 / v2);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}