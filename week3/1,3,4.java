import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == LEFT_PAREN || c == LEFT_BRACE || c == LEFT_BRACKET) {
                stack.push(c);
            } else if (c == RIGHT_PAREN) {
                if (stack.isEmpty() || stack.pop() != LEFT_PAREN)
                    return false;
            } else if (c == RIGHT_BRACE) {
                if (stack.isEmpty() || stack.pop() != LEFT_BRACE)
                    return false;
            } else if (c == RIGHT_BRACKET) {
                if (stack.isEmpty() || stack.pop() != LEFT_BRACKET)
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = StdIn.readString().trim();
        StdOut.println(isBalanced(s));
    }
}