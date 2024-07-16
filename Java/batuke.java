import java.util.Scanner;

class batuke{
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int linha = sc.nextInt();
    int coluna = sc.nextInt();
    inicializar(n, linha, coluna);


    sc.close();
   }
   public static void inicializar(int n, int linha, int coluna){
    int[][] arr = new int[n][n];
    int elemento = 1;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            arr[i][j] = elemento;
            elemento++;
        }
    }

    walkAndPrint(n, arr, linha, coluna);
   }

   public static void walkAndPrint(int n, int arr[][], int linha, int coluna){
        int qtdeCaminhar = 0;
        int control = 0;
        int qtdeControle = 1;
        int qtdeReal = 0;
        System.out.print(arr[linha][coluna]+" ");
        while (qtdeControle < n*n) {
            if(control%2 == 0) qtdeCaminhar++; // aumentar a quantidade que vai caminhar 
            for(int i = 0; i<qtdeCaminhar; i++){
                if(control == 0)
                    coluna++;
                else if(control == 1)
                    linha++;
                else if(control == 2)
                    coluna--;
                else
                    linha--;
                
                if(coluna < n && linha < n && coluna >= 0 && linha >= 0){
                    qtdeControle++;
                    System.out.print(arr[linha][coluna]+" ");
                } else  if(qtdeControle == n*n){
                    i = qtdeCaminhar;
                    System.out.print("\b");
                }
                qtdeReal += 1;
            }
            
            control = (control+1)%4;
        }
        System.out.print("\n"+qtdeReal);
   }
   
}
