public class Celula{
    int elemento;
    Celula prox;
    public Celula(){
        this(0);
    }
    public Celula(int x){
        this.elemento = x; 
        this.prox = null;
    }
}

public class Fila{
    Celula primeiro, ultimo;
    public Celula{
        this.primeiro = null;
        this.ultimo = null;
    }

    public void inserir(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int remover() throws Exception{
        if(ultimo == null)
            new Exception("Erro!");
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    public void mostrar(){
        for(Celula i = primeiro; i != null; i = i.prox){
        System.out.print(i.elemento + " ");
        }
    }
}

public class Pilha{
    Celula topo; 
    public Celula{
        topo = null;
    }
}