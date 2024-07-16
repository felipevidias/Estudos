import java.util.Scanner;

/*
 * -------------------------------------------TADS------------------------------------------------------------------
 */
/*
 * ESTRUTURAS COM CELULAS SIMPLES
 */
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

/*
 * LISTA COM CELULA SIMPLES
 */
class ListaSimples {
    Celula primeiro, ultimo;

    public ListaSimples() {
        this.primeiro = new Celula();
        this.ultimo = primeiro;
    }

    /*
     * METODOS DA LISTA SIMPLES
     */
    void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    int removerFim() {
        int resp = ultimo.elemento;
        Celula i;
        for (i = primeiro; i != ultimo; i = i.prox)
            ;
        ultimo = i;
        i.prox = null;
        ultimo.prox = null;
        return resp;
    }

    void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        tmp = null;

    }

    int removerInicio() {
        int resp = primeiro.elemento;
        primeiro = primeiro.prox;
        return resp;
    }

    /*
     * FUNÇÃO PRA PEGAR O TAMANHO
     */
    int getTamanho() {
        int tamanho = 0;
        for (Celula i = primeiro; i != null; i = i.prox) {
            tamanho++;
        }
        return tamanho;
    }

    void inserir(int x, int pos) {
        int tamanho = getTamanho();

        if (pos == tamanho - 1) {
            inserirFim(x);
        } else if (pos == 0) {
            inserirInicio(x);
        }

        Celula i = primeiro;
        for (int j = 0; j < pos; j++, i = i.prox)
            ;
        Celula tmp = new Celula(x);
        tmp.prox = i.prox;
        i.prox = tmp;
        tmp = i = null;
    }

    int remover(int pos) {
        int resp = 0;
        int tamanho = getTamanho();
        if (pos == tamanho - 1) {
            resp = removerFim();
        } else if (pos == 0) {
            removerInicio();
        }
        Celula i = primeiro;
        for (int j = 0; j < pos; j++, i = i.prox)
            ;
        Celula tmp = i.prox;
        resp = tmp.elemento;
        i.prox = tmp.prox;
        tmp.prox = null;
        tmp = i = null;
        return resp;
    }
}

/*
 * ESTRUTURAS COM CELULAS DUPLAS
 */
class CelulaDupla {
    int elemento;
    CelulaDupla ant, prox;

    public CelulaDupla() {
        this.elemento = 0;
        this.ant = this.prox = null;
    }

    public CelulaDupla(int x) {
        this.elemento = x;
        this.ant = this.prox = null;
    }
}

class ListaDupla {
    CelulaDupla primeiro, ultimo;

    public ListaDupla() {
        this.primeiro = new CelulaDupla();
        this.ultimo = primeiro;
    }

    /*
     * METODOS DA LISTA DUPLA
     */
    void inserirFim(int x) {
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }

    int removerFim() {
        int resp = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        return resp;
    }

    void inserirInicio(int x) {
        CelulaDupla tmp = new CelulaDupla(x);
        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox.ant = tmp;

        tmp = null;
    }

    int removerInicio() {
        int resp = primeiro.elemento;
        primeiro = primeiro.prox;
        primeiro.ant = null;

        return resp;
    }

    /*
     * FUNÇÃO PRA PEGAR O TAMANHO
     */
    int getTamanho() {
        int tamanho = 0;
        for (CelulaDupla i = primeiro; i != null; i = i.prox) {
            tamanho++;
        }
        return tamanho;
    }

    void inserir(int x, int pos) {
        int tamanho = getTamanho();

        if (pos == tamanho - 1) {
            inserirFim(x);
        } else if (pos == 0) {
            inserirInicio(x);
        } else {
            CelulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            CelulaDupla tmp = new CelulaDupla(x);
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.prox.ant = tmp.ant.prox = tmp;
            tmp = i = null;
        }
    }

    int remover(int pos) {
        int tamanho = getTamanho();
        int resp = 0;
        if (pos == tamanho - 1) {
            resp = removerFim();
        } else if (pos == 0) {
            resp = removerInicio();
        } else {
            CelulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            resp = i.prox.elemento;
            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            i.prox = i.ant = i = null;
        }

        return resp;
    }
}

/*
 * ----------------------------------------------------ARVORE AVL E
 * ABB---------------------------------------------------------------
 */
/*
 * NO ABB
 */
class NoAB {
    int elemento;
    NoAB esq, dir;

