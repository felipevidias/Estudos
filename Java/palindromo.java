import java.util.Scanner;
import java.util.Locale;

public class Main
{
    boolean palindromo(String s)
    {
        for(int i = 0; i < s.length() / 2; i = i + 1) // iteração pelos pares 
        {
            int j = s.length() - 1 - i; // para cada indice i é calculado o indice correspondente na segunda metade
            if(s.charAt(i) != s.charAt(j))
            {
                return false; // não é um palindromo 
            } // end if 
        } // end for 
        return true; // é palindromo 
    } // end palindromo( )


    public static void main(String[] args)
    {
         Locale.setDefault(Locale.US);
         Scanner sc = new Scanner(System.in);
        
        // definir dados 
        String s; boolean result; 
        System.out.print("Digite uma string: ");
        s = sc.nextLine();

        // aplicar funções auxiliares
        Main mainObj = new Main(); // criar uma instância do objeto para chamar o método não estático
        result = mainObj.palindromo(s);

        if(result == true)
        {
            System.out.println("SIM");
        }
        else
        {
            System.out.println("NAO");
        } // end if 
         
         sc.close();
    } // end main( )
}