import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class Main
{

    public static String alteracao(String s, char origin, char sub)
    {
        StringBuilder result = new StringBuilder();

        for (char caractere : s.toCharArray())
        {
            if (caractere == origin) {
                result.append(sub);
            }
            else
            {
                result.append(caractere);
            } // end if
        } // end for 

        return result.toString();
    } // end alteracao

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Random gerador = new Random();
        gerador.setSeed(4);

        // Entrada de dados
        System.out.print("Digite uma string: ");
        String s = sc.next();

        for (int i = 0; i < s.length(); i++)
        {
            char letraOriginal = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char letraSubstituta = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

            System.out.println("Letras sorteadas: " + letraOriginal + "->" + letraSubstituta);

            // Aplica a substituição e exibe o resultado
            String linhaSubstituida = alteracao(s, letraOriginal, letraSubstituta);
            System.out.println(linhaSubstituida);
        } // end for 

        sc.close();
    } // end main 
} // end class
