import java.util.Locale;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);

        int idade;
        double salario, altura;
        char genero;
        String nome;

        idade = 30;
        salario = 4200.5;
        altura = 1.8;
        genero = 'M';
        nome = "Mugabe";

        System.out.println("idade = " + idade);
        System.out.println("salario = " + String.format ("%.2f", salario));
        System.out.println("altura = " + String.format ("%.2f", altura));
        System.out.println("genero = " + genero);
        System.out.println("nome = " + nome);

    }
}