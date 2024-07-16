import java.util.Scanner;

class NoTrie {
    public char elemento;
    public final int tamanho = 256; // Tamanho do alfabeto
    public NoTrie[] prox;
    public boolean folha;

    // Construtor padrão inicializa com o caractere nulo
    public NoTrie() {
        this('\0');
    }

    // Construtor que inicializa com um caractere específico
    public NoTrie(char elemento) {
        this.elemento = elemento;
        this.prox = new NoTrie[tamanho];
        this.folha = false;
    }
}

class ArvoreTrie {
    private NoTrie raiz;

    public ArvoreTrie() {
        raiz = new NoTrie();
    }

    // Inserir uma palavra na Trie
    public void inserir(String s) throws Exception {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, NoTrie no, int i) throws Exception {
        if (no.prox[s.charAt(i)] == null) {
            no.prox[s.charAt(i)] = new NoTrie(s.charAt(i));
        }

        if (i == s.length() - 1) {
            no.prox[s.charAt(i)].folha = true;
        } else {
            inserir(s, no.prox[s.charAt(i)], i + 1);
        }
    }

    // Pesquisar uma palavra na Trie
    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    private boolean pesquisar(String s, NoTrie no, int i) throws Exception {
        if (no.prox[s.charAt(i)] == null) {
            return false;
        } else if (i == s.length() - 1) {
            return no.prox[s.charAt(i)].folha;
        } else {
            return pesquisar(s, no.prox[s.charAt(i)], i + 1);
        }
    }

    // Mostrar todas as palavras na Trie
    public void mostrar() {
        mostrar("", raiz);
    }

    private void mostrar(String s, NoTrie no) {
        if (no.folha) {
            System.out.println("Palavra: " + s);
        }

        for (int i = 0; i < no.prox.length; i++) {
            if (no.prox[i] != null) {
                mostrar(s + no.prox[i].elemento, no.prox[i]);
            }
        }
    }
}

public class arvoretrie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreTrie trie = new ArvoreTrie();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Inserir palavra");
            System.out.println("2. Pesquisar palavra");
            System.out.println("3. Mostrar todas as palavras");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consome o caractere de nova linha

            switch (choice) {
                case 1:
                    System.out.print("Digite a palavra para inserir: ");
                    String palavraInserir = scanner.nextLine();
                    try {
                        trie.inserir(palavraInserir);
                        System.out.println("Palavra inserida com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir a palavra: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Digite a palavra para pesquisar: ");
                    String palavraPesquisar = scanner.nextLine();
                    try {
                        boolean encontrada = trie.pesquisar(palavraPesquisar);
                        if (encontrada) {
                            System.out.println("Palavra encontrada.");
                        } else {
                            System.out.println("Palavra não encontrada.");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao pesquisar a palavra: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Palavras na Trie:");
                    trie.mostrar();
                    break;

                case 4:
                    running = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
