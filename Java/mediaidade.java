import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String pessoa1, pessoa2;
        int idade1, idade2; 
        double media;

        

        System.out.print("[PESSOA 1] Digite um nome: ");
        pessoa1 = sc.nextLine();
        System.out.print("[PESSOA 1] Digite uma idade: ");
        idade1 = sc.nextInt();

        System.out.print("[PESSOA 2] Digite um nome: ");
        sc.nextLine(); // limpar o buffer
        pessoa2 = sc.nextLine();
        System.out.print("[PESSOA 2] Digite uma idade: ");
        idade2 = sc.nextInt();

        media = (idade1 + idade2) / 2.0;

        System.out.println();

        System.out.println("DADOS PESSOA 1: ");
        System.out.println("Nome: " + pessoa1);
        System.out.println("Idade: " + idade1);

        System.out.println("DADOS PESSOA 2: ");
        System.out.println("Nome: " + pessoa2);
        System.out.println("Idade: " + idade2);


        System.out.println("MEDIA DAS IDADES: " + media);



        sc.close();
    }
}