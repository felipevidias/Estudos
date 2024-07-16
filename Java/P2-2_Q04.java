class No{
    int elemento 
    No esq, dir;
    public No(){
        this(0);
        this.esq = this.dir = null;
    }
    public No(int x){
        this.elemento = x;
        this.esq = this.dir = null;
    }
}

class ArvoreB{
    No raiz; 
    public ArvoreB(){
        raiz  = null;
    }
    // Metodos 
    public void inserir(int x){
        raiz =  inserir(int x, raiz);
    }
    No inserir( int x, No i){
        if( i == null){
            i = new No(x);
        } else if(x < i.elemento){
            i = inserir(x, i.esq);
        } else if(x > i.elemento){
            i = inserir(x, i.dir);
        }
    }
    
    public void criarArvore(int[] array){
        ArvoreB treeAux = new ArvoreB();
        for(int i = 0; i < array.length(); i++){
             treeAux.inserir(array[i]);
        }
    }
    public ArrayList<Integer> treeSort(int[] array){
        criarArvore(array);
        ArrayList<Integer> arrayOrdem = new ArrayList<>();
        ordenarArray(raiz, arrayOrdem);
        return arrayOrdem;
    }
    public void ordenarArray(No i, ArrayList<Integer> arrayOrdem){
        ordenarArray(i.esq, arrayOrdem);
        arrayOrdem.add(i.elemento);
        ordenarArray(i.dir, arrayOrdem);
    }

}