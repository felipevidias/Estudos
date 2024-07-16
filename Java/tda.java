import java.util.Scanner;

public class tda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int n1, n2, d1, d2;
            String div1, div2;
            char op;
            n1 = sc.nextInt();
            div1 = sc.next();
            d1 = sc.nextInt();
            op = sc.next().charAt(0);
            n2 = sc.nextInt();
            div2 = sc.next();
            d2 = sc.nextInt();
            String result = "";
            String simpleResult = "";
            if(op == '+'){
                result = (n1*d2 + n2*d1) + "/" + (d1*d2);
                int numerator = n1*d2 + n2*d1;
                int denominator = d1*d2;
                int gcd = 1;
                for (int j = 1; j <= numerator && j <= denominator; j++) {
                    if (numerator % j == 0 && denominator % j == 0) {
                        gcd = j;
                    }
                }
                simpleResult = (numerator / gcd) + "/" + (denominator / gcd);
            } else if(op == '-'){
                result = (n1*d2 - n2*d1) + "/" + (d1*d2);
                int numerator = n1*d2 - n2*d1;
                int denominator = d1*d2;
                int gcd = 1;
                for (int j = 1; j <= Math.abs(numerator) && j <= denominator; j++) {
                    if (numerator % j == 0 && denominator % j == 0) {
                        gcd = j;
                    }
                }
                simpleResult = (numerator / gcd) + "/" + (denominator / gcd);
            } else if(op == '*'){
                result = (n1*n2) + "/" + (d1*d2);  
                int numerator = n1*n2;
                int denominator = d1*d2;
                int gcd = 1;
                for (int j = 1; j <= numerator && j <= denominator; j++) {
                    if (numerator % j == 0 && denominator % j == 0) {
                        gcd = j;
                    }
                }
                simpleResult = (numerator / gcd) + "/" + (denominator / gcd);
            } else if(op == '/'){
                result = (n1*d2) + "/" + (n2*d1);  
                int numerator = n1*d2;
                int denominator = n2*d1;
                int gcd = 1;
                for (int j = 1; j <= numerator && j <= denominator; j++) {
                    if (numerator % j == 0 && denominator % j == 0) {
                        gcd = j;
                    }
                }
                simpleResult = (numerator / gcd) + "/" + (denominator / gcd);
            }
            System.out.println(result + " = " + simpleResult);
        }
        sc.close();
    }
}
