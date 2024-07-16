import java.util.Scanner;
import java.util.Locale;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc =  new Scanner(System.in); // para leitura de  dados 

     String nome1, nome2;
     double salario1, salario2;
     int idade;
     char sexo;

     System.out.print("Digite o nome da primeira pessoa: ");
     nome1 = sc.nextLine(); // ler strings 
     System.out.print("Digite o salario da primeira pessoa: ");
     salario1 = sc.nextDouble(); // ler reais

     System.out.print("Digite o nome da segunda pessoa: ");
     sc.nextLine(); // limpar o buffer 
     nome2 = sc.nextLine(); // ler strings 
     System.out.print("Digite o salario da segunda pessoa: ");
     salario2 = sc.nextDouble(); // ler reais

     System.out.print("Digite uma idade: ");
     idade = sc.nextInt();
     System.out.print("Digite um sexo (M/F): ");
     sexo = sc.next().charAt(0); // para ler um unico caractere

     System.out.println("Nome P1: "+ nome1);
     System.out.println("Salario P1: "+ String.format("%.2f", salario1));

     System.out.println("Nome P2: "+ nome2);
     System.out.println("Salario P2: "+ String.format("%.2f", salario2));

     System.out.println("Idade: "+ idade);
     System.out.println("Sexo: " + sexo); 

     sc.close(); // bom colocar 
    }
}