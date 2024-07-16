class CelulaDupla{
    int elemento;
    Celula ant, prox;
    public CelulaDupla(){
        this(0);
    }
    public CelulaDupla(int x){
        this.elemento = x;
        this.ant = this.prox = null;
    }
}

class ListaDupla{
    CelulaDupla primeiro, ultimo;
    public ListaDupla(){
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    // Metodos
   public void inserirInicio(int x){
        CelulaDupla tmp = new CelulaDupla(x);
        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if(primeiro == ultimo){
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }
        tmp = null;
    }

    public void inserirFim(int x){
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }

  public int removerInicio() throws Exception{
    if(primeiro == ultimo)
        new Exception("Erro!");
    CelulaDupla tmp = primeiro;
    primeiro = primeiro.prox;
    int elemento = primeiro.prox.elemento;
    tmp.prox = primeiro.ant = null;
    tmp = null;
    return elemento;
  }

  public int removerFim() throws Exception{
    if(primeiro == ultimo)
        new Exception("Erro!");
    int elemento = ultimo.elemento;
    ultimo = ultimo.ant;
    ultimo.prox.ant = null;
    ultimo.prox = null;
    return elemento;
  }
  
  public int tamanho(){
    int tamanho = 0;
    for(CelulaDupla i = primeiro; i != null; i = i.prox){
        tamanho++;
    }
    return tamanho;
  }

  public void inserir(int x, int pos)throws Exception{
    int tamanho = tamanho();
    if(pos < 0 || pos > tamanho){
        new Exception("Erro!");
    } else if(pos == 0){
        inserirInicio(x);
    } else if( pos == tamanho){
        inserirFim(x);
    } else{
        CelulaDupla i = primeiro;
        for(int j = 0; j < pos; j++, i = i.prox);
        CelulaDupla tmp = new CelulaDupla(x);
        tmp.ant = i; 
        tmp.prox = i.prox;
        tmp.ant.prox = tmp.prox.ant = tmp;
        tmp = i = null;
    }
  }

  public void remover(int pos)throws Exception{
    int tamanho = tamanho();
    int elemento;
    if(pos < 0 || pos > tamanho){
        new Exception("Erro");
    } else if(pos == 0){
        elemento = removerInicio();
    } else if(pos == tamanho - 1)[
        elemento = removerFim();
    ] else{
        CelulaDupla i = primeiro.prox;
        for(int j = 0; j < pos; j++, i = i.prox);
        i.ant.prox = i.prox;
        i.prox.ant = i.ant;
        elemento = i.elemento;
        i.ant = i.prox = null;
        i = null;
    }
    return elemento;
  }

  public void mostrar(){
    for(CelulaDupla i = primeiro.prox; i != null; i = i.prox){
        System.out.println(i.elemento + "");
    }
  }
}