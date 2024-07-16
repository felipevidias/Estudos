import java.util.Scanner;

class celulaDupla {
    int elemento;
    celulaDupla ant, prox;

    public celulaDupla() {
        this(0);
    }

    public celulaDupla(int x) {
        this.elemento = x;
        this.ant = this.prox = null;
    }
}

class listaDupla {
    celulaDupla primeiro, ultimo;

    public listaDupla() {
        primeiro = new celulaDupla();
        ultimo = primeiro;
    }

    public int tamanho() {
        int tamanho = 0;
        for (celulaDupla i = primeiro.prox; i != null; i = i.prox) {
            tamanho++;
        }
        return tamanho;
    }

    public void mostrar() {
        for (celulaDupla i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }

    public void inserirInicio(int x) {
        celulaDupla tmp = new celulaDupla(x);
        tmp.prox = primeiro.prox; // PULAR NÓ CABEÇA
        tmp.ant = primeiro;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }
        tmp = null;
    }

    public int removerFim() throws Exception {
        if (primeiro == ultimo)
            new Exception("Erro!");
        int elemento = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        return elemento;
    }

    public void inserirFim(int x) {
        ultimo.prox = new celulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }

    public int removerInicio() throws Exception {
        if (primeiro == ultimo)
            new Exception("Erro!");
        celulaDupla tmp = primeiro;
        primeiro = primeiro.prox;
        int elemento = primeiro.elemento;
        tmp.prox = primeiro.ant = null;
        tmp = null;

        return elemento;
    }

    public void inserir(int x, int pos) throws Exception {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            new Exception("Erro!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho - 1) {
            inserirFim(x);
        } else {
            celulaDupla tmp = new celulaDupla(x);
            celulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox);
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.ant.prox = tmp.prox.ant = tmp;
            tmp = i = null;
        }
    }

    public int remover(int pos) throws Exception {
        int tamanho = tamanho();
        int elemento = 0;
        if (primeiro == ultimo) {
            new Exception("Erro!");
        } else if (pos == 0) {
            elemento = removerInicio();
        } else if (pos == tamanho - 1) {
            elemento = removerFim();
        } else {
            celulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            elemento = i.elemento;
            i.ant = i.prox = null;
            i = null;
        }

        return elemento;
    }

    public void inverter() {
        celulaDupla i = primeiro.prox;
        celulaDupla j = ultimo;
        while (i != j && i.ant != j) {
            int tmp = i.elemento;
            i.elemento = j.elemento;
            j.elemento = tmp;
            i = i.prox;
            j = j.ant;
        }
    }

    public void sortAndInvert() {
        int tamanho = tamanho();
        for (celulaDupla i = primeiro.prox; i != null; i = i.prox) {
            celulaDupla min = i;
            for (celulaDupla j = i.prox; j != null; j = j.prox) {
                if (min.elemento > j.elemento) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = i.elemento;
                i.elemento = min.elemento;
                min.elemento = tmp;
            }
        }
        inverter();
    }


}

public class listaDuplaEx01 {
    public static void main(String[] args) {
        listaDupla lista = new listaDupla();
        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir no início");
            System.out.println("2. Inserir no fim");
            System.out.println("3. Inserir em uma posição específica");
            System.out.println("4. Remover do início");
            System.out.println("5. Remover do fim");
            System.out.println("6. Inverter a lista");
            System.out.println("7. Ordenar e inverter a lista");
            System.out.println("8. Mostrar lista");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Insira um valor para inserir no início: ");
                    int valorInicio = sc.nextInt();
                    lista.inserirInicio(valorInicio);
                    break;
                case 2:
                    System.out.print("Insira um valor para inserir no fim: ");
                    int valorFim = sc.nextInt();
                    lista.inserirFim(valorFim);
                    break;
                case 3:
                    System.out.print("Insira um valor: ");
                    int valor = sc.nextInt();
                    System.out.print("Insira a posição para inserir: ");
                    int posicao = sc.nextInt();
                    try {
                        lista.inserir(valor, posicao);
                        System.out.println("Valor inserido com sucesso na posição " + posicao);
                    } catch (Exception e) {
                        System.out.println(
                                "Erro ao inserir valor na posição " + posicao + ": " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        int elementoInicio = lista.removerInicio();
                        System.out.println("Elemento removido do início: " + elementoInicio);
                    } catch (Exception e) {
                        System.out.println(
                                "Erro ao remover elemento do início: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        int elementoFim = lista.removerFim();
                        System.out.println("Elemento removido do fim: " + elementoFim);
                    } catch (Exception e) {
                        System.out.println(
                                "Erro ao remover elemento do fim: " + e.getMessage());
                    }
                    break;
                case 6:
                    lista.inverter();
                    System.out.println("Lista invertida com sucesso.");
                    break;
                case 7:
                    lista.sortAndInvert();
                    System.out.println("Lista ordenada e invertida com sucesso.");
                    break;
                case 8:
                    System.out.println("Lista Dupla:");
                    lista.mostrar();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println(
                            "Opção inválida! Por favor, escolha novamente.");
            }

        } while (escolha != 0);

        sc.close();
    }
}
