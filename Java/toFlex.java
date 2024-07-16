import java.util.Scanner;

class Celula{
    public int elemento;
    public Celula prox;
    public Celula{
        this(0);
    }
    public Celula(int x){
        this.elemento = x;
        this.prox = null;
    }
}

class Pilha{
    public Celula topo;
    public Celula{
        topo = null;
    }

    public void inserir(int x ){
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;;
    }

    public int remover() throws Exception{
        if(topo == null)
            new Exception("Erro!");
        int elemento  = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        return elemento;
    }

    public void mostrar{
        for(Celula i = topo; i != null; i = i.prox){
            System.out.println(i.elemento);
        }
    }
}

class Fila{
    public Celula primeiro, ultimo;
    public Celula{
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserir(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }  

    public int remover() throws Exception{
        if(primeiro == ultimo)
            new Exception("Erro!");
        Celula tmp = primeiro.prox;  // pula o nó da fila
        primeiro.prox = primeiro.prox.prox;
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    public void mostrar(){
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }
}

public class toFlex{
    public void toFila(Celula topo) throws Exception{
       Fila fila = new Fila();
       Pilha pilhaAux = new Pilha();

       while(topo != null){
        pilhaAux.inserir(topo.elemento);
        topo = topo.prox;
       }

       while(pilhaAux.topo != null)
       {
        int elemento = pilhaAux.remover();
        fila.inserir(elemento);
       }

       return fila;
    }

    public Pilha toPilha(Celula primeiro){
        Pilha pilha = new Pilha();
        Fila filaAux = new Fila();

        while(primeiro != null){
            filaAux.inserir(primeiro.elemento);
            primeiro = primeiro.prox;
        }

        while(filaAux.primeiro != null){
            int elemento = filaAux.remover();
            pilha.inserir(elemento);
        }
        return pilha; 
    }
    
    public static void main(String[] args){

    }
}