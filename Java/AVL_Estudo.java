class No {
    int elemento;
    int altura;
    No esq, dir;

    public No() {
        this.elemento = 0;
        this.altura = 1;
        this.esq = null;
        this.dir = null;
    }

    public No(int elemento) {
        this.elemento = elemento;
        this.altura = 1;
        this.esq = null;
        this.dir = null;
    }
}

class AVL {
    No raiz;

    public AVL() {
        this.raiz = null;
    }

    // ROTAÇÃO A ESQUERDA
    No rotacionarEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        // Atualizar as alturas
        no.altura = Math.max(getAltura(no.esq), getAltura(no.dir)) + 1;
        noDir.altura = Math.max(getAltura(noDir.esq), getAltura(noDir.dir)) + 1;

        return noDir;
    }

    // ROTAÇÃO A DIREITA
    No rotacionarDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        // Atualizar as alturas
        no.altura = Math.max(getAltura(no.esq), getAltura(no.dir)) + 1;
        noEsq.altura = Math.max(getAltura(noEsq.esq), getAltura(noEsq.dir)) + 1;

        return noEsq;
    }

    // ROTAÇÃO DUPLA ESQUERDA-DIREITA
    No rotEsqDir(No no) {
        no.esq = rotacionarEsq(no.esq);
        return rotacionarDir(no);
    }

    // ROTAÇÃO DUPLA DIREITA-ESQUERDA
    No rotDirEsq(No no) {
        no.dir = rotacionarDir(no.dir);
        return rotacionarEsq(no);
    }

    // FATOR DE BALANCEAMENTO
    int getFator(No no) {
        return no == null ? 0 : getAltura(no.dir) - getAltura(no.esq);
    }

    // ALTURA
    int getAltura(No no) {
        return no == null ? 0 : no.altura;
    }

    // BALANCEAR A ÁRVORE
    No balancear(No no) {
        int fator = getFator(no);

        if (fator > 1) { // Desequilíbrio à direita
            if (getFator(no.dir) >= 0) {
                no = rotacionarEsq(no);
            } else {
                no = rotDirEsq(no);
            }
        } else if (fator < -1) { // Desequilíbrio à esquerda
            if (getFator(no.esq) <= 0) {
                no = rotacionarDir(no);
            } else {
                no = rotEsqDir(no);
            }
        }
        return no;
    }

    // INSERIR
    public void inserir(int elemento) {
        try {
            raiz = add(elemento, raiz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ADICIONAR
    public No add(int elemento, No no) throws Exception {
        if (no == null) {
            no = new No(elemento);
        } else {
            if (elemento < no.elemento) {
                no.esq = add(elemento, no.esq);
            } else if (elemento > no.elemento) {
                no.dir = add(elemento, no.dir);
            } else {
                throw new Exception("DUPLICADO");
            }

            no.altura = Math.max(getAltura(no.esq), getAltura(no.dir)) + 1;
            no = balancear(no);
        }
        return no;
    }
}
