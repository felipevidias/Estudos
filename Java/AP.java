import java.util.Scanner;

class No {
    public int i, j, k;
    public int tamanho = 255;
    public No[] prox;
    public boolean folha;

    public No() {
        this(-1, -1, -1);
    }

    public No(int i, int j, int k) {
        this(i, j, k, false);
    }

    public No(int i, int j, int k, boolean folha) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.folha = folha;

        prox = new No[tamanho];

        for (int l = 0; l < tamanho; l++) {
            prox[l] = null;
        }
    }

    public static int hash(char x) {
        return (int)x;
    }
}

class Patricia {
    No raiz;
    String[] array; // ignorar questão de tamanho do array

    public Patricia() {
        raiz = new No();
        array = null;
    }

    public void setArray(String[] array) throws Exception {
        this.array = array;
        for (int i = 0; i < array.length; i++) {
            inserir(i);
        }
    }

    private String string(No no) {
        return (no == raiz) ? " " : string(no.i, no.j, no.k);
    }

    private String string(int i, int j, int k) {
        return array[i].substring(j, k + 1);
    }

    public void inserir(String s) throws Exception {
        if (array == null) {
            array = new String[] {s};
        } else {
            String[] novoArray = new String[array.length + 1];
            System.arraycopy(array, 0, novoArray, 0, array.length);
            novoArray[array.length] = s;
            array = novoArray;
        }
        inserir(array.length - 1);
    }

    private void inserir(int i) throws Exception {
        inserir(raiz, i, 0);
    }

    private void inserir(No no, int i, int j) throws Exception {
        if (no.prox[array[i].charAt(j)] == null) {
            no.prox[array[i].charAt(j)] = new No(i, j, array[i].length() - 1, true);
        } else {
            String prox = string(no.prox[array[i].charAt(j)]);
            String inserindo = array[i].substring(j);

            int k;
            for (k = 1; k < prox.length() && k < inserindo.length() && prox.charAt(k) == inserindo.charAt(k); k++);
            if (k == prox.length()) {
                if (no.prox[array[i].charAt(j)].folha == true) {
                    throw new Exception("Erro: existe um prefixo de [" + array[i] + "] na árvore");
                } else {
                    inserir(no.prox[array[i].charAt(j)], i, j + k);
                }
            } else if (k == inserindo.length()) {
                throw new Exception("Erro: [" + array[i] + "] é prefixo de outra palavra da árvore");
            } else {
                No novo = new No(i, j, j + k - 1, false);
                novo.prox[prox.charAt(k)] = no.prox[array[i].charAt(j)];
                novo.prox[prox.charAt(k)].j = j + k;
                novo.prox[inserindo.charAt(k)] = new No(i, j + k, array[i].length() - 1, true);
                no.prox[array[i].charAt(j)] = novo;
            }
        }
    }

    public boolean pesquisar(String s) {
        return pesquisar(raiz, s, 0);
    }

    public boolean pesquisar(No no, String s, int cont) {
        if (no.prox[s.charAt(cont)] == null) {
            return false;
        } else {
            String prox = string(no.prox[s.charAt(cont)]);

            int i1, i2;
            for (i1 = 0, i2 = cont; i1 < prox.length() && i2 < s.length() && prox.charAt(i1) == s.charAt(i2); i1++, i2++);

            if (i2 == s.length()) {
                return i1 == prox.length() && no.prox[s.charAt(cont)].folha;
            } else {
                return pesquisar(no.prox[s.charAt(cont)], s, i2);
            }
        }
    }

    public void mostrar() {
        mostrar("", raiz);
    }

    public void mostrar(String s, No no) {
        if (no.folha == true) {
            System.out.println(s + string(no));
        } else {
            for (int i = 0; i < no.prox.length; i++) {
                if (no.prox[i] != null) {
                    mostrar(s + string(no), no.prox[i]);
                }
            }
        }
    }
}

class AP {
    public static void main(String[] args) {
        Patricia patricia = new Patricia();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Inserir palavra");
            System.out.println("2. Pesquisar palavra");
            System.out.println("3. Mostrar todas as palavras");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Para consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite a palavra a ser inserida: ");
                    String palavra = scanner.nextLine();
                    try {
                        patricia.inserir(palavra);
                        System.out.println("Palavra inserida com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir palavra: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Digite a palavra a ser pesquisada: ");
                    String pesquisa = scanner.nextLine();
                    if (patricia.pesquisar(pesquisa)) {
                        System.out.println("Palavra encontrada.");
                    } else {
                        System.out.println("Palavra não encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("Palavras na árvore Patricia:");
                    patricia.mostrar();
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
