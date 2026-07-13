//150. Evaluate Reverse Polish Notation

import java.util.Stack;

public class pblmNo150 {
     public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("+") || token.equals("-") 
                || token.equals("*") || token.equals("/")) {

                int num1 = stack.pop();
                int num2 = stack.pop();

                switch (token) {
                    case "+" -> stack.push(num2 + num1);
                    case "-" -> stack.push(num2 - num1);
                    case "*" -> stack.push(num2 * num1);
                    default -> // "/"
                        stack.push(num2 / num1);
                }
            } 
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
