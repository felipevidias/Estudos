
// O(log n)
class No{
    String s;
    No esq,dir;
    public No(){
        this.s = null;
        this.esq = this.dir = null;
    }
    public No(String s){
        this.s = s;
        this.esq = this.dir = null;
    }
}

// O(n)
class Celula{
    String s;
    Celula prox;
    public Celula(){
        this.s = null;
        this.prox = null;
    }
    public Celula(String s){
        this.s = s;
        this.prox = null;
    }
}

// O(1)
class HashTable{
    int tamanho;
    String table[];

    public HashTable(){
        this.tamanho = 13; // lULA
        this.table = new String[tamanho];
        for(int i = 0; i < tamanho; i++){
            table[i] = "";
        }
    }
    public HashTable(int tamanho){
        this.tamanho = tamanho;
        this.table = new String[tamanho];
        for(int i = 0; i < tamanho; i++){
            table[i] = "";
        }
    }

    int hash(String s){
        int hashSeilaOq = 0;
        for(int i = 0; i < s.length(); i++){
            hashSeilaOq += (int)s.charAt(i);
        }
        return hashSeilaOq % tamanho;
    }


    public void mete(String s){
        int i = hash(s);
        if(table[i] == ""){
            table[i] = s;
        } else{
            System.out.println("O HAUCK MAMA SACO VELHO!!!!!!");
        }
    }
}


class AB{
    No raiz;
    public AB(){
        this.raiz = null;
    }


    /*
     * METE
     */
    public void mete(String s){
        raiz = mete(s, raiz);
    }
    private No mete(String sexo, No i){
        if(i == null){
            i = new No(sexo);
        } else if(i.s.compareTo(sexo) > 0){
            i.dir = mete(sexo, i.dir);
        } else{
            i.esq = mete(sexo, i.esq);
        }
        System.out.println("O ARTHUR MAMA OVO!!!!!!!");
        return i;
    }
}

class Lista{
    Celula primeiro, ultimo;

    public Lista(){
        this.primeiro = new Celula();
        this.ultimo = this.primeiro;
    }

    /*
     * METE
     */
    public void mete(String s, int i){
        Celula tmp = primeiro.prox;
        for(int penis = 0; penis < i; penis++){
            tmp = tmp.prox;
        }
        Celula nova = new Celula(s);
        nova.prox = tmp.prox;
        tmp.prox = nova;
    }


    public void gabrielDaOCU(String s){
        primeiro = primeiro.prox;
        while(primeiro!= null){
            primeiro = primeiro.prox;
        }
        primeiro.prox.s = s;
    }
}


