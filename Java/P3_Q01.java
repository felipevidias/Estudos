import java.util.Scanner;

// Classe que representa um nó na Trie
class NoTrie {
    public char elemento;
    public Celula prox;
    public boolean folha;

    // Construtor padrão inicializa com o caractere nulo
    public NoTrie() {
        this('\0');
    }

    // Construtor que inicializa com um caractere específico
    public NoTrie(char elemento) {
        this.elemento = elemento;
        this.prox = null;
        this.folha = false;
    }
}

// Classe que representa uma célula da lista encadeada
class Celula {
    public NoTrie no;
    public Celula prox;

    // Construtor padrão inicializa com um nó e a próxima célula
    public Celula(NoTrie no) {
        this.no = no;
        this.prox = null;
    }
}

// Classe que representa a Trie
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
        if (i == s.length()) {
            no.folha = true;
            return;
        }

        char ch = s.charAt(i);
        NoTrie proximoNo = buscarOuCriarNo(no, ch);
        inserir(s, proximoNo, i + 1);
    }

    private NoTrie buscarOuCriarNo(NoTrie no, char ch) {
        Celula atual = no.prox;
        Celula anterior = null;

        // Percorre a lista encadeada para buscar o nó
        while (atual != null && atual.no.elemento != ch) {
            anterior = atual;
            atual = atual.prox;
        }

        // Se não encontrou o nó, cria um novo
        if (atual == null) {
            NoTrie novoNo = new NoTrie(ch);
            Celula novaCelula = new Celula(novoNo);
            if (anterior == null) {
                no.prox = novaCelula; // Primeira célula da lista
            } else {
                anterior.prox = novaCelula; // Adiciona no final da lista
            }
            return novoNo;
        }

        return atual.no;
    }

    // Pesquisar uma palavra na Trie
    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    private boolean pesquisar(String s, NoTrie no, int i) throws Exception {
        if (i == s.length()) {
            return no.folha;
        }

        char ch = s.charAt(i);
        Celula atual = no.prox;

        // Percorre a lista encadeada para encontrar o nó correspondente ao caractere
        // atual
        while (atual != null && atual.no.elemento != ch) {
            atual = atual.prox;
        }

        if (atual == null) {
            return false; // Não encontrou o nó
        }

        return pesquisar(s, atual.no, i + 1);
    }

    // Mostrar todas as palavras na Trie
    public void mostrar() {
        mostrar("", raiz);
    }

    private void mostrar(String s, NoTrie no) {
        if (no.folha) {
            System.out.println("Palavra: " + s);
        }

        Celula atual = no.prox;
        while (atual != null) {
            mostrar(s + atual.no.elemento, atual.no);
            atual = atual.prox;
        }
    }

    // Mostrar palavras com vogais e mais de 5 caracteres
    public void mostrarComFiltro() {
        mostrarComFiltro("", raiz);
    }

    private void mostrarComFiltro(String s, NoTrie no) {
        if (no.folha && temVogal(s) && s.length() > 5) {
            System.out.println("Palavra (com filtro): " + s);
        }

        Celula atual = no.prox;
        while (atual != null) {
            mostrarComFiltro(s + atual.no.elemento, atual.no);
            atual = atual.prox;
        }
    }

    // Método auxiliar para verificar se uma palavra contém pelo menos uma vogal
    private boolean temVogal(String s) {
        String vogais = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            if (vogais.indexOf(s.charAt(s.length() - 1)) >= 0) {
                return true;
            }
        }
        return false;
    }
}

public class P3_Q01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreTrie trie = new ArvoreTrie();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Inserir palavra");
            System.out.println("2. Pesquisar palavra");
            System.out.println("3. Mostrar todas as palavras");
            System.out.println("4. Mostrar palavras com vogais e mais de 5 caracteres");
            System.out.println("5. Sair");
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
                    System.out.println("Palavras na Trie (com vogais e mais de 5 caracteres):");
                    trie.mostrarComFiltro();
                    break;

                case 5:
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
