import java.util.Scanner;

class Celula {
    public int elemento;
    public Celula prox;

    public Celula() {
        this(0);
    }

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Pilha {
    public Celula topo;

    public Pilha() {
        topo = null;
    }

    public void inserir(int x) { // LIFO - last in first out
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    public int remover() throws Exception {
        if (topo == null)
            throw new Exception("Erro!");
        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    public void mostrar() {
        System.out.println("|" + topo.elemento + "| <-- TOPO");
        for (Celula i = topo.prox; i != null; i = i.prox) {
            System.out.println("|" + i.elemento + "|");
        }
    }

    public int soma() {
        int result = 0;
        for (Celula i = topo; i != null; i = i.prox) {
            result += i.elemento;
        }
        return result;
    }

    public int somaR(Celula topo) {
        if (topo == null) {
            return 0;
        } else {
            return topo.elemento += somaR(topo.prox);
        }
    }

    public int maior() {
        int maior = topo.elemento;
        for (Celula i = topo.prox; i != null; i = i.prox) {
            if (i.elemento > maior) {
                maior = i.elemento;
            }
        }
        return maior;
    }

    public int maiorR(Celula topo) {
        if (topo == null) {
            return 0;
        } else if (topo.prox == null) {
            return topo.elemento;
        } else {
            int maior = maiorR(topo.prox);
            if (topo.elemento > maior) {
                return topo.elemento;
            } else {
                return maior;
            }
        }
    }

    public void mostrarInseridos(Celula topo) {
        if (topo != null) {
            mostrarInseridos(topo.prox);
            System.out.println(topo.elemento);
        }
    }

    public void mostrarRemovidos(Celula topo) {
        if (topo != null) {
            System.out.println(topo.elemento);
            mostrarInseridos(topo.prox);
        }
    }
}

public class pilhaflex {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println("1. Inserir elemento na pilha");
            System.out.println("2. Remover elemento da pilha");
            System.out.println("3. Mostrar pilha");
            System.out.println("4. Somar pilha");
            System.out.println("5. Encontrar o maior elemento");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número que deseja inserir: ");
                    int numeroInserir = scanner.nextInt();
                    pilha.inserir(numeroInserir);
                    break;
                case 2:
                    try {
                        int removido = pilha.remover();
                        System.out.println("Elemento removido: " + removido);
                    } catch (Exception e) {
                        System.out.println("Erro ao remover elemento: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Pilha:");
                    pilha.mostrar();
                    System.out.println();
                    break;
                case 4:
                    int soma = pilha.somaR(pilha.topo);
                    System.out.println("Soma dos elementos da pilha: " + soma);
                    break;
                case 5:
                    int maior = pilha.maiorR(pilha.topo);
                    System.out.println("Maior elemento da pilha: " + maior);
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
