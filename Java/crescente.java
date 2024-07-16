import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n1,n2;

        System.out.print("Digite um numero: ");
        n1 = sc.nextInt();
         System.out.print("Digite outro numero: ");
        n2 = sc.nextInt();

        if(n1 < n2)
        {
        System.out.println("CRESCENTE");
        } 
        else if (n1 > n2)
        {
        System.out.println("DECRESCENTE");
        } 
        else if(n1 == n2)
        {
        System.out.println("IGUAIS");
        } // end if 
        

        
        sc.close();

    }
}