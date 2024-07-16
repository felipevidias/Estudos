class Hash {
    int tamHash;
    int[] tabela;

    // Usar -1 para indicar posição vazia e -2 para indicar posição removida
    private static final int VAZIO = -1;
    private static final int REMOVIDO = -2;

    public Hash() {
        this.tamHash = 7;
        this.tabela = new int[tamHash];
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = VAZIO; // Inicializa com -1 para indicar posição vazia
        }
    }

    public Hash(int x) {
        this.tamHash = x;
        this.tabela = new int[tamHash];
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = VAZIO; // Inicializa com -1 para indicar posição vazia
        }
    }

    // Método hash
    int hash(int x) {
        return x % tamHash;
    }

    // Método rehash (linear probing)
    int rehash(int x, int i) {
        return (x + i) % tamHash;
    }

    // Inserir com tratamento de colisões
    void inserir(int x) throws Exception {
        if (x == VAZIO || x == REMOVIDO) {
            throw new Exception("Valor não pode ser " + x + ", pois é usado para indicar posição vazia ou removida!");
        }
        
        int i = hash(x);
        int tentativas = 0;

        while (tabela[i] != VAZIO && tabela[i] != REMOVIDO && tentativas < tamHash) {
            i = rehash(i, 1); // Rehash linear
            tentativas++;
        }

        if (tentativas < tamHash) {
            tabela[i] = x;
        } else {
            throw new Exception("Tabela de hash cheia! Não é possível inserir o valor " + x);
        }
    }

    // Pesquisar um valor na tabela
    int pesquisar(int x) {
        int i = hash(x);
        int tentativas = 0;

        while (tabela[i] != x && tabela[i] != VAZIO && tentativas < tamHash) {
            i = rehash(i, 1); // Rehash linear
            tentativas++;
        }

        if (tabela[i] == x) {
            return i;
        } else {
            return -1; // Não encontrado
        }
    }

    // Remover um valor da tabela
    void remover(int x) {
        int i = hash(x);
        int tentativas = 0;

        while (tabela[i] != x && tabela[i] != VAZIO && tentativas < tamHash) {
            i = rehash(i, 1); // Rehash linear
            tentativas++;
        }

        if (tabela[i] == x) {
            tabela[i] = REMOVIDO; // Marca a posição como removida
        }
    }

    // Método para exibir a tabela hash
    void exibirTabela() {
        for (int i = 0; i < tamHash; i++) {
            System.out.println("Índice " + i + ": " + tabela[i]);
        }
    }
}

public class rehashtable {

    public static void main(String[] args) {
        try {
            // Cria uma tabela hash com o tamanho padrão (7)
            Hash tabelaHash = new Hash();

            // Insere alguns valores na tabela
            tabelaHash.inserir(10);
            tabelaHash.inserir(20);
            tabelaHash.inserir(15);
            tabelaHash.inserir(7);
            tabelaHash.inserir(3);
            tabelaHash.inserir(8);
            tabelaHash.inserir(1);

            // Exibe a tabela após as inserções
            System.out.println("Tabela após inserções:");
            tabelaHash.exibirTabela();

            // Remove alguns valores
            tabelaHash.remover(15);
            tabelaHash.remover(7);

            // Exibe a tabela após as remoções
            System.out.println("\nTabela após remoções:");
            tabelaHash.exibirTabela();

            // Tenta inserir um valor quando a tabela está cheia
            try {
                tabelaHash.inserir(2);
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Esperado: Tabela de hash cheia
            }

            // Pesquisa alguns valores na tabela
            System.out.println("\nPesquisas na tabela:");
            System.out.println("Índice de 10: " + tabelaHash.pesquisar(10)); // Deve retornar o índice onde 10 está armazenado
            System.out.println("Índice de 15: " + tabelaHash.pesquisar(15)); // Deve retornar -1, pois foi removido
            System.out.println("Índice de 3: " + tabelaHash.pesquisar(3));   // Deve retornar o índice onde 3 está armazenado
            System.out.println("Índice de 8: " + tabelaHash.pesquisar(8));   // Deve retornar o índice onde 8 está armazenado
            System.out.println("Índice de 50: " + tabelaHash.pesquisar(50)); // Deve retornar -1 porque 50 não está na tabela
            System.out.println("Índice de 7: " + tabelaHash.pesquisar(7));   // Deve retornar -1, pois foi removido

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
