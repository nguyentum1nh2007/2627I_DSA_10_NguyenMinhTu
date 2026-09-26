import edu.princeton.cs.algs4.Stack;

public class StackCopyClient {
    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> temp = new Stack<>();
        Stack<String> copy = new Stack<>();

        for (String s : stack) {
            temp.push(s);
        }

        for (String s : temp) {
            copy.push(s);
        }

        return copy;
    }
}