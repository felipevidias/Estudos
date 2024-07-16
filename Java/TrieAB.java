class NoTrie {
    char elemento;
    NoAB raiz; // OS FILHOS DA ARVORE FICARÃO ARMAZENADOS EM OUTRA ARVORE BINARIA
    boolean folha;

    public NoTrie() {
        this.elemento = '\0';
        this.raiz = null;
        this.folha = false;
    }

    public NoTrie(char elemento) {
        this.elemento = elemento;
        this.raiz = null;
        this.folha = false;
    }

    /*
     * METODOS DA ARVORE BINARIA
     */
    public NoTrie pesquisar(char x) { // ENTRA NA AB PARA PESQUISAR SE HA ALGUM CARACTERE CORRESPONDENTE
        return pesquisar(x, raiz);
    }

    private NoTrie pesquisar(char x, NoAB i) {
        NoTrie resp;
        if (i == null) {
            resp = null;
        } else if (x == i.elemento) {
            resp = i.no;
        } else if (x < i.elemento) {
            resp = pesquisar(x, i.esq);
        } else {
            resp = pesquisar(x, i.dir);
        }
        return resp;
    }

    public NoTrie inserir(char x) {
        raiz = inserir(x, raiz);
        return pesquisar(x);
    }

    private NoAB inserir(char x, NoAB i) {
        if (i == null) {
            i = new NoAB(x);
        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        }
        return i;
    }

    public void setFilhoFolha(char x) {
        setFilhoFolha(x, raiz);
    }

    private void setFilhoFolha(char x, NoAB i) { // SE FOR FINAL DE PALAVRA PROCURAR PARA POR O NO COMO TRUE
        if (i == null) {
            System.out.println("REBOLOU ERRADO PROS CRIA");
        } else if (x == i.elemento) {
            i.no.folha = true;
        } else if (x < i.elemento) {
            inserir(x, i.esq);
        } else if (x > i.elemento) {
            inserir(x, i.dir);
        }
    }

    public int getN() {
        return getN(raiz);
    }

    private int getN(NoAB i) { // PEGAR O NUMERO DE NÓS
        int resp = 0;
        if (i != null) {
            resp = 1 + getN(i.esq) + getN(i.dir);
        }
        return resp;
    }

    public NoTrie[] getFilho() { // PEGA TODO O CONTEUDO DA ARVORE
        int n = getN();
        NoTrie[] vet = new NoTrie[n];
        getFilho(vet, 0, raiz);
        return vet;
    }

    public int getFilho(NoTrie[] vet, int pos, NoAB i) {
        if (i != null) {
            vet[pos++] = i.no;
            pos = getFilho(vet, pos, i.esq);
            pos = getFilho(vet, pos, i.dir);
        }
        return pos;
    }

}

class NoAB {
    char elemento;
    NoAB esq, dir;
    NoTrie no;

    public NoAB() {
        this.elemento = '\0';
        this.esq = this.dir = null;
        this.no = null;
    }

    public NoAB(char elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
        this.no = new NoTrie(elemento);
    }
}

class ArvoreTrieAB {
    NoTrie raiz;

    public ArvoreTrieAB() {
        this.raiz = null;
    }

    /*
     * METODOS DA ARVORE
     */
    public void inserir(String s) throws Exception {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, NoTrie no, int i) throws Exception {
        NoTrie filho = no.pesquisar(s.charAt(i)); // PESQUISAR NA ARVORE BINARIA DE PROXIMOS
        if (filho == null) { // SE NAO HOUVER PALAVRA ALGUMA
            filho = no.inserir(s.charAt(i)); // ELE INSERE DENTRO DA ARVORE BINARIA DE PROXIMOS

            if (i == s.length() - 1) { // VERIFICA SE HA MAIS ALGUM CARACTERE PRA INSERIR
                no.setFilhoFolha(s.charAt(i)); // SE NAO, FOLHA = TRUE, FINALIZANDO A INSERÇÃO DA STRING
            } else { // SE HOUVER MAIS
                inserir(s, no, i + 1); // CONTINUA INSERINDO RECURSIVAMENTE
            }
        } else if (filho.folha == false && i < s.length() - 1) { // SE FOR UMA PALAVRA QUE JA HA PREFIXOS
            inserir(s, no, i + 1); // TERMINA DE INSERIR O RESTO
        } else { // AQUI FUDEU TUDO
            throw new Exception("PIROC0PSMODIKDVIKFNIKDMOLBMOED");
        }

    }

    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    private boolean pesquisar(String s, NoTrie no, int i) throws Exception {
        boolean resp;
        NoTrie filho = no.pesquisar(s.charAt(i)); // PESQUISA NA ARVORE BINARIA
        if (filho == null) { // SE FOR NULO, NÃO EXISTE A PALAVRA
            resp = false;
        } else if (i == s.length() - 1) { // SE O INDICE FOR IGUAL AO TAMANHO DA PALAVRA
            resp = filho.folha == true; // VERIFICA SE É FOLHA
        } else if (i < s.length() - 1) { // SE O INDICE FOR MENOR
            resp = pesquisar(s, no, i + 1); // TERMINA DE PESQUISAR RECURSIVAMENTE
        } else {
            throw new Exception("AAAAAAAAAAAAAAA");
        }
        return resp;
    }

    public void mostrar() {
        mostrar("", raiz);
    }

    private void mostrar(String s, NoTrie no) {
        if (no.folha == true) {
            System.out.println(s + no.elemento);
        } else {
            NoTrie[] filho = no.getFilho(); // FAZ UM ARRANJO COM TODOS OS FILHOS
            for (int i = 0; i < filho.length; i++) { // PERCORRE O ARRANJO TODO E MOSTRA O CARACTERE DO FILHO
                mostrar(s + no.elemento, filho[i]);
            }
        }
    }

}
