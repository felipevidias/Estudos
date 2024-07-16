import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        int N, neg;
        System.out.print("Digite o tamanho da matriz quadratica: ");
        N = sc.nextInt();
        neg = 0;
        

        int mat[][] = new int[N][N];

        
        for(int i = 0; i < N; i = i + 1)
        {
            for(int j = 0; j < N; j = j + 1 )
            {
                System.out.print("[" + i + ":" + j + "]: ");
                mat[i][j] = sc.nextInt();
            } // end for 
        } // end for 

        System.out.println("MATRIZ: ");
       for(int i = 0; i < N; i = i + 1)
        {
            for(int j = 0; j < N; j = j + 1 )
            {
                System.out.print(mat[i][j] + "\t");
            } // end for 
            System.out.println();
        } // end for 

    System.out.print("DIAGONAL PRINCIPAL: ");
    for(int i = 0; i < N; i = i + 1)
    {
        for(int j = 0; j < N; j = j + 1)
        {
            if(i == j)
            {
                System.out.print(mat[i][j] + " ");
                if(mat[i][j] < 0)
                {
                    neg = neg + 1;
                } // end if
            } // end if 
        } // end for 
    } // end for 

    System.out.println();
    System.out.println("QUANTIDADES DE NEGATIVOS NA DIAGONAL: " + neg);



        sc.close();

    }
}