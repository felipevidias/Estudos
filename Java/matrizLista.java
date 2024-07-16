import java.util.Scanner;

/*
 * COISAS DA LISTA ENCADEADA
 */
class Celula {
    int elemento;
    Celula prox;

    public Celula() {
        this(0);
    }

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Lista {
    Celula primeiro, ultimo;

    public Lista() {
        this.primeiro = new Celula();
        this.ultimo = this.primeiro;
    }

    /*
     * METODOS DA LISTA
     */
    public void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int removerFim() throws Exception {
        if (primeiro == ultimo)
            throw new Exception("Erro!");
        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox);
        int elemento = ultimo.elemento;
        ultimo = i;
        ultimo.prox = null;
        return elemento;
    }

    public boolean buscar(int x) {
        for (Celula i = primeiro; i != null; i = i.prox) {
            if (i.elemento == x) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
    }
}

/*
 * COISAS DA MATRIZ ENCADEADA
 */
class CelulaMat {
    Lista lista;
    CelulaMat esq, dir, inf, sup;

    // CONSTRUTORES
    public CelulaMat() {
        this.lista = new Lista();
        this.esq = this.dir = this.inf = this.sup = null;
    }

    public CelulaMat(Lista x) {
        this.lista = x;
        this.esq = this.dir = this.inf = this.sup = null;
    }
}

class Matriz {
    CelulaMat inicio;
    int linha, coluna;

    // CONSTRUTORES
    public Matriz() {
        this(3, 3);
    }

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.inicio = new CelulaMat();
        CelulaMat linhaAtual = inicio;

        // Criar primeira linha
        for (int j = 1; j < coluna; j++) {
            linhaAtual.dir = new CelulaMat();
            linhaAtual.dir.esq = linhaAtual;
            linhaAtual = linhaAtual.dir;
        }

        // Criar demais linhas
        CelulaMat linhaAnterior = inicio;
        for (int i = 1; i < linha; i++) {
            linhaAtual = linhaAnterior;
            linhaAtual.inf = new CelulaMat();
            linhaAtual.inf.sup = linhaAtual;
            linhaAtual = linhaAtual.inf;

            CelulaMat celulaAnterior = linhaAtual;
            CelulaMat celulaSuperior = linhaAnterior.dir;
            for (int j = 1; j < coluna; j++) {
                celulaAnterior.dir = new CelulaMat();
                celulaAnterior.dir.esq = celulaAnterior;
                celulaAnterior.dir.sup = celulaSuperior;
                celulaSuperior.inf = celulaAnterior.dir;

                celulaAnterior = celulaAnterior.dir;
                celulaSuperior = celulaSuperior.dir;
            }
            linhaAnterior = linhaAnterior.inf;
        }
    }

    /*
     * METODOS
     */
    public void inserir(int x, int i, int j) {
        CelulaMat aux = inicio;
        for (int k = 0; k < i; k++) {
            aux = aux.inf;
        }
        for (int l = 0; l < j; l++) {
            aux = aux.dir;
        }
        aux.lista.inserirFim(x);
    }

    public boolean buscar(int x, int i, int j) {
        CelulaMat aux = inicio;
        for (int k = 0; k < i; k++) {
            aux = aux.inf;
        }
        for (int l = 0; l < j; l++) {
            aux = aux.dir;
        }
        return aux.lista.buscar(x);
    }

    public void mostrar() {
        CelulaMat aux = inicio;
        for (int i = 0; i < linha; i++) {
            CelulaMat temp = aux;
            for (int j = 0; j < coluna; j++) {
                System.out.print("(");
                temp.lista.print();
                System.out.print(") ");
                temp = temp.dir;
            }
            System.out.println();
            aux = aux.inf;
        }
    }
}

public class matrizLista {
    public static void main(String[] args) {
        Matriz matriz = new Matriz(3, 3);
        Scanner scanner = new Scanner(System.in);

        // Inserir elementos na matriz
        matriz.inserir(1, 0, 0);
        matriz.inserir(2, 0, 1);
        matriz.inserir(3, 0, 2);
        matriz.inserir(4, 1, 0);
        matriz.inserir(5, 1, 1);
        matriz.inserir(6, 1, 2);
        matriz.inserir(7, 2, 0);
        matriz.inserir(8, 2, 1);
        matriz.inserir(9, 2, 2);
        matriz.inserir(2, 0, 0);
        matriz.inserir(3, 0, 1);
        matriz.inserir(4, 0, 2);
        matriz.inserir(5, 1, 0);
        matriz.inserir(6, 1, 1);
        matriz.inserir(7, 1, 2);
        matriz.inserir(8, 2, 0);
        matriz.inserir(9, 2, 1);
        matriz.inserir(10, 2, 2);
        matriz.inserir(3, 0, 0);
        matriz.inserir(4, 0, 1);
        matriz.inserir(5, 0, 2);
        matriz.inserir(6, 1, 0);
        matriz.inserir(7, 1, 1);
        matriz.inserir(8, 1, 2);
        matriz.inserir(9, 2, 0);
        matriz.inserir(10, 2, 1);
        matriz.inserir(11, 2, 2);

        // Mostrar a matriz
        System.out.println("Matriz após inserções:");
        matriz.mostrar();

        // Buscar elementos na matriz
        System.out.println("Buscar por 5 na posição (1,1): " + matriz.buscar(5, 1, 1));
        System.out.println("Buscar por 10 na posição (2,2): " + matriz.buscar(10, 2, 2));

        scanner.close();
    }
}
