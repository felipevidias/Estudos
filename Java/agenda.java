import java.util.Scanner;

class Contato {
    public String nome;
    public String telefone;
    public String email;
    public String cpf;

    public Contato() {
        this.nome = "";
        this.telefone = "";
        this.email = "";
        this.cpf = "";
    }

    public Contato(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public void mostrar() {
        System.out.println("Nome:" + this.nome);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("E-mail: " + this.email);
        System.out.println("CPF: " + this.cpf);
    }
}

class Celula {
    Contato contato;
    Celula prox;

    public Celula() {
        this.contato = new Contato();
        this.prox = null;
    }

    public Celula(Contato x) {
        this.contato = x;
        this.prox = null;
    }
}

class Lista {
    Celula primeiro, ultimo;

    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public int tamanho() {
        int tamanho = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            tamanho++;
        }
        return tamanho;
    }

    public void inserirFim(Contato x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public Contato removerFim() throws Exception {
        int tamanho = tamanho();
        if (primeiro == ultimo)
            throw new Exception("Erro!");
        Celula i = primeiro;
        for (int j = 0; j < tamanho - 1; j++, i = i.prox) ;
        Celula tmp = ultimo;
        Contato elemento = tmp.contato;
        ultimo = i;
        ultimo.prox = null;
        i = null;
        return elemento;
    }

    public void inserirInicio(Contato x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro;
        primeiro = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    public Contato removerInicio() throws Exception {
        if (primeiro == ultimo)
            throw new Exception("Erro!");
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        Contato elemento = tmp.contato;
        tmp = null;
        return elemento;
    }

    public void inserir(int pos, Contato x) throws Exception {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox) ;
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = null;
            i = null;
        }
    }

    public Contato remover(int pos) throws Exception {
        int tamanho = tamanho();
        Contato elemento;
        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro!");
        } else if (pos == 0) {
            elemento = removerInicio();
        } else if (pos == tamanho) {
            elemento = removerFim();
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox) ;
            Celula tmp = i.prox;
            elemento = tmp.contato;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = null;
        }
        return elemento;
    }

    public boolean searchCont(String nome) {
        boolean result = false;
        for (Celula i = primeiro; i != null; i = i.prox) {
            if (i.contato.nome.equalsIgnoreCase(nome)) {
                result = true;
                break;
            }
        }
        return result;
    }
}

class No {
    char inicial;
    Lista contatos;
    No esq, dir;

    public No(char c, Lista cont) {
        this(c, cont, null, null);
    }

    public No(char c, Lista cont, No esq, No dir) {
        this.inicial = c;
        this.contatos = cont;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreContatos {
    No raiz;

    public ArvoreContatos() {
        raiz = null;
    }

    public boolean search(char x) {
        return busca(x, raiz);
    }

    public boolean busca(char x, No i) {
        if (i == null) {
            return false;
        } else if (x == i.inicial) {
            return true;
        } else if (x < i.inicial) {
            return busca(x, i.esq);
        } else if (x > i.inicial) {
            return busca(x, i.dir);
        } else {
            return false;
        }
    }

    public void insert(char x) {
        raiz = inserir(x, raiz);
    }

    public No inserir(char x, No i) {
        if (i == null) {
            i = new No(x, new Lista(), null, null);
        } else if (x < i.inicial) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.inicial) {
            i.dir = inserir(x, i.dir);
        }
        return i;
    }

    public boolean buscaNome(Lista contatos, String nome) {
        return contatos.searchCont(nome);
    }

    public boolean searchInitial(char initial, String nome) {
        return buscaInicial(initial, nome, raiz);
    }
    
    public boolean buscaInicial(char initial, String nome, No i) {
        if (i == null) {
            return false;
        }
    
        if (buscaNome(i.contatos, nome)) {
            // Nome encontrado, mostrando informações do contato
            System.out.println("Contato encontrado pelo nome: " + nome);
            for (Celula c = i.contatos.primeiro.prox; c != null; c = c.prox) {
                if (c.contato.nome.equalsIgnoreCase(nome)) {
                    c.contato.mostrar();
                    return true;
                }
            }
        }
    
        if (initial < i.inicial) {
            return buscaInicial(initial, nome, i.esq);
        } else if (initial > i.inicial) {
            return buscaInicial(initial, nome, i.dir);
        } else {
            return buscaInicial(initial, nome, i.esq) || buscaInicial(initial, nome, i.dir);
        }
    }
    
}

public class agenda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreContatos arvoreContatos = new ArvoreContatos();

        Contato contato1 = new Contato("João", "123456789", "joao@email.com", "12345678901");
        Contato contato2 = new Contato("Marcos", "987654321", "marcos   @email.com", "98765432109");

        arvoreContatos.insert('J');
        arvoreContatos.raiz.contatos.inserirFim(contato1);
        arvoreContatos.insert('M');
        arvoreContatos.raiz.contatos.inserirFim(contato2);

        System.out.print("Digite um nome para buscar na agenda: ");
        String nomeBusca = scanner.nextLine();

        if (arvoreContatos.searchInitial(nomeBusca.charAt(0), nomeBusca)) {
            System.out.println("Contato encontrado pelo nome: " + nomeBusca);
        } else {
            System.out.println("Contato não encontrado pelo nome: " + nomeBusca);
        }

        System.out.print("Digite uma inicial para buscar na agenda: ");
        char inicialBusca = scanner.nextLine().charAt(0);

        if (arvoreContatos.search(inicialBusca)) {
            System.out.println("Contatos encontrados pela inicial: " + inicialBusca);
        } else {
            System.out.println("Nenhum contato encontrado pela inicial: " + inicialBusca);
        }
    }
}