// rotação simples a esquerda
void metodo(){
    //...
    no = rotacionarEsq(no);
    //...
}
No rotacionarEsq(No no){
    No noEsq = no.esq;
    No noEsqDir = noEsq.dir;
    noEsqDir = no;
    no.esq = noEsqDir;
    return noEsq;
}

// rotação simples a direita

void metodo(){
    //...
    no = rotacionarDir(no);
    //...
}
No rotacionarDir(No no){
    No noDir = no.dir;
    No noDirEsq = noDir.esq;
    noDirEsq = no;
    no.dir = noDirEsq;
    return noDir; 
}

// rotação dupla direita - esquerda

No rotacionarDirEsq(No no){
    no.dir = rotacionarDir(no.dir);
    return rotacionarEsq(no);
}

// rotação dupla esqurda - direita

No rotacionarEsqDir(No no){
    no.esq = rotacionarEsq(no.esq);
    return rotacionarDir(no);
}

// balencear pra 3 casos

void balencear(){
    if(raiz.esq != null && raiz.dir != null){
        System.out.println("Arvore Balanceada.");
    } else if(raiz.dir != null){
        if(raiz.dir.dir != null){
            raiz = rotacionarEsq(raiz);
        } else{ 
            raiz = rotacionarDirEsq(raiz);
            
        }
    } else{
        if(raiz.esq.dir != null){
            raiz = rotacionarEsqDir(raiz);
        } else{
            raiz = rotacionarDir(raiz);
        }
    }
}