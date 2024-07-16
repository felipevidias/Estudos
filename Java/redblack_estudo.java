class NoRB {
    public int elemento;
    public NoRB esq, dir;
    public boolean cor;

    /*
     * CONSTRUTORES
     */
    public NoRB() {
        this.elemento = 0;
        this.esq = this.dir = null;
        this.cor = false;
    }

    public NoRB(int elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
        this.cor = false;
    }

    public NoRB(int elemento, NoRB esq, NoRB dir, boolean cor) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.cor = cor;
    }
}

class RedBlack {
    NoRB raiz;

    public RedBlack() {
        this.raiz = null;
    }

    /*
     * METODOS DE BALANCEAR
     */
    // ROTACIONAR ESQUERDA
    NoRB rotEsq(NoRB no) {
        NoRB noDir = no.dir;
        NoRB noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        return noDir;
    }

    // ROTACIONAR DIREITA
    NoRB rotDir(NoRB no) {
        NoRB noEsq = no.esq;
        NoRB noEsqDir = noEsq.dir;

        noEsq.dir = no;

        no.esq = noEsqDir;

        return noEsq;
    }

    NoRB rotDirEsq(NoRB no) {
        no.dir = rotDir(no.dir);
        return rotEsq(no);
    }

    NoRB rotEsqDir(NoRB no) {
        no.esq = rotEsq(no.esq);
        return rotEsq(no);
    }

    // BALANCEAR
    void balancear(NoRB bisavo, NoRB avo, NoRB pai, NoRB no) {
        if (pai.cor == true) { // se o pai for preto, reequilibrar a arvore
            if (pai.elemento > avo.elemento) {
                if (no.elemento > pai.elemento) { // ROTAÇÃO A ESQUERDA
                    avo = rotEsq(avo);
                } else {
                    avo = rotDirEsq(avo);
                }
            } else {
                if (no.elemento < pai.elemento) {
                    avo = rotDir(avo);
                } else {
                    avo = rotEsqDir(avo);
                }
            }
            if (bisavo == null) {
                raiz = avo;
            } else if (avo.elemento < bisavo.elemento) {
                bisavo.esq = avo;
            } else {
                bisavo.dir = avo;
            }
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }
}
