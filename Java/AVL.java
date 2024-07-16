import java.util.Scanner;

class No {
    int elemento;
    No esq, dir;
    int altura;

    public No(int x) {
        this(x, null, null);
    }

    public No(int x, No esq, No dir) {
        this.elemento = x;
        this.esq = esq;
        this.dir = dir;
        this.altura = 1; // Altura de um novo nó é 1
    }
}

class ArvoreAVL {
    No raiz;

    // CONSTRUTOR
    public ArvoreAVL() {
        raiz = null;
    }

    // METODOS
    void add(int x) {
        try {
            raiz = inserir(x, raiz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    No inserir(int x, No i) throws Exception {
        if (i == null) {
            return new No(x);
        }

        if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        } else {
            throw new Exception("Erro! Elemento duplicado.");
        }

        i.altura = 1 + Math.max(getAltura(i.esq), getAltura(i.dir));
        return balancear(i);
    }

    No balancear(No i) {
        int balanceamento = getBalanceamento(i);

        if (balanceamento > 1) {
            if (getBalanceamento(i.esq) >= 0) {  // ROTAÇÃO SIMPLES A DIREITA
                i = rotDir(i);
            } else { // ROTAÇÃO DUPLA DIREITA ESQUERDA
                i.esq = rotEsq(i.esq);
                i = rotDir(i);
            }
        } else if (balanceamento < -1) {
            if (getBalanceamento(i.dir) <= 0) {
                i = rotEsq(i);
            } else {
                i.dir = rotDir(i.dir);
                i = rotEsq(i);
            }
        }

        return i;
    }

    int getAltura(No i) {
        return i == null ? 0 : i.altura;
    }

    int getBalanceamento(No i) {
        return i == null ? 0 : getAltura(i.esq) - getAltura(i.dir);
    }

    No rotEsq(No raiz) {
        No raizDir = raiz.dir;
        No raizDirEsq = raizDir.esq;

        raizDir.esq = raiz;
        raiz.dir = raizDirEsq;

        raiz.altura = Math.max(getAltura(raiz.esq), getAltura(raiz.dir)) + 1;
        raizDir.altura = Math.max(getAltura(raizDir.esq), getAltura(raizDir.dir)) + 1;

        return raizDir;
    }

    No rotDir(No raiz) {
        No raizEsq = raiz.esq;
        No raizEsqDir = raizEsq.dir;

        raizEsq.dir = raiz;
        raiz.esq = raizEsqDir;

        raiz.altura = Math.max(getAltura(raiz.esq), getAltura(raiz.dir)) + 1;
        raizEsq.altura = Math.max(getAltura(raizEsq.esq), getAltura(raizEsq.dir)) + 1;

        return raizEsq;
    }

    boolean search(int x) {
        try {
            return buscar(x, raiz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    boolean buscar(int x, No i) throws Exception {
        if (i == null) {
            return false;
        } else if (i.elemento == x) {
            return true;
        } else if (x < i.elemento) {
            return buscar(x, i.esq);
        } else if (x > i.elemento) {
            return buscar(x, i.dir);
        } else {
            throw new Exception("Erro!");
        }
    }

    void walkCenter() {
        caminharCentral(raiz);
    }

    void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }

    void preWalk() {
        caminharPre(raiz);
    }

    void caminharPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + " ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    void postWalk() {
        caminharPos(raiz);
    }

    void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.print(i.elemento + " ");
        }
    }

    int altura() {
        return getAltura(raiz);
    }
}

class ArvoreBinaria {
    No raiz;

    // CONSTRUTOR
    public ArvoreBinaria() {
        raiz = null;
    }

    // METODOS
    void add(int x) {
        raiz = inserir(x, raiz);
    }

    No inserir(int x, No i) {
        if (i == null) {
            return new No(x);
        }

        if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        }
        // Não permite elementos duplicados, mas não lança exceção
        return i;
    }

    boolean search(int x) {
        return buscar(x, raiz);
    }

    boolean buscar(int x, No i) {
        if (i == null) {
            return false;
        } else if (i.elemento == x) {
            return true;
        } else if (x < i.elemento) {
            return buscar(x, i.esq);
        } else if (x > i.elemento) {
            return buscar(x, i.dir);
        }
        return false;
    }

    void walkCenter() {
        caminharCentral(raiz);
    }

    void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }

    void preWalk() {
        caminharPre(raiz);
    }

    void caminharPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + " ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    void postWalk() {
        caminharPos(raiz);
    }

    void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.print(i.elemento + " ");
        }
    }

    int getAltura(No i) {
        if (i == null) {
            return 0;
        }
        return 1 + Math.max(getAltura(i.esq), getAltura(i.dir));
    }

    int altura() {
        return getAltura(raiz);
    }
}

class AVL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar elemento");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Caminhar em ordem central");
            System.out.println("4. Caminhar em pré-ordem");
            System.out.println("5. Caminhar em pós-ordem");
            System.out.println("6. Altura das árvores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser adicionado: ");
                    int elemento = scanner.nextInt();
                    arvoreAVL.add(elemento);
                    arvoreBinaria.add(elemento);
                    break;
                case 2:
                    System.out.print("Digite o elemento a ser buscado: ");
                    int elementoBusca = scanner.nextInt();
                    boolean encontradoAVL = arvoreAVL.search(elementoBusca);
                    boolean encontradoBinaria = arvoreBinaria.search(elementoBusca);
                    System.out.println("Elemento encontrado na AVL: " + encontradoAVL);
                    System.out.println("Elemento encontrado na Binária: " + encontradoBinaria);
                    break;
                case 3:
                    System.out.println("Caminhando em ordem central (AVL):");
                    arvoreAVL.walkCenter();
                    System.out.println("\nCaminhando em ordem central (Binária):");
                    arvoreBinaria.walkCenter();
                    break;
                case 4:
                    System.out.println("Caminhando em pré-ordem (AVL):");
                    arvoreAVL.preWalk();
                    System.out.println("\nCaminhando em pré-ordem (Binária):");
                    arvoreBinaria.preWalk();
                    break;
                case 5:
                    System.out.println("Caminhando em pós-ordem (AVL):");
                    arvoreAVL.postWalk();
                    System.out.println("\nCaminhando em pós-ordem (Binária):");
                    arvoreBinaria.postWalk();
                    break;
                case 6:
                    System.out.println("Altura da árvore AVL: " + arvoreAVL.altura());
                    System.out.println("Altura da árvore Binária: " + arvoreBinaria.altura());
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
