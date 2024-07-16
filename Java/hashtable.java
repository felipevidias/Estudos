class Hash {
    int tamHash;
    int tamOver;
    int numOver;
    int[] table;

    public Hash() {
        this.tamHash = 7;
        this.tamOver = 3;
        this.numOver = 0;
        this.table = new int[tamHash + tamOver];
        for (int i = 0; i < table.length; i++) {
            table[i] = -1; // Usar -1 para indicar posição vazia
        }
    }

    public Hash(int x) {
        this.tamHash = x;
        this.tamOver = 3;
        this.numOver = 0;
        this.table = new int[tamHash + tamOver];
        for (int i = 0; i < table.length; i++) {
            table[i] = -1; // Usar -1 para indicar posição vazia
        }
    }

    // Método hash
    int hash(int x) {
        return x % tamHash;
    }
    // Método rehash
    int rehash(int x){
        return ++x % 
    }

    // Método inserir
    void inserir(int x) throws Exception {
        int i = hash(x);
        if (x == -1) {
            throw new Exception("Valor inválido!");
        } else if (table[i] == -1) {
            table[i] = x;
        } else if (table[i] == x) {
            throw new Exception("Erro! Valor já presente.");
        } else if (numOver < tamOver) {
            boolean inserted = false;
            for (int j = 0; j < tamOver; j++) {
                if (table[tamHash + j] == -1) {
                    table[tamHash + j] = x;
                    numOver++;
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                throw new Exception("Erro! Área de overflow cheia.");
            }
        } else {
            throw new Exception("Erro! Área de overflow cheia.");
        }
    }

    // Método pesquisar
    int pesquisar(int x) {
        int i = hash(x);
        if (table[i] == x) {
            return i;
        } else {
            for (int j = 0; j < tamOver; j++) {
                if (table[tamHash + j] == x) {
                    return tamHash + j;
                }
            }
        }
        return -1; // Retorna -1 se não encontrado
    }

    // Método remover
    void remover(int x) throws Exception {
        int i = hash(x);
        if (table[i] == x) {
            // Se o valor estiver na posição principal
            table[i] = -1;
        } else {
            boolean found = false;
            // Procurar na área de overflow
            for (int j = 0; j < tamOver; j++) {
                if (table[tamHash + j] == x) {
                    table[tamHash + j] = -1;
                    numOver--;
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new Exception("Erro! Valor não encontrado.");
            }
        }
    }
}

class hashtable {
    public static void main(String[] args) {
        try {
            // Criar uma tabela hash com tamanho padrão
            Hash hashTable = new Hash();

            // Inserir elementos na tabela hash
            System.out.println("Inserindo valores na tabela hash:");
            hashTable.inserir(10);
            hashTable.inserir(20);
            hashTable.inserir(15);
            hashTable.inserir(7);
            hashTable.inserir(27);
            hashTable.inserir(37);

            // Mostrar estado atual da tabela
            System.out.println("\nEstado atual da tabela hash:");
            mostrarTabela(hashTable);

            // Pesquisar elementos na tabela hash
            System.out.println("\nPesquisando valores na tabela hash:");
            int[] valoresParaPesquisar = {10, 15, 30};
            for (int valor : valoresParaPesquisar) {
                int indice = hashTable.pesquisar(valor);
                if (indice != -1) {
                    System.out.println("Valor " + valor + " encontrado no índice " + indice);
                } else {
                    System.out.println("Valor " + valor + " não encontrado na tabela.");
                }
            }

            // Remover elementos da tabela hash
            System.out.println("\nRemovendo valores da tabela hash:");
            int[] valoresParaRemover = {15, 27};
            for (int valor : valoresParaRemover) {
                hashTable.remover(valor);
                System.out.println("Valor " + valor + " removido.");
            }

            // Mostrar estado final da tabela
            System.out.println("\nEstado final da tabela hash:");
            mostrarTabela(hashTable);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Método auxiliar para mostrar a tabela hash
    public static void mostrarTabela(Hash hashTable) {
        System.out.println("Tabela Hash Principal:");
        for (int i = 0; i < hashTable.tamHash; i++) {
            System.out.println("Índice " + i + ": " + (hashTable.table[i] != -1 ? hashTable.table[i] : "Vazio"));
        }
        System.out.println("Área de Overflow:");
        for (int i = 0; i < hashTable.tamOver; i++) {
            System.out.println("Índice " + (hashTable.tamHash + i) + ": " + (hashTable.table[hashTable.tamHash + i] != -1 ? hashTable.table[hashTable.tamHash + i] : "Vazio"));
        }
    }
}
