class Celula {
    int elemento;
    Celula prox;

    public Celula() {
        this.elemento = 0;
        this.prox = null;
    }

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class No {
    int elemento;
    No esq, dir;

    public No() {
        this.elemento = 0;
        this.esq = this.dir = null;
    }

    public No(int x) {
        this.elemento = x;
        this.esq = this.dir = null;
    }
}

class NoAVL {
    int elemento;
    NoAVL esq, dir;
    int altura;

    public NoAVL() {
        this.elemento = 0;
        this.esq = this.dir = null;
        this.altura = 1;
    }

    public NoAVL(int x) {
        this.elemento = x;
        this.esq = this.dir = null;
        this.altura = 1;
    }
}

class RehashAB {
    int tamHash;
    int[] tabela;
    No arvoreReserva;

    public RehashAB() {
        this.tamHash = 7;
        this.tabela = new int[tamHash];
        for (int i = 0; i < tamHash; i++) {
            this.tabela[i] = -1; // posição vazia
        }
        this.arvoreReserva = null;
    }

    public RehashAB(int x) {
        this.tamHash = x;
        this.tabela = new int[tamHash];
        for (int i = 0; i < tamHash; i++) {
            this.tabela[i] = -1; // posição vazia
        }
        this.arvoreReserva = null;
    }

    /*
     * MÉTODO HASH E REHASH
     */
    int hash(int x) {
        return x % tamHash;
    }

    int rehash(int x) {
        return (x + 1) % tamHash;
    }

    /*
     * MÉTODOS DA HASH COM REHASH E ÁRVORE BINÁRIA DE PESQUISA
     */
    void inserir(int x) {
        int i = hash(x);
        if (tabela[i] == -1) {
            tabela[i] = x;
        } else {
            // Procura uma posição usando rehash
            i = rehash(i);
            if (tabela[i] == -1) {
                tabela[i] = x;
            } else {
                // Inserir na árvore binária de reserva
                arvoreReserva = inserirNaArvore(arvoreReserva, x);
            }
        }
    }

    // Método auxiliar para inserir na árvore binária de pesquisa
    private No inserirNaArvore(No raiz, int x) {
        if (raiz == null) {
            return new No(x);
        } else if (x < raiz.elemento) {
            raiz.esq = inserirNaArvore(raiz.esq, x);
        } else if (x > raiz.elemento) {
            raiz.dir = inserirNaArvore(raiz.dir, x);
        }
        return raiz;
    }

    // Método para imprimir a tabela hash e a árvore binária
    void imprimir() {
        System.out.println("Tabela Hash com Rehash:");
        for (int i = 0; i < tamHash; i++) {
            System.out.print(tabela[i] + " ");
        }
        System.out.println();
        System.out.println("Árvore Binária de Reserva:");
        imprimirArvore(arvoreReserva);
        System.out.println();
    }

    private void imprimirArvore(No raiz) {
        if (raiz != null) {
            imprimirArvore(raiz.esq);
            System.out.print(raiz.elemento + " ");
            imprimirArvore(raiz.dir);
        }
    }
}

class HashDoida {
    int tamHash;
    int[] tabela;
    RehashAB reserva01; // Tabela hash com rehash e árvore binária de reserva
    Celula reserva02; // Lista simplesmente encadeada
    NoAVL reserva03; // Árvore AVL

    public HashDoida() {
        this.tamHash = 7;
        this.tabela = new int[tamHash];
        for (int i = 0; i < tamHash; i++) {
            tabela[i] = -1;
        }
        this.reserva01 = new RehashAB();
        this.reserva02 = null; // Inicialmente, a lista está vazia
        this.reserva03 = null; // Inicialmente, a AVL está vazia
    }

    public HashDoida(int t1, int t3) {
        this.tamHash = t1;
        this.tabela = new int[tamHash];
        for (int i = 0; i < tamHash; i++) {
            tabela[i] = -1;
        }
        this.reserva01 = new RehashAB(t3);
        this.reserva02 = null; // Inicialmente, a lista está vazia
        this.reserva03 = null; // Inicialmente, a AVL está vazia
    }

    // MÉTODO HASH
    int hash(int x) {
        return x % tamHash;
    }

    /*
     * MÉTODOS DA HASH DOIDA
     */

