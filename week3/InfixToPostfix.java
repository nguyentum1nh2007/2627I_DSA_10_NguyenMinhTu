import java.util.Stack;

public class InfixToPostfix {
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0; 
    }

    public static String convert(String infix) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        for (char c : infix.toCharArray()) {
            if (c == ' ') continue; 

            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            } 

            else if (c == '(') {
                stack.push(c);
            } 

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop(); 
            } 

            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args){
        String infix = "a*(b+c)/d";
        System.out.println(convert(infix));
    }
}
