import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class posfixainfixa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Limpa o buffer
        
        for (int i = 0; i < n; i++) {
            String infixa = sc.nextLine();
            String posfixa = infixToPostfix(infixa);
            System.out.println(posfixa);
        }
    }

    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String infixa) {
        StringBuilder posfixa = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixa.length(); i++) {
            char c = infixa.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                posfixa.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    posfixa.append(stack.pop());
                }
                stack.pop(); // Remove '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    posfixa.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Expressão inválida!";
            }
            posfixa.append(stack.pop());
        }

        return posfixa.toString();
    }
}