    public NoAB() {
        this.elemento = 0;
        this.esq = this.dir = null;
    }

    public NoAB(int x) {
        this.elemento = x;
        this.esq = this.dir = null;
    }
}

class ABB {
    NoAB raiz;

    public ABB() {
        this.raiz = null;
    }

    /*
     * METODOS DA ABB
     */
    public void inserir(int x) {
        raiz = inserir(x, raiz);
    }

    private NoAB inserir(int x, NoAB i) {
        if (i == null) {
            i = new NoAB(x);
        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        } else {
            System.out.println("ERRO AO INSERIR");
        }

        return i;
    }

    public boolean pesquisar(int x) {
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(int x, NoAB i) {
        boolean resp = false;
        if (i == null) {
            resp = false;
        } else if (i.elemento == x) {
            resp = true;
        } else if (x < i.elemento) {
            resp = pesquisar(x, i.esq);
        } else if (x > i.elemento) {
            resp = pesquisar(x, i.dir);
        }

        return resp;
    }

    /*
     * CAMINHAMENTOS
     */
    public void caminharCentral() {
        caminharCentral(raiz);
    }

    private void caminharCentral(NoAB i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.println(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }

    public void caminharPre() {
        caminharPre(raiz);
    }

    private void caminharPre(NoAB i) {
        if (i != null) {
            System.out.println(i.elemento + " ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    public void caminharPos() {
        caminharPos(raiz);
    }

    private void caminharPos(NoAB i) {
        if (i != null) {
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.println(i.elemento + " ");
        }
    }
}

/*
 * NO AVL
 */
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

class AVL {
    NoAVL raiz;

    public AVL() {
        this.raiz = null;
    }

    /*
     * METODOS DE BALANCEAMENTO DA AVL
     */
    int getAltura(NoAVL no) {
        return no == null ? 0 : no.altura;
    }

    int getFator(NoAVL no) {
        return no == null ? 0 : getAltura(no.dir) - getAltura(no.esq);
    }

    NoAVL rotEsq(NoAVL no) {
        NoAVL noDir = no.dir;
        NoAVL noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        // Atualizar alturas
        no.altura = Math.max(getAltura(no.esq), getAltura(no.dir)) + 1;
        noDir.altura = Math.max(getAltura(noDir.esq), getAltura(noDir.dir)) + 1;

        return noDir;
    }

    NoAVL rotDir(NoAVL no) {
        NoAVL noEsq = no.esq;
        NoAVL noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        // Atualizar alturas
        no.altura = Math.max(getAltura(no.esq), getAltura(no.dir)) + 1;
        noEsq.altura = Math.max(getAltura(noEsq.esq), getAltura(noEsq.dir)) + 1;

        return noEsq;
    }

    NoAVL rotDirEsq(NoAVL no) {
        no.dir = rotDir(no.dir);
        return rotEsq(no);
    }

    NoAVL rotEsqDir(NoAVL no) {
        no.esq = rotEsq(no.esq);
        return rotDir(no);
    }

    /*
     * BALANCEAR A ARVORE
     */
    NoAVL balancear(NoAVL no) {
        int fator = getFator(no);
        if (fator > 1) {
            // Right heavy
            if (getFator(no.dir) < 0) {
                no.dir = rotDir(no.dir);
            }
            no = rotEsq(no);
        } else if (fator < -1) {
            // Left heavy
            if (getFator(no.esq) > 0) {
                no.esq = rotEsq(no.esq);
            }
            no = rotDir(no);
        }
        // Atualizar a altura do nó após o balanceamento
        no.altura = Math.max(getAltura(no.esq), getAltura(no.dir)) + 1;
        return no;
    }

    /*
     * METODOS DA AVL
     */
    public void inserir(int x) {
        raiz = inserir(x, raiz);
    }

    private NoAVL inserir(int x, NoAVL i) {
        if (i == null) {
            i = new NoAVL(x);
        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        }

        // Atualizar a altura deste nó
        i.altura = Math.max(getAltura(i.esq), getAltura(i.dir)) + 1;

        // Balancear o nó
        return balancear(i);
    }

    int getNivel(NoAVL i) {
        if (i == null) {
            return 0;
        }
        return Math.max(getNivel(i.esq), getNivel(i.dir)) + 1;
    }
}

/*
 * -------------------------------------------ARVORE
 * TRIE-----------------------------------------------------------
 */

/*
 * NO DA TRIE COM HASH
 */
class NoHash {
    char elemento;
    final int tamanho = 255;
    NoHash[] prox;
    boolean folha;

    public NoHash() {
        this.elemento = '\0';
        this.prox = new NoHash[tamanho];
        for (int i = 0; i < prox.length; i++) {
            this.prox[i].folha = false;
        }
    }

    public NoHash(char elemento) {
        this.elemento = elemento;
        this.prox = new NoHash[tamanho];
        for (int i = 0; i < prox.length; i++) {
            this.prox[i].folha = false;
        }
    }
}

class TrieHash {
    NoHash raiz;

    public TrieHash() {
        this.raiz = null;
    }

    /*
     * METODOS DA TRIE
     */
    public boolean pesquisar(String s) {
        return pesquisar(s, raiz, 0);
    }

    private boolean pesquisar(String s, NoHash no, int i) {
        boolean resp = false;

        if (no.prox[s.charAt(i)] == null) {
            resp = false;
        } else if (i == s.length() - 1) {
            resp = no.prox[s.charAt(i)].folha == true;
        } else if (i < s.length() - 1) {
            resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
        }

        return resp;
    }

    public void inserir(String s) {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, NoHash no, int i) {
        if (no.prox[s.charAt(i)] == null) {
            no.prox[s.charAt(i)] = new NoHash(s.charAt(i));

            if (i == s.length() - 1) {
                no.prox[s.charAt(i)].folha = true;
            } else if (i < s.length() - 1) {
                inserir(s, no.prox[s.charAt(i)], i + 1);
            }
        } else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1) {
            inserir(s, no.prox[s.charAt(i)], i + 1);
        }
    }

    public void mostrar() {
        mostrar("", raiz);
    }

    private void mostrar(String s, NoHash no) {
        if (no.folha == true) {
            System.out.println("Palavra: " + s + no.elemento);
        } else {
            for (int i = 0; i < no.prox.length; i++) {
                mostrar(s + no.elemento, no.prox[i]);
            }
        }
    }
}

/*
 * TRIE COM LISTA SIMPLES
 */
class CelulaTrie {
    char elemento;
    CelulaTrie prox;
    NoLista no;

    public CelulaTrie() {
        this.elemento = '\0';
        this.prox = null;
        this.no = null;
    }

    public CelulaTrie(char x) {
        this.elemento = x;
        this.prox = null;
        this.no = new NoLista(x);
    }
}

class NoLista {
    char elemento;
    CelulaTrie primeiro, ultimo;
    boolean folha;

    public NoLista() {
        this.elemento = '\0';
        this.primeiro = new CelulaTrie();
        this.primeiro = this.ultimo;
    }

    public NoLista(char x) {
        this.elemento = x;
        this.primeiro = new CelulaTrie();
        this.primeiro = this.ultimo;
    }

    /*
     * METODOS DA LISTA ENCADEADA
     */
    NoLista inserir(char x) {
        ultimo.prox = new CelulaTrie(x);
        ultimo = ultimo.prox;

        return ultimo.no;
    }

    NoLista pesquisar(char x) {
        NoLista resp = null;
        for (CelulaTrie i = primeiro; i != null; i = i.prox) {
            if (i.elemento == x) {
                resp = i.no;
                i = ultimo;
            }
        }
        return resp;
    }

    void setFilhoFolha(char x) {
        for (CelulaTrie i = primeiro; i != null; i = i.prox) {
            if (i.elemento == x) {
                i.no.folha = true;
                i = ultimo;
            }
        }
    }

    NoLista[] getFilho() {
        int n = 0;
        for (CelulaTrie i = primeiro; i != null; i = i.prox, n++)
            ;
        NoLista[] filhos = new NoLista[n];
        n = 0;
        for (CelulaTrie i = primeiro; i != null; i = i.prox) {
            filhos[n++] = i.no;
        }

        return filhos;
    }
}

class TrieLista {
    NoLista raiz;

    public TrieLista() {
        this.raiz = null;
    }

    /*
     * METODOS DA ARVORE TRIE
     */
    public void inserir(String s) {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, NoLista no, int i) {
        NoLista filho = no.pesquisar(s.charAt(i));
        if (filho == null) {
            filho = no.inserir(s.charAt(i));

            if (i == s.length() - 1) {
                no.setFilhoFolha(s.charAt(i));
            } else if (i < s.length() - 1) {
                inserir(s, filho, i + 1);
            }
        } else if (filho.folha == false && i < s.length() - 1) {
            inserir(s, filho, i + 1);
        }
    }

    public boolean pesquisar(String s) {
        return pesquisar(s, raiz, 0);
    }

    private boolean pesquisar(String s, NoLista no, int i) {
        NoLista filho = no.pesquisar(s.charAt(i));
        boolean resp = false;
        if (filho == null) {
            resp = false;
        } else if (i == s.length() - 1) {
            resp = filho.folha == true;
        } else if (i < s.length() - 1) {
            inserir(s, filho, i + 1);
        }

        return resp;
    }

    public void mostrar() {
        mostrar("", raiz);
    }

    private void mostrar(String s, NoLista no) {
        if (no.folha == true) {
            System.out.println(s + no.elemento);
        } else {
            NoLista[] filho = getFilho();
            for (int i = 0; i < filho.length; i++) {
                mostrar(s + no.elemento, filho[i]);
            }
        }
    }
}

/*
 * ---------------------------------------------------------HASH
 * TABLE-------------------------------------------------------
 */

class HashTable {
    int tamanho;
    int table[];
    int reserva[];
    int tamanhoReserva;

    public HashTable() {
        this.tamanho = 7;
        this.table = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            table[i] = -1;
        }
    }

    public HashTable(int x) {
        this.tamanho = x;
        this.table = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            table[i] = -1;
        }
    }

    /*
     * metodo hash
     */
    int hash(int x) {
        return x % tamanho;
    }

    /*
     * metodo rehash
     */

    int rehash(int x) {
        return ++x % tamanho;
    }

    /*
     * METODOS DA HASH
     */
    public void inserir(int elemento) {
        int i = hash(elemento);

        if (table[i] == -1) {
            table[i] = elemento;
        } else {
            i = rehash(i);
            if (table[i] == -1) {
                table[i] = elemento;
            }
        }
    }

    public boolean pesquisar(int x) {
        int i = hash(x);
        boolean resp = false;
        ;
        if (table[i] == x) {
            resp = true;
        } else {
            i = rehash(x);
            if (table[i] == x) {
                resp = true;
            }
        }

        return resp;
    }
}

class HashReserva {
    int tamanho;
    int table[];
    int tamanhoReserva;

