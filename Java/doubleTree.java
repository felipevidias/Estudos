import java.util.Scanner;

/*
 * PRIMEIRA ARVORE DE STRINGS
 */

class No {
    String palavra;
    No esq, dir;

    public No(String s) {
        this(s, null, null);
    }

    public No(String s, No esq, No dir) {
        this.palavra = s;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreString {
    No raiz;

    // CONSTRUTOR
    public ArvoreString() {
        raiz = null;
    }

    /*
     * METODOS
     */
    public void insert(String s) throws Exception {
        raiz = inserir(s, raiz);
    }

    public No inserir(String s, No i) throws Exception {
        if (i == null) {
            i = new No(s);
        } else if (s.compareTo(i.palavra) < 0) {
            i.esq = inserir(s, i.esq);
        } else if (s.compareTo(i.palavra) > 0) {
            i.dir = inserir(s, i.dir);
        } else {
            throw new Exception("Erro: Palavra já inserida!");
        }
        return i;
    }

    public boolean search(String s) throws Exception {
        return buscar(s, raiz);
    }

    public boolean buscar(String s, No i) throws Exception {
        if (i == null) {
            return false;
        } else if (s.compareTo(i.palavra) == 0) {
            return true;
        } else if (s.compareTo(i.palavra) < 0) {
            return buscar(s, i.esq);
        } else {
            return buscar(s, i.dir);
        }
    }

    public void walkCentral() {
        caminharCentral(raiz);
    }

    public void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.print(i.palavra + " ");
            caminharCentral(i.dir);
        }
    }

    public boolean isTam10() {
        return stringTamanho10(raiz);
    }

    public boolean stringTamanho10(No i) {
        if (i == null) {
            return false;
        } else if (i.palavra.length() == 10) {
            return true;
        } else {
            return stringTamanho10(i.esq) || stringTamanho10(i.dir);
        }
    }
}

/*
 * SEGUNDA ARVORE QUE SERÁ UMA ARVORE DE ARVORE
 */

class NoAB {
    char inicial;
    ArvoreString arvore;
    NoAB esq, dir;

    public NoAB(char inicial, ArvoreString ab) {
        this(inicial, ab, null, null);
    }

    public NoAB(char inicial, ArvoreString ab, NoAB esq, NoAB dir) {
        this.inicial = inicial;
        this.arvore = ab;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreTree {
    NoAB raiz;

    // CONSTRUTOR
    public ArvoreTree() {
        raiz = null;
    }

    /*
     * METODOS
     */
    void addAB(String palavra) throws Exception {
        raiz = adicionarAB(palavra, raiz);
    }

    NoAB adicionarAB(String palavra, NoAB i) throws Exception {
        if (i == null) {
            ArvoreString ab = new ArvoreString();
            ab.insert(palavra);
            i = new NoAB(palavra.charAt(0), ab);
        } else if (palavra.charAt(0) == i.inicial) {
            i.arvore.insert(palavra);
        } else if (palavra.charAt(0) < i.inicial) {
            i.esq = adicionarAB(palavra, i.esq);
        } else {
            i.dir = adicionarAB(palavra, i.dir);
        }
        return i;
    }

    boolean searchAB(String palavra) throws Exception {
        return buscaAB(palavra, raiz);
    }

    boolean buscaAB(String palavra, NoAB i) throws Exception {
        if (i == null) {
            return false;
        } else if (palavra.charAt(0) == i.inicial) {
            return i.arvore.search(palavra);
        } else if (palavra.charAt(0) < i.inicial) {
            return buscaAB(palavra, i.esq);
        } else {
            return buscaAB(palavra, i.dir);
        }
    }

    public void print() {
        mostrar(raiz);
    }

    public void mostrar(NoAB i) {
        if (i != null) {
            mostrar(i.esq);
            i.arvore.walkCentral();
            mostrar(i.dir);
        }
    }

    public boolean hasStringTam10() {
        return temString10(raiz);
    }

    public boolean temString10(NoAB i) {
        if (i == null) {
            return false;
        } else if (i.arvore.isTam10()) {
            return true;
        } else {
            return temString10(i.esq) || temString10(i.dir);
        }
    }

    public void printIniciais() {
        mostrarIniciais(raiz);
    }

    public void mostrarIniciais(NoAB i) {
        if (i != null) {
            mostrarIniciais(i.esq);
            System.out.println("Inicial: " + i.inicial);
            mostrarIniciais(i.dir);
        }
    }
}

class doubleTree {
    public static void main(String[] args) {
        try {
            ArvoreTree arvore = new ArvoreTree();
            
            // Adicionando palavras na árvore
            arvore.addAB("apple");
            arvore.addAB("banana");
            arvore.addAB("apricot");
            arvore.addAB("blueberry");
            arvore.addAB("blackberry");
            arvore.addAB("avocado");

            // Imprimindo a árvore
            System.out.println("Palavras na árvore:");
            arvore.print();

            // Imprimindo iniciais das árvores
            System.out.println("\nIniciais das árvores:");
            arvore.printIniciais();

            // Buscando palavras
            System.out.println("\nBuscando palavras:");
            System.out.println("apple: " + arvore.searchAB("apple"));
            System.out.println("banana: " + arvore.searchAB("banana"));
            System.out.println("grape: " + arvore.searchAB("grape"));

            // Verificando se existe palavra com 10 caracteres
            System.out.println("\nExiste palavra com 10 caracteres?: " + arvore.hasStringTam10());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
