// class doidona
void inserir(int x) {
    int h1 = hashT1(x);
    if (t1[h1].elemento == NULO) {
        t1[h1].elemento = x;
    } else {
        t1[h1].t2.inserir(x);
    }
}

// class T2
void inserir(int x) {
    int h2 = hashT2(x);
    if (tab[h2] == NULO) {
        tab[h2] = x;
    } else if (tab[h2] != NULO) {
        int r2 = rehashT2(x);
        if (tab[r2] == NULO) {
            tab[r2] = x;
        } else {
            int h3 = hashT3(x);
            if (h3 == 0) {
                ultimoT3.prox = new CelulaT3(x);
                ultimoT3 = ultimoT3.prox;
            } else {
                raizT3 = inserirNaArvore(raizT3, x);
            }
        }

    }
}

// class No
No inserirNaArvore(No i, int x) {
    if (i == null) {
        i = new No(x);
    } else if (i.elemento < x) {
        i.dir = inserirNaArvore(i.dir, x)
    } else{
        i.esq = inserirNaArvore(i.esq, x)
    }
    return i;
}