    public HashReserva() {
        this.tamanho = 7 + tamanhoReserva;
        this.tamanhoReserva = 3;
        this.table = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            table[i] = -1;
        }
    }

    public HashReserva(int x) {
        this.tamanho = x + tamanhoReserva;
        this.tamanhoReserva = 3;
        this.table = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            table[i] = -1;
        }
    }

    int hash(int x) {
        return x % tamanho;
    }

    void inserir(int x) {
        int i = hash(x);
        if (table[i] == -1) {
            table[i] = x;
        } else {
            int numReserva = 0;
            if (numReserva < tamanhoReserva) {
                table[numReserva + tamanho] = x;
                numReserva++;
            }
        }
    }
}

class HashLista {
    int tamanho;
    ListaSimples[] tabela;

    public HashLista(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new ListaSimples[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaSimples();
        }
    }

    int hash(int x) {
        return x % tamanho;
    }

    void inserir(int x) {
        int i = hash(x);

        if (tabela[i] == null) {
            tabela[i].inserirFim(x);
        }
    }

}

/*
 * =============================================================================
 * =========================================================
 */

class REVISAOZONA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1 - Lista Simples");
            System.out.println("2 - Lista Dupla");
            System.out.println("3 - Arvore Binaria de Pesquisa");
            System.out.println("4 - AVL");
            System.out.println("5 - Arvore Trie");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a nova linha

            switch (opcao) {
                case 1:
                    menuListaSimples(scanner);
                    break;
                case 2:
                    menuListaDupla(scanner);
                    break;
                case 3:
                    menuABB(scanner);
                    break;
                case 4:
                    menuAVL(scanner);
                    break;
                case 5:
                    menuTrie(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    private static void menuListaSimples(Scanner scanner) {
        ListaSimples lista = new ListaSimples();
        while (true) {
            System.out.println("Menu Lista Simples:");
            System.out.println("1 - Inserir no Início");
            System.out.println("2 - Inserir no Fim");
            System.out.println("3 - Inserir em uma Posição");
            System.out.println("4 - Remover do Início");
            System.out.println("5 - Remover do Fim");
            System.out.println("6 - Remover de uma Posição");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valInicio = scanner.nextInt();
                    lista.inserirInicio(valInicio);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valFim = scanner.nextInt();
                    lista.inserirFim(valFim);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valPos = scanner.nextInt();
                    System.out.print("Digite a posição: ");
                    int pos = scanner.nextInt();
                    lista.inserir(valPos, pos);
                    break;
                case 4:
                    int removidoInicio = lista.removerInicio();
                    System.out.println("Valor removido do início: " + removidoInicio);
                    break;
                case 5:
                    int removidoFim = lista.removerFim();
                    System.out.println("Valor removido do fim: " + removidoFim);
                    break;
                case 6:
                    System.out.print("Digite a posição a ser removida: ");
                    int posRemover = scanner.nextInt();
                    int removidoPos = lista.remover(posRemover);
                    System.out.println("Valor removido da posição " + posRemover + ": " + removidoPos);
                    break;
                case 0:
                    return; // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    private static void menuListaDupla(Scanner scanner) {
        ListaDupla lista = new ListaDupla();
        while (true) {
            System.out.println("Menu Lista Dupla:");
            System.out.println("1 - Inserir no Início");
            System.out.println("2 - Inserir no Fim");
            System.out.println("3 - Inserir em uma Posição");
            System.out.println("4 - Remover do Início");
            System.out.println("5 - Remover do Fim");
            System.out.println("6 - Remover de uma Posição");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valInicio = scanner.nextInt();
                    lista.inserirInicio(valInicio);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valFim = scanner.nextInt();
                    lista.inserirFim(valFim);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valPos = scanner.nextInt();
                    System.out.print("Digite a posição: ");
                    int pos = scanner.nextInt();
                    lista.inserir(valPos, pos);
                    break;
                case 4:
                    int removidoInicio = lista.removerInicio();
                    System.out.println("Valor removido do início: " + removidoInicio);
                    break;
                case 5:
                    int removidoFim = lista.removerFim();
                    System.out.println("Valor removido do fim: " + removidoFim);
                    break;
                case 6:
                    System.out.print("Digite a posição a ser removida: ");
                    int posRemover = scanner.nextInt();
                    int removidoPos = lista.remover(posRemover);
                    System.out.println("Valor removido da posição " + posRemover + ": " + removidoPos);
                    break;
                case 0:
                    return; // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    private static void menuABB(Scanner scanner) {
        ABB abb = new ABB();
        while (true) {
            System.out.println("Menu Arvore Binaria de Pesquisa:");
            System.out.println("1 - Inserir");
            System.out.println("2 - Pesquisar");
            System.out.println("3 - Caminhar Central");
            System.out.println("4 - Caminhar Pre");
            System.out.println("5 - Caminhar Pos");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int val = scanner.nextInt();
                    abb.inserir(val);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser pesquisado: ");
                    int valPesq = scanner.nextInt();
                    boolean encontrado = abb.pesquisar(valPesq);
                    System.out.println("Valor " + (encontrado ? "encontrado" : "não encontrado"));
                    break;
                case 3:
                    System.out.println("Caminhamento Central:");
                    abb.caminharCentral();
                    break;
                case 4:
                    System.out.println("Caminhamento Pre:");
                    abb.caminharPre();
                    break;
                case 5:
                    System.out.println("Caminhamento Pos:");
                    abb.caminharPos();
                    break;
                case 0:
                    return; // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    private static void menuAVL(Scanner scanner) {
        AVL avl = new AVL();
        while (true) {
            System.out.println("Menu AVL:");
            System.out.println("1 - Inserir");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int val = scanner.nextInt();
                    avl.inserir(val);
                    break;
                case 0:
                    return; // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    private static void menuTrie(Scanner scanner) {
        TrieHash trie = new TrieHash();
        while (true) {
            System.out.println("Menu Arvore Trie:");
            System.out.println("1 - Inserir");
            System.out.println("2 - Pesquisar");
            System.out.println("3 - Mostrar");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite a palavra a ser inserida: ");
                    String palavraInserir = scanner.nextLine();
                    trie.inserir(palavraInserir);
                    break;
                case 2:
                    System.out.print("Digite a palavra a ser pesquisada: ");
                    String palavraPesquisar = scanner.nextLine();
                    boolean encontrada = trie.pesquisar(palavraPesquisar);
                    System.out.println("Palavra " + (encontrada ? "encontrada" : "não encontrada"));
                    break;
                case 3:
                    System.out.println("Mostrando a Trie:");
                    trie.mostrar();
                    break;
                case 0:
                    return; // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}
