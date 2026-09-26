import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ParenthesesInfix {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                String val2 = vals.pop();
                String val1 = vals.pop();
                String subExpr = "( " + val1 + " " + op + " " + val2 + " )";
                vals.push(subExpr);
            } else if (!s.equals("(")) {
                vals.push(s);
            }
        }
        StdOut.println(vals.pop());
    }
}