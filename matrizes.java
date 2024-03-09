import java.util.Scanner;
import java.util.Locale;

public class Main
{
    public static void main (String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int line; int col;

        System.out.print("Quantas linhas? ");
        line = sc.nextInt();
        System.out.print("Quantas colunas? ");
        col = sc.nextInt();

        int[][] mat = new int[line][col]; // definindo uma matriz 

        for(int i = 0; i < line; i = i + 1)
        {
            for(int j = 0; j < col; j = j + 1)
            {
                System.out.print("Digite um numero: ");
                mat[i][j] = sc.nextInt();
            }
        } 

        System.out.println("MATRIZ: ");

        for(int i = 0; i < line; i = i + 1)
        {
            for ( int j = 0; j < col; j = j + 1)
            {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}