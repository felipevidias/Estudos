class NoHash {
    char letra;
    final int tamanho = 255;
    NoHash[] prox;
    boolean folha;

    public NoHash() {
        this.letra = '\0';
        for (int i = 0; i < this.prox.length; i++) {
            this.folha = false;
        }
    }

    public NoHash(char letra) {
        this.letra = letra;
        for (int i = 0; i < this.prox.length; i++) {
            this.folha = false;
        }
    }
}

/*
 * ARVORE TRIE COM TABELA HASH
 */

class TrieHash {
    NoHash raiz;

    public TrieHash() {
        this.raiz = null;
    }

    /*
     * METODOS DA ARVORE
     */
    public boolean pesquisar(String s, NoHash no, int i) {
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

    public void inserir(String s, NoHash no, int i) {
        if (no.prox[s.charAt(i)] == null) {
            no.prox[s.charAt(i)] = new NoHash(s.charAt(i));

            if (i == s.length() - 1) {
                no.prox[s.charAt(i)].folha = true;
            } else {
                inserir(s, no.prox[s.charAt(i)], i + 1);
            }
        } else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1) {
            inserir(s, no.prox[s.charAt(i)], i + 1);
        }
    }

    public void mostrar(String s, NoHash no) {
        if (no.folha == true) {
            System.out.println(s + no.letra);
        } else {
            for (int i = 0; i < no.prox.length; i++) {
                mostrar(s + no.letra, no.prox[i]);
            }
        }
    }
}

/*
 * NO DA ARVORE COM LISTA ENCADEADA
 */
class Celula {
    char letra;
    NoLista no;
    Celula prox;

    public Celula() {
        this.letra = '\0';
        this.no = null;
        this.prox = null;
    }

    public Celula(char letra) {
        this.letra = letra;
        this.no = new NoLista(letra);
        this.prox = null;
    }
}

class NoLista {
    char letra;
    Celula primeiro, ultimo;
    boolean folha;
    NoLista no;

    public NoLista() {
        this.letra = '\0';
        this.ultimo = this.primeiro = new Celula();
        this.folha = false;
    }

    public NoLista(char letra) {
        this.letra = '\0';
        this.folha = false;
    }

    /*
     * METODOS DA LISTA ENCADEADA
     */
    NoLista inserir(char x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
        return ultimo.no;
    }

    NoLista pesquisar(char x) {
        NoLista resp = null;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (x == i.letra) {
                resp = i.no;
                i = ultimo;
            }
        }
        return resp;
    }

    void setFilhoFolha(char x) {
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (x == i.letra) {
                i.no.folha = true;
                i = ultimo;
            }
        }
    }

    NoLista[] getFilho() {
        int n = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox, n++)
            ;
        NoLista[] vet = new NoLista[n];

        n = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            vet[n++] = i.no;
        }

        return vet;
    }

}

class ArvoreLista {
    NoLista raiz;

    public ArvoreLista() {
        raiz = null;
    }

    /*
     * METODOS
     */

    public void inserir(String s, NoLista no, int i) {
        NoLista filho = no.pesquisar(s.charAt(i));
        if (filho == null) {
            filho = no.inserir(s.charAt(i));

            if (i == s.length() - 1) {
                no.setFilhoFolha(s.charAt(i));
            } else {
                inserir(s, filho, i + 1);
            }
        } else if (i < s.length() - 1 && filho.folha == false) {
            inserir(s, filho, i + 1);
        }
    }

    public boolean pesquisar(String s, NoLista no, int i) {
        boolean resp = false;
        NoLista filho = no.pesquisar(s.charAt(i));
        if (filho == null) {
            resp = false;
        } else if (i == s.length() - 1) {
            resp = filho.folha == true;
        } else if (i < s.length() - 1) {
            resp = pesquisar(s, filho, i + 1);
        }
        return resp;
    }

    public void mostrar(String s, NoLista no) {
        if (no.folha == true) {
            System.out.println("Palavra:" + s + no.letra);
        } else {
            NoLista[] filhos = no.getFilho();
            for (int i = 0; i < filhos.length; i++) {
                mostrar(s + no.letra, filhos[i]);
            }
        }
    }
}
