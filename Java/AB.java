import java.util.Scanner;

class No {
    int elemento;
    No esq, dir;

    public No(int x) {
        this(x, null, null);
    }

    public No(int x, No esq, No dir) {
        this.elemento = x;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreBinaria {
    No raiz;

    // CONSTRUTOR
    public ArvoreBinaria(){
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
            i = new No(x);
        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        } else {
            throw new Exception("Erro!");
        }
        return i;
    }

    void addFather(int x) throws Exception {
        if (raiz == null) {
            raiz = new No(x);
        } else if (x < raiz.elemento) {
            inserirPai(x, raiz.esq, raiz);
        } else if (x > raiz.elemento) {
            inserirPai(x, raiz.dir, raiz);
        } else {
            throw new Exception("Erro!");
        }
    }

    void inserirPai(int x, No i, No pai) {
        if (i == null) {
            if (x < pai.elemento) {
                pai.esq = new No(x);
            } else {
                pai.dir = new No(x);
            }
        } else if (x < i.elemento) {
            inserirPai(x, i.esq, i);
        } else if (x > i.elemento) {
            inserirPai(x, i.dir, i);
        } else {
            // Aqui não é necessário lançar uma exceção, pois estamos apenas inserindo um
            // novo elemento na árvore.
        }
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

    int getAltura(No i) {
        if (i == null) {
            return -1;
        } else {
            int alturaEsq = getAltura(i.esq);
            int alturaDir = getAltura(i.dir);
            return Math.max(alturaEsq, alturaDir) + 1;
        }
    }

    No rotEsq(No raiz){
        No raizDir = raiz.dir;
        No raizDirEsq = raizDir.esq;
        raizDir.esq = raiz;
        raiz.dir = raizDirEsq;
        return raizDir;
    }

    No rotDir(No raiz){
        No raizEsq = raiz.esq;
        No raizEsqDir = raizEsq.dir;
        raizEsq.dir = raiz;
        raiz.esq = raizEsqDir;
        return raizEsq;
    }
}

class AB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar elemento");
            System.out.println("2. Adicionar elemento pai");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Caminhar em ordem central");
            System.out.println("5. Caminhar em pré-ordem");
            System.out.println("6. Caminhar em pós-ordem");
            System.out.println("7. Altura da árvore");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser adicionado: ");
                    int elemento = scanner.nextInt();
                    arvore.add(elemento);
                    break;
                case 2:
                    System.out.print("Digite o elemento pai a ser adicionado: ");
                    int elementoPai = scanner.nextInt();
                    try {
                        arvore.addFather(elementoPai);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Digite o elemento a ser buscado: ");
                    int elementoBusca = scanner.nextInt();
                    boolean encontrado = arvore.search(elementoBusca);
                    System.out.println("Elemento encontrado: " + encontrado);
                    break;
                case 4:
                    System.out.println("Caminhando em ordem central:");
                    arvore.walkCenter();
                    break;
                case 5:
                    System.out.println("Caminhando em pré-ordem:");
                    arvore.preWalk();
                    break;
                case 6:
                    System.out.println("Caminhando em pós-ordem:");
                    arvore.postWalk();
                    break;
                case 7:
                    System.out.println("Altura da árvore: " + arvore.altura());
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
