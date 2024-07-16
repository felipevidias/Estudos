import java.util.Scanner;

class CelulaMatriz {
    int elemento;
    CelulaMatriz esq, dir, sup, inf;

    public CelulaMatriz() {
        this(0);
    }

    public CelulaMatriz(int x) {
        this.elemento = x;
        this.esq = this.dir = this.sup = this.inf = null;
    }
}

class Matriz {
    public CelulaMatriz inicio;
    public int linha, coluna;

    public Matriz() {
        this(3, 3);
    }

    public Matriz(int l, int c) {
        this.linha = l;
        this.coluna = c;
        this.inicio = new CelulaMatriz();
    }

    public void inserir() {
        Scanner sc = new Scanner(System.in);
        CelulaMatriz tmp = inicio;

        for (int i = 0; i < linha; i++) {
            CelulaMatriz linhaTmp = tmp;
            for (int j = 0; j < coluna; j++) {
                int x;
                while (true) {
                    try {
                        System.out.print("Insira o valor para a posição [" + i + "][" + j + "]: ");
                        x = sc.nextInt();
                        break;
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Entrada inválida. Insira um número inteiro.");
                        sc.next(); 
                    }
                }
                tmp.elemento = x;

               
                if (j < coluna - 1) {
                    if (tmp.dir == null) {
                        tmp.dir = new CelulaMatriz();
                        tmp.dir.esq = tmp;
                        tmp = tmp.dir;
                    }
                } 
                if(tmp.sup != null && tmp.sup.dir != null && tmp.dir != null){
                    tmp.dir.sup = tmp.sup.dir;
                    tmp.sup.inf = tmp.dir;
                
                }
            }
           

            if (i < linha - 1) {
                if (linhaTmp.inf == null) {
                    linhaTmp.inf = new CelulaMatriz();
                    linhaTmp.inf.sup = linhaTmp;
                    tmp = linhaTmp.inf;
                }
            }
        }
        sc.close();
    }

    public void mostrar() {
        CelulaMatriz tmp = inicio;
        for (int i = 0; i < linha; i++) {
            CelulaMatriz atual = tmp;
            for (int j = 0; j < coluna; j++) {
                System.out.print(atual.elemento + " ");
                atual = atual.inf;
            }
            System.out.println();
            tmp = tmp.dir;
        }
    }

    public void getDiagonal() {
        CelulaMatriz tmp = inicio;
        tmp = tmp.dir.inf;
        System.out.println(tmp.elemento);
        /* 
        while(tmp != null){
            System.out.println(tmp.elemento + " ");
            tmp = tmp.dir;
            tmp = tmp.inf;
        }  
        */  
    }
    

    public void getDiagonalSec(){

    }
}

public class matrizFlex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a quantidade de linhas da matriz: ");
        int linhas = sc.nextInt();
        System.out.print("Digite a quantidade de colunas da matriz: ");
        int colunas = sc.nextInt();

        Matriz matriz = new Matriz(linhas, colunas);

        matriz.inserir();

        System.out.println("MATRIZ ENCADEADA: ");
        matriz.mostrar();

        System.out.println("DIAGONAL PRINCIPAL: ");
        matriz.getDiagonal();
        sc.close();
    }
}
