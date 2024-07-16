class No {
    public char elemento;
    public final int tamanho = 255;
    public No[] prox;
    public boolean folha;

    public No() {
        this.elemento = '\0';
        this.prox = new No[tamanho];
        for (int i = 0; i < tamanho; i++) {
            this.prox[i] = null;
        }
        this.folha = false;
    }

    public No(char elemento) {
        this.elemento = elemento;
        this.prox = new No[tamanho];
        for (int i = 0; i < tamanho; i++) {
            this.prox[i] = null;
        }
        this.folha = false;
    }

    public static int hash(char x) {
        return (int) x;
    }
}

class ArvoreTrieHash {
    No raiz;

    public ArvoreTrieHash() {
        this.raiz = null;
    }

    /*
     * METODOS DA ARVORE TRIE
     */
    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    private boolean pesquisar(String s, No no, int i) throws Exception {
        boolean resp;
        if (no.prox[s.charAt(i)] == null) {
            resp = false;
        } else if (i == s.length() - 1) {
            resp = no.prox[s.charAt(i)].folha == true;
        } else if (i < s.length() - 1) {
            resp = pesquisar(s, no, i + 1);
        } else {
            throw new Exception("ERRO!");
        }
        return resp;
    }

    public void inserir(String s) throws Exception {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, No no, int i) throws Exception {
        if (no.prox[s.charAt(i)] == null) {
            no.prox[s.charAt(i)] = new No(s.charAt(i));
        } else if (i == s.length() - 1) {
            no.prox[s.charAt(i)].folha = true;
        } else if (i < s.length() - 1) {
            inserir(s, no, i + 1);
        } else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1) {
            inserir(s, no, i + 1);
        }
    }

    public void mostrar() {
        mostrar("", raiz);
    }

    private void mostrar(String s, No no) {
        if (no.folha == true) {
            System.out.println(s + no.elemento); // SE A FOLHA DO NÓ FOR TRUE, TEM PALAVRA COMPLETA, COMEÇA A MOSTRAR
        } else {
            for (int i = 0; i < no.prox.length; i++) { // PERCORRE CARACTERE-A-CARACTERE
                if (no.prox[i] != null) { // VERIFICA TODOS OS FILHOS ATE NAO TER MAIS
                    mostrar(s + no.elemento, no.prox[i]); // FUNÇÃO RECURSIVA PRA MOSTRAR DNV
                }
            }
        }
    }
}
