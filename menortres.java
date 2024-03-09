import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int vet[ ] = new int[3];
        int maior, medio, menor;

        for(int i = 0; i < 3; i = i + 1)
        {
            System.out.print("Digite um numero: ");
            vet[i] = sc.nextInt();
        }
        
        menor = vet[0];
        medio = vet[0];
        maior = vet[0];
        
        for(int j = 0; j < 3; j = j + 1)
        {
        
            if(vet[j] < menor)
            {
                menor = vet[j];
            }
        }

         for(int x = 0; x < 3; x = x + 1)
        {
        
            if(vet[x] > maior)
            {
                maior = vet[x];
            }
        }

          for(int y = 0; y < 3; y = y + 1)
        {
        
            if(vet[y] > menor && vet[y] < maior)
            {
                medio = vet[y];
            }
        }

        System.out.println("O maior valor e: " + maior);
        System.out.println("O segundo valor e: " + medio);
        System.out.println("O menor valor e: " + menor);

      

        sc.close();
    }
}