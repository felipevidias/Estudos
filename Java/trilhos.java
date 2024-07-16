import java.util.Scanner;
import java.util.Stack;

class trilhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            
            while (true) {
                int firstWagon = sc.nextInt();
                if (firstWagon == 0) break;

                int[] desiredOrder = new int[n];
                desiredOrder[0] = firstWagon;
                for (int i = 1; i < n; i++) {
                    desiredOrder[i] = sc.nextInt();
                }

                Stack<Integer> stack = new Stack<>();
                int current = 0;

                for (int i = 1; i <= n; i++) {
                    stack.push(i);
                    while (!stack.isEmpty() && stack.peek() == desiredOrder[current]) {
                        stack.pop();
                        current++;
                    }
                }

                if (stack.isEmpty()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
            
            System.out.println();
        }
        sc.close();
    }
}
