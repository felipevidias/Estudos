import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        int n;
        double soma, media;
        System.out.print("Digite o tamanho do vetor: ");
        n = sc.nextInt();

        double vet[] = new double[n];

        for(int i = 0; i < n; i = i + 1)
        {
            System.out.print("Digite um numero: ");
            vet[i] = sc.nextDouble();
        } // end for 

        System.out.print("VETOR: ");
        for(int i = 0; i < n; i = i + 1)
        {
            System.out.print(String.format("%.2f\t", vet[i]));
        } // end for 

        System.out.println();

        soma = 0;
        for(int i = 0; i < n; i = i + 1)
        {
            soma = soma + vet[i];
        } // end for 

        System.out.println("SOMA: " + soma);

        media = soma / n;

        System.out.println("MEDIA: " + media);

        sc.close();

    }
}