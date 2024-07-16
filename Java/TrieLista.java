class NoTrie {
    char elemento;
    Celula primeiro, ultimo;
    boolean folha;

    public NoTrie() {
        this.elemento = '\0';
        this.primeiro = this.ultimo = null;
        this.folha = false;
    }

    public NoTrie(char elemento) {
        this.elemento = elemento;
        this.primeiro = this.ultimo = new Celula();
        this.folha = false;
    }

    /*
     * METODOS DA LISTA ENCADEADA
     */
    public NoTrie inserir(char x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
        return ultimo.no;
    }

    public NoTrie pesquisar(char x) {
        NoTrie resp = null;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento == x) {
                resp = i.no;
                i = ultimo;
            }
        }
        return resp;
    }

    public void setFilhoFolha(char x) {
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento == x) {
                i.no.folha = true;
                i = ultimo;
            }
        }
    }

    public NoTrie[] getFilho() {
        int n = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox, n++)
            ;
        NoTrie[] vet = new NoTrie[n];

        n = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            vet[n++] = i.no;
        }
        return vet;
    }

    public void mostrar() {
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.println(i.elemento);
        }
    }
}

class Celula {
    char elemento;
    Celula prox;
    public NoTrie no;

    public Celula() {
        this.elemento = '\0';
        this.prox = null;
        this.no = null;
    }

    public Celula(char elemento) {
        this.elemento = elemento;
        this.prox = null;
        this.no = null;
    }
}

class ArvoreTrieLista {
    NoTrie raiz;

    public ArvoreTrieLista() {
        this.raiz = null;
    }

    /*
     * METODOS DA ARVORE
     */
    public void inserir(String s) {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, NoTrie no, int i) {
        NoTrie filho = no.pesquisar(s.charAt(i));
        if (filho == null) {
            filho = no.inserir(s.charAt(i));

            if (i == s.length() - 1) {
                no.setFilhoFolha(s.charAt(i));
            } else {
                inserir(s, no, i + 1);
            }
        } else if (filho.folha == false && i < s.length() - 1) {
            inserir(s, no, i + 1);
        }
    }

    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    private boolean pesquisar(String s, NoTrie no, int i) throws Exception {
        boolean resp;
        NoTrie filho = no.pesquisar(s.charAt(i));
        if (filho == null) {
            resp = false;
        } else if (i == s.length() - 1) {
            resp = filho.folha == true;
        } else if (i < s.length() - 1) {
            resp = pesquisar(s, no, i + 1);
        } else {
            throw new Exception("ERRO!");
        }
        return resp;
    }

    public void mostrar() {
        mostrar("", raiz);
    }

    private void mostrar(String s, NoTrie no) {
        if (no.folha = true) {
            System.out.println(s + no.elemento);
        } else {
            NoTrie[] filho = no.getFilho();
            for (int i = 0; i < filho.length; i++) {
                mostrar(s, filho[i]);
            }
        }
    }
}
