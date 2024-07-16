class NoAN{
    public boolean cor;
    public int elemento;
    public NoAN esq,dir;

    public NoAN(){
        this(-1);
    }
    public NoAN(int elemento){
        this(elemento, null, null);
    }
    public NoAN(int elemento, boolean cor){
        this(elemento, cor, null, null);
    }
    public NoAN(int elemento, boolean cor, NoAN esq, NoAN dir){
        this.cor = cor;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}
    // CONSTRUTOR
class ArvoreAN{
    public NoAN raiz;
    public ArvoreAN(){
        this.raiz = null;
    }

    // METODOS

}