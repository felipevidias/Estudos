class Pessoa {
    String nome;
    String cpf;
    int idade;

    public Pessoa() {
        this.nome = " ";
        this.cpf = " ";
        this.idade = 0;
    }

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    /*
     * SETTERS E GETTERS
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getCPF() {
        return cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

}

class No {
    Pessoa pessoa;
    No esq, dir;
    int altura;

    public No() {
        this.pessoa = null;
        this.esq = this.dir = null;
        this.altura = 1;
    }

    public No(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.esq = this.dir = null;
        this.altura = 1;
    }
}

class AVL {
    No raiz;

    public AVL() {
        this.raiz = null;
    }

    /*
     * PEGAR ALTURA E FATOR
     */
    int getFator(No no) {
        return no == null ? 0 : getAltura(no.dir) - getAltura(no.esq);
    }

    int getAltura(No no) {
        return no == null ? 0 : no.altura;
    }

    /*
     * ROTAÇÕES E BALANCEAMENTO DA AVL
     */

    /*
     * ROTAÇÕES SIMPLES
     */
    public No rotEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        // atualizar alturas
        no.altura = Math.max(getAltura(no.esq), getAltura(no.dir)) + 1;
        noDir.altura = Math.max(getAltura(noDir.esq), getAltura(noDir.dir)) + 1;

        return noDir;
    }

    public No rotDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;

        no.esq = noEsqDir;

        // atualizar alturas
        no.altura = Math.max(getAltura(no.esq), getAltura(no.dir)) + 1;
        noEsq.altura = Math.max(getAltura(noEsq.esq), getAltura(noEsq.dir)) + 1;

        return noEsq;
    }

    /*
     * ROTAÇÕES DUPLAS
     */

    No rotEsqDir(No no) {
        no.esq = rotEsq(no.esq);
        return rotDir(no);
    }

    No rotDirEsq(No no) {
        no.dir = rotDir(no.dir);
        return rotEsq(no);
    }

    /*
     * BALANCEAR
     */
    No balancear(No no) {
        int fator = getFator(no);

        if (fator > 1) { // Desequilíbrio à direita
            if (getFator(no.dir) >= 0) {
                no = rotEsq(no);
            } else {
                no = rotDirEsq(no);
            }
        } else if (fator < -1) { // Desequilíbrio à esquerda
            if (getFator(no.esq) <= 0) {
                no = rotDir(no);
            } else {
                no = rotEsqDir(no);
            }
        }
        return no;
    }

    /*
     * METODOS DA AVL
     */
    public void inserir(Pessoa pessoa) throws Exception {
        raiz = inserir(pessoa, raiz);
    }

    private No inserir(Pessoa pessoa, No i) throws Exception {
        if (i == null) {
            i = new No(pessoa);
        } else if (i.pessoa.nome.compareTo(pessoa.nome) > 0) {
            i.esq = inserir(pessoa, i.esq);
        } else if (i.pessoa.nome.compareTo(pessoa.nome) < 0) {
            i.dir = inserir(pessoa, i.dir);
        } else {
            // erro
        }

        return balancear(i);
    }

    public boolean pesquisar(Pessoa pessoa) {
        return pesquisar(pessoa, raiz);
    }

    private boolean pesquisar(Pessoa pessoa, No i) {
        boolean resp = false;
        if (i == null) {
            // erro
        } else if (i.pessoa.nome.compareTo(pessoa.nome) == 0) {
            resp = true;
        } else if (i.pessoa.nome.compareTo(pessoa.nome) > 0) {
            resp = pesquisar(pessoa, i.esq);
        } else if (i.pessoa.nome.compareTo(pessoa.nome) < 0) {
            resp = pesquisar(pessoa, i.dir);
        } else {
            // erro
        }
        return resp;
    }
}

class brincadeiras {
    public static void main(String args[]) {

    }
}
