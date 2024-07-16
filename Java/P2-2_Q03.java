class Matriz{
    CelulaMat inicio;
    // Metodo
    public void removerImpar(){
        CelulaMat linhaAtual = inicio;
        while(linhaAtual != null){
            CelulaMat colunaAtual = linhaAtual;
            while(celulaAtual != null){
                Celula lista= colunaAtual.primeiro;
                while(lista != null){
                    if(!(lista.numero % 2 == 0)){
                        lista.numero = 0;
                    }
                    lista = lista.prox
                }
                colunaAtual = colunaAtual.prox;
            }
            linhaAtual = linhaAtual.inf;
        }
    }
}
class CelulaMat{
    CelulaMat prox, ant, sup, inf;
    Celula primeiro, ultimo;
    public CelulaMat(){
        prox = ant = sup = inf = null;
        primeiro = ultimo = new Celula();
    }
}
class Celula{
    int numero;
    Celula prox;
    public Celula(){
        this(0);
    }
    public Celula(int x){
        this.numero = x; prox = null;
    }
}

