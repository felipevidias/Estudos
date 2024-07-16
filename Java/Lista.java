import java.util.*;

class Lista {
    int[] array;
    int n;

    Lista(int tamanho) {
        array = new int[tamanho];
        n = 0;
    }

    void InserirInicio(int x) {
        if (n >= array.length) {
            System.out.println("Lista cheia. Não é possível inserir no início.");
            return;
        }

        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = x;
        n++;
    }

    void InserirFim(int x) {
        if (n >= array.length) {
            System.out.println("Lista cheia. Não é possível inserir no fim.");
            return;
        }

        array[n] = x;
        n++;
    }   

    void Inserir(int x, int pos) {
        if (n >= array.length || pos < 0 || pos > n) {
            System.out.println("Posição inválida para inserção.");
            return;
        }

        for (int i = n; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = x;
        n++;
    }

    int RemoverInicio() {
        if (n == 0) {
            System.out.println("Lista vazia. Não é possível remover do início.");
            return -1;
        }

        int resp = array[0];
        n--;
        for (int i = 1; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    int RemoverFim() {
        if (n == 0) {
            System.out.println("Lista vazia. Não é possível remover do fim.");
            return -1;
        }

        return array[--n];
    }

    int Remover(int pos) {
        if (n == 0 || pos < 0 || pos >= n) {
            System.out.println("Posição inválida para remoção.");
            return -1;
        }

        int resp = array[pos];
        n--;

        for (int i = pos; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    void Mostrar() {
        if(n <= 0)
        {
            System.out.println("Lista vazia.");
        } // end if
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    } 

    int Somar()
    {
        int soma = 0;

        for(int i = 0; i < n; i++)
        {
            soma += array[i];
        } // end for
        return soma;
    } // end Somar

    int Maior()
    {
      int maior = array[0];
        for(int i = 1; i < n; i++)
        {
            if(array[i] > maior)
            {
                maior = array[i];
            } // end if 
        } // end for
        return maior;
    } // end maior

    void Inverter()
    {
        int i = 0;
        int newN = n-1;
        while(i < newN)
        {
            int temp = array[i];
            array[i] = array[newN];
            array[newN] = temp;
            i++;
            newN--;
        } // end while
    } // end Inverter

    void Menu() {
        Scanner sc = new Scanner(System.in);
        int escolha = 0;

        do {
            System.out.println("1 - Inserir Inicio");
            System.out.println("2 - Inserir Fim");
            System.out.println("3 - Inserir");
            System.out.println("4 - Remover Inicio");
            System.out.println("5 - Remover Fim");
            System.out.println("6 - Remover");
            System.out.println("7 - Mostrar");
            System.out.println("8 - Somar elementos da fila");
            System.out.println("9 - Maior elemento da fila");
            System.out.println("10 - Inverter elementos da fila");
            System.out.println("11 - SAIR");
            System.out.print("ESCOLHA UMA OPCAO: ");
            escolha = sc.nextInt();
            System.out.println();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o valor a ser inserido no início:");
                    int valorInicio = sc.nextInt();
                    InserirInicio(valorInicio);
                    break;
                case 2:
                    System.out.println("Digite o valor a ser inserido no fim:");
                    int valorFim = sc.nextInt();
                    InserirFim(valorFim);
                    break;
                case 3:
                    System.out.println("Digite o valor a ser inserido:");
                    int valorInserir = sc.nextInt();
                    System.out.println("Digite a posição para inserção:");
                    int posInserir = sc.nextInt();
                    Inserir(valorInserir, posInserir);
                    break;
                case 4:
                    System.out.println("Removendo do início...");
                    RemoverInicio();
                    break;
                case 5:
                    System.out.println("Removendo do fim...");
                    RemoverFim();
                    break;
                case 6:
                    System.out.println("Digite a posição para remoção:");
                    int posRemover = sc.nextInt();
                    Remover(posRemover);
                    break;
                case 7:
                    System.out.println("Elementos da lista:");
                    Mostrar();
                    break;
                case 8:
                    int soma = Somar();
                    System.out.println("Soma dos elementos: " + soma);
                break;
                case 9:
                    int maior = Maior();
                    System.out.println("Maior elemento do arranjo: " + maior);
                break;
                case 10:
                    Inverter();
                break;
                case 11:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 8);

        sc.close();
    }

    public static void main(String[] args) {
        Lista lista = new Lista(10); // Tamanho inicial da lista
        lista.Menu();
    }
}
