import java.util.Scanner;
import java.util.Locale;

public class Main
{
    public static String ciframento(String s, int chave)
    {
        StringBuilder result = new StringBuilder(); // objeto para serem mudados com mais facilidade 

        for(int i = 0; i < s.length(); i = i + 1)
        {
            char caractere = s.charAt(i);
            if(Character.isLetter(caractere))
            {
                char base = Character.isUpperCase(caractere) ? 'A' : 'a'; // verificar se caractere é maiusculo
                caractere = (char) ((caractere - base + chave) % 26 + base); // retorna a posição relativa do caractere no intervalo de 0 a 25 + a chave
            } // end if 
            result.append(caractere); // acrescentar o caractere
        } // end for( )

        return result.toString();
    } // end ciframento( )

    public static void main(String[] args)
    {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);

      // definir dados
      String s;
      int chave;
      System.out.print("Digite uma string: ");
      s = sc.nextLine();
      System.out.print("Digite uma chave: ");
      chave = sc.nextInt();

      // aplicar funções auxiliares
      String cifrada = ciframento(s, chave);

      System.out.println("Original: " + s);
      System.out.println("Cifrada: " + cifrada);

        sc.close();
    } // end main( )
} // end class( )