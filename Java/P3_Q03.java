class T1 {
    int tam1;
    String palavras[];
    T2 t2;
    T3 t3;

    public T1() {
        this.tam1 = 397;
        this.palavras = new String[tam1];
        this.t2 = new T2();
        this.t3 = new T3();
    }

    public T1(int tam1) {
        this.tam1 = tam1;
        this.palavras = new String[tam1];
        this.t2 = new T2();
        this.t3 = new T3();
    }

    int hashT1(char x) {
        return (int) x % tam1;
    }

    int hashVirtual(char x) {
        return (int) x % 2;
    }

    public void inserir(String s) { // hash da t1 usa o primeiro caractere
        int meter = hashT1(s.charAt(0));
        if (palavras[meter] == null) {
            palavras[meter] = s;
        } else {
            int meteVirtual = hashVirtual(s.charAt(0));
            if (meteVirtual == 0) {
                t2.inserir(s);
            } else {
                t3.inserir(s);
            }
        }
    }

    public boolean pesquisar(String s) {
        int meter = hashT1(s.charAt(0));
        // Verifica se a palavra está no array de T1
        if (palavras[meter] != null && palavras[meter].equals(s)) {
            return true;
        } else {
            // Usa o hash virtual para decidir onde procurar
            int meteVirtual = hashVirtual(s.charAt(0));
            if (meteVirtual == 0) {
                return t2.pesquisar(s);
            } else {
                return t3.pesquisar(s);
            }
        }
    }
}

class T2 {
    int tam2;
    No raizes[];

    public T2() {
        this.tam2 = 397;
        this.raizes = new No[tam2];
    }

    int hashT2(char x) { // pega o segundo caractere da palavra
        return (int) x % tam2;
    }

    void inserir(String s) {
        int meteT2 = hashT2(s.charAt(1));
        if (raizes[meteT2] == null) {
            raizes[meteT2] = new No(s.charAt(0)); // Inicializa o nó se for nulo
        }
        raizes[meteT2].inserir(s, raizes[meteT2]);
    }

    boolean pesquisar(String s) {
        int meteT2 = hashT2(s.charAt(1));
        if (raizes[meteT2] == null) {
            return false; // Não há nada para pesquisar
        } else {
            return pesquisarArvore(raizes[meteT2], s);
        }
    }

    private boolean pesquisarArvore(No no, String s) {
        if (no == null) {
            return false;
        }
        if (no.letra == s.charAt(0)) {
            return pesquisarLista(no.inicio, s);
        } else if (s.charAt(0) < no.letra) {
            return pesquisarArvore(no.esq, s);
        } else {
            return pesquisarArvore(no.dir, s);
        }
    }

    private boolean pesquisarLista(Celula2 celula, String s) {
        while (celula != null) {
            if (s.equals(celula.palavra)) {
                return true;
            }
            celula = celula.prox;
        }
        return false;
    }
}

class T3 {
    int tam3;
    String palavras[];
    Celula3 inicio;

    public T3() {
        this.tam3 = 397;
        this.palavras = new String[tam3];
    }

    public T3(int tam) {
        this.tam3 = tam;
        this.palavras = new String[tam3];
    }

    int hashT3(char x) {
        return (int) x % tam3;
    }

    int rehashT3(char x) {
        return (int) ++x % tam3;
    }

    void inserir(String s) {
        int meteT3 = hashT3(s.charAt(1)); // pega a segunda posição
        if (palavras[meteT3] == null) {
            palavras[meteT3] = s;
        } else {
            int rehashMeteT3 = rehashT3(s.charAt(1));
            if (palavras[rehashMeteT3] == null) {
                palavras[rehashMeteT3] = s;
            } else {
                if (inicio == null) {
                    inicio = new Celula3(s);
                } else {
                    inicio.inserir(s, inicio);
                }
            }
        }
    }

    boolean pesquisar(String s) {
        int meteT3 = hashT3(s.charAt(1));
        if (palavras[meteT3] != null && palavras[meteT3].equals(s)) {
            return true;
        } else {
            int rehashMeteT3 = rehashT3(s.charAt(1));
            if (palavras[rehashMeteT3] != null && palavras[rehashMeteT3].equals(s)) {
                return true;
            } else {
                return pesquisarLista(inicio, s);
            }
        }
    }

    private boolean pesquisarLista(Celula3 celula, String s) {
        while (celula != null) {
            if (s.equals(celula.palavra)) {
                return true;
            }
            celula = celula.prox;
        }
        return false;
    }
}