    // Inserir na doida
    public void inserir(int x) {
        int i = hash(x);
        if (tabela[i] == -1) {
            tabela[i] = x;
        } else {
            if (i % 3 == 0) { // Insere na rehash com AB
                reserva01.inserir(x);
            } else if (i % 3 == 1) { // Insere na lista encadeada
                if (reserva02 == null) {
                    reserva02 = new Celula(x);
                } else {
                    Celula atual = reserva02;
                    while (atual.prox != null) {
                        atual = atual.prox;
                    }
                    atual.prox = new Celula(x);
                }
            } else { // Insere na AVL
                reserva03 = inserirAVL(reserva03, x);
            }
        }
    }

    // Método auxiliar para inserir na árvore AVL
    private NoAVL inserirAVL(NoAVL raiz, int x) {
        if (raiz == null) {
            return new NoAVL(x);
        }
        if (x < raiz.elemento) {
            raiz.esq = inserirAVL(raiz.esq, x);
        } else if (x > raiz.elemento) {
            raiz.dir = inserirAVL(raiz.dir, x);
        }
        // Atualiza a altura
        raiz.altura = 1 + Math.max(altura(raiz.esq), altura(raiz.dir));
        // Balanceamento e rotações
        int balance = balanceamento(raiz);
        if (balance > 1 && x < raiz.esq.elemento) {
            return rotacaoDireita(raiz);
        }
        if (balance < -1 && x > raiz.dir.elemento) {
            return rotacaoEsquerda(raiz);
        }
        if (balance > 1 && x > raiz.esq.elemento) {
            raiz.esq = rotacaoEsquerda(raiz.esq);
            return rotacaoDireita(raiz);
        }
        if (balance < -1 && x < raiz.dir.elemento) {
            raiz.dir = rotacaoDireita(raiz.dir);
            return rotacaoEsquerda(raiz);
        }
        return raiz;
    }

    // Métodos auxiliares para balanceamento e rotação da árvore AVL
    private int altura(NoAVL no) {
        return no == null ? 0 : no.altura;
    }

    private int balanceamento(NoAVL no) {
        return no == null ? 0 : altura(no.esq) - altura(no.dir);
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esq;
        NoAVL T2 = x.dir;
        x.dir = y;
        y.esq = T2;
        y.altura = Math.max(altura(y.esq), altura(y.dir)) + 1;
        x.altura = Math.max(altura(x.esq), altura(x.dir)) + 1;
        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.dir;
        NoAVL T2 = y.esq;
        y.esq = x;
        x.dir = T2;
        x.altura = Math.max(altura(x.esq), altura(x.dir)) + 1;
        y.altura = Math.max(altura(y.esq), altura(y.dir)) + 1;
        return y;
    }

    // Método para imprimir o conteúdo da tabela hash e das reservas
    public void imprimir() {
        System.out.println("Tabela Hash Principal:");
        for (int i = 0; i < tamHash; i++) {
            System.out.print(tabela[i] + " ");
        }
        System.out.println();
        System.out.println("Reserva 01 (Tabela Hash com Rehash e Árvore Binária):");
        reserva01.imprimir();
        System.out.println("Reserva 02 (Lista Encadeada):");
        imprimirLista(reserva02);
        System.out.println();
        System.out.println("Reserva 03 (Árvore AVL):");
        imprimirAVL(reserva03);
        System.out.println();
    }

    private void imprimirLista(Celula head) {
        Celula atual = head;
        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.prox;
        }
    }

    private void imprimirAVL(NoAVL raiz) {
        if (raiz != null) {
            imprimirAVL(raiz.esq);
            System.out.print(raiz.elemento + " ");
            imprimirAVL(raiz.dir);
        }
    }
}

// Classe Principal para Testar a Implementação
public class doidinha {
    public static void main(String[] args) {
        HashDoida hd = new HashDoida();

        hd.inserir(3);
        hd.inserir(8);
        hd.inserir(10);
        hd.inserir(21);
        hd.inserir(14);
        hd.inserir(18);
        hd.inserir(25);
        hd.inserir(17);
        hd.inserir(32);
        hd.inserir(23);
        hd.inserir(16);
        hd.inserir(29);
        hd.inserir(27);
        hd.inserir(1);
        hd.inserir(40);
        hd.inserir(102);
        hd.inserir(2);
        hd.inserir(24);
        hd.inserir(9);
        hd.inserir(15);
        hd.inserir(242);
        hd.inserir(90);
        hd.inserir(123);
        hd.inserir(30);

        hd.imprimir();
    }
}
