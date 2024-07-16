import java.util.Scanner;
import java.util.Locale;

public class Main
{
    public static boolean palindromo(String s, int start, int end)
    {
        if(start >= end)
        {
            return true;
        } // end if

        if(s.charAt(start) != s.charAt(end))
        {
            return false;
        } // end if 

        return palindromo(s, start + 1, end - 1);
    } // end palindromo( )

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // definir dados
        String s;
        System.out.print("Digite uma string: ");
        s = sc.nextLine();

        // funcoes auxiliares
        if(palindromo(s, 0, s.length() - 1))
        {
            System.out.println("1");
        }
        else
        {
            System.out.println("0");
        } // end if
        sc.close();
    } // end main( )
} // end class( )