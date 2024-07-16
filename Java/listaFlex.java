import java.util.Scanner;

class Celula {
    int elemento;
    Celula prox;

    public Celula() {
        this(0);
    }

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Lista {
    public Celula primeiro, ultimo;

    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public int tamanho() {
        int tamanho = 0;
        Celula atual = primeiro;
        while (atual != null) {
            tamanho++;
            atual = atual.prox;
        }
        return tamanho;
    }

    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        primeiro = tmp;
        primeiro.prox = new Celula();
        Celula aux = primeiro;
        primeiro = primeiro.prox;
        primeiro.prox = aux;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
        aux = null;
    }

    public void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int removerInicio() throws Exception {
        if (primeiro == ultimo)
            new Exception("Erro!");
        Celula tmp = primeiro.prox;
        primeiro.prox = primeiro.prox.prox;
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    public int removerFim() throws Exception {
        if (primeiro == null)
            new Exception("Erro!");
        Celula i;
        for (i = primeiro; i != ultimo; i = i.prox)
            ;
        int elemento = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;
        return elemento;
    }

    public void inserir(int x, int pos) throws Exception {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    public void inserirOrd(int x){
        Celula tmp = new Celula(x);
        if(primeiro.prox == null || primeiro.prox.elemento >= x){
            tmp.prox = primeiro.prox;
            primeiro.prox = tmp;
            if(primeiro == ultimo){
                ultimo = tmp;
            }
    } else{
        Celula atual = primeiro.prox;
        Celula anterior = primeiro;

        while(atual != null && atual.elemento < x){
            anterior = atual; 
            atual = atual.prox;
        }

        tmp.prox = atual;
        anterior.prox = tmp;

        if(atual == null){
            ultimo = tmp;
        }
    }
}

    public int remover(int pos) throws Exception{ 
        int elemento;
        int tamanho = tamanho();
        if(primeiro == ultimo ||  pos < 0 || pos >= tamanho){
            throw new Exception("Erro!");
        } else if(pos == 0){
            elemento = removerInicio();
        } else if(pos == tamanho - 1){
            elemento = removerFim();
        } else{
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
            Celula tmp = i.prox;
            elemento = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }
        return elemento; 
    }

    public void mostrar(){
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.println(i.elemento + " ");
        }
    }

    public int removeSec() throws Exception{
        if(primeiro == ultimo)
            new Exception("Erro!");

        Celula tmp = primeiro.prox.prox;
        int elemento = tmp.elemento;
        primeiro.prox.prox = tmp.prox; // atualizar para o elemento a frente do segundo elemento válido 
        tmp.prox = null;

        return elemento;
    }
}

public class listaFlex {
    public static void main(String args[]) {
        Lista lista = new Lista();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir elemento no início");
            System.out.println("2. Inserir elemento no fim");
            System.out.println("3. Inserir elemento em uma posição específica");
            System.out.println("4. Remover elemento do início");
            System.out.println("5. Remover elemento do fim");
            System.out.println("6. Remover elemento de uma posição específica");
            System.out.println("7. Remover o segundo elemento");
            System.out.println("8. Mostrar lista");
            System.out.println("9. Inserir elemento de forma ordenada");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o elemento a ser inserido no início: ");
                        int inicio = scanner.nextInt();
                        lista.inserirInicio(inicio);
                        break;
                    case 2:
                        System.out.print("Digite o elemento a ser inserido no fim: ");
                        int fim = scanner.nextInt();
                        lista.inserirFim(fim);
                        break;
                    case 3:
                        System.out.print("Digite o elemento a ser inserido: ");
                        int elemento = scanner.nextInt();
                        System.out.print("Digite a posição: ");
                        int posicao = scanner.nextInt();
                        lista.inserir(elemento, posicao);
                        break;
                    case 4:
                        System.out.println("Elemento removido do início: " + lista.removerInicio());
                        break;
                    case 5:
                        System.out.println("Elemento removido do fim: " + lista.removerFim());
                        break;
                    case 6:
                        System.out.print("Digite a posição do elemento a ser removido: ");
                        int pos = scanner.nextInt();
                        System.out.println("Elemento removido da posição " + pos + ": " + lista.remover(pos));
                        break;
                    case 7:
                        System.out.println("Segundo elemento removido: " + lista.removeSec());
                        break;
                    case 8:
                        System.out.println("Lista:");
                        lista.mostrar();
                        int tamanho = lista.tamanho();
                        System.out.println("Quantidade de elementos: " + (tamanho - 1));
                        break;
                    case 9:
                        System.out.print("Digite o elemento a ser inserido de forma ordenada: ");
                        int ordenado = scanner.nextInt();
                        lista.inserirOrd(ordenado);
                        break;
                    case 0:
                        System.out.println("Encerrando o programa.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opcao != 0);

        scanner.close();
    }
}