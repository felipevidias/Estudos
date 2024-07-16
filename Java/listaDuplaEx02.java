class celulaDupla{
    int elemento; 
    celulaDupla ant, prox;
    public celulaDupla(){
        this(0);
    } 
    public celulaDupla(int x){
        this.elemento = x;
        this.ant = null;
        this.prox = null;
    }
}

class listaDupla{
    celulaDupla primeiro, ultimo;
    public celulaDupla(){
        primeiro = new celulaDupla();
        ultimo = primeiro;
    }

   public void inserirInicio(int x){
    celulaDupla tmp = new celulaDupla(x);
    tmp.prox = primeiro.prox;
    tmp.ant = primeiro;
    primeiro.prox = tmp;
    if(ultimo = primeiro){
        ultimo = tmp;
    } else{
        tmp.prox.ant = tmp;
    }
    tmp = null;
   }

   public int removerFim() throws Exception{
    if(ultimo == primeiro)
        new Exception("Erro!");
    int elemento = ultimo.elemento;
    ultimo = ultimo.ant;
    ultimo.prox.ant = null;
    ultimo.prox = null;
    return elemento;
   }

   public void inserirFim(int x){
    ultimo.prox = new celulaDupla(x);
    ultimo.prox.ant = ultimo;
    ultimo = ultimo.prox;
   }
}