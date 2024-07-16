class CelulaPilha{
    int elemento;
    CelulaPilha prox;
    public Celula(){
        this(0);
    }
    public Celula(int x){
        this.elemento = x;
        this.prox = null;
    }
}

class CelulaLista{
    CelulaPilha topo;
    CelulaLista prox;
    public CelulaLista(){
        this.topo = null;
        this.prox = null;
    }
}

class Lista{
    CelulaLista primeiro, ultimo;
    public Lista(){
        this.primeiro = new CelulaLista();
        this.ultimo = this.primeiro;
    }
    // Q01 achar o maior da lista de pilhas
    public int tamanhoPilha(){
        int tamanho = 0;
        for(Celula i = primeiro.topo; i != null; i = i.topo.prox){
            tamanho += 1;
        }
        return tamanho;
    }

    CelulaLista maiorPilha(){
        CelulaLista maiorPilha = primeiro.prox;
        int maiorTamanho = maiorPilha.tamanhoPilha();
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            if(maiorTamanho < i.tamanhoPilha()){
                maiorPilha = i;
                maiorTamanho = i.tamanhoPilha();
            }
        }
        return maiorPilha;
    }
}
