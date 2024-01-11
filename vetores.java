import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros serao digitados? ");
        int n = 0;
        n = sc.nextInt();

        double vet[] = new double[n];
        for(int i = 0; i < n; i = i + 1)
        {
            System.out.print("Digite um numero: ");
            vet[i] = sc.nextDouble();
        }

        System.out.print("Vetor: ");
        for(int i = 0; i < n; i = i + 1)
        {
            System.out.print(vet[i] + " ");
        }

        System.out.println();


        sc.close();
    }
}