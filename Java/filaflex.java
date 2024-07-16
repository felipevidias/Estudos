import java.util.Scanner;

class Celula {
    public int elemento; 
    public Celula prox;

    public Celula(){
        this(0);
    }

    public Celula(int x){
        this.elemento = x;
        this.prox = null;
    }
}

class Fila {
    public Celula primeiro, ultimo;

    public Fila(){
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserir(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int remover() throws Exception{
        if(primeiro == ultimo)
            throw new Exception("Erro!");
        Celula tmp = primeiro.prox;
        primeiro.prox = primeiro.prox.prox;
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    public void mostrar(){
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
    }

    public int maior(){
        if(primeiro == ultimo)
            throw new RuntimeException("Fila vazia!");
        
        int maior = primeiro.prox.elemento;
        for(Celula i = primeiro.prox.prox; i != null; i = i.prox){
            if(i.elemento > maior){
                maior = i.elemento;
            }
        }
        return maior;
    }

    public int terceiroElemento(){
        if(primeiro == ultimo || primeiro.prox == ultimo)
            throw new RuntimeException("Fila não possui terceiro elemento!");
        
        return primeiro.prox.prox.prox.elemento;
    }

    public int soma(){
        int result = 0;
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            result += i.elemento;
        }
        return result;
    }

    public void inverter() {
        if(primeiro == ultimo)
            return;

        Celula fim = ultimo;
        Celula atual = primeiro.prox;
        Celula anterior = null;

        while (atual != null) {
            Celula proxima = atual.prox;
            atual.prox = anterior;
            anterior = atual;
            atual = proxima;
        }

        primeiro.prox = anterior;
        ultimo = fim;
    }

    int evenAndMult5(Celula atual)
    {
        int count = 0;
        if(atual == null)
            return 0;
        if(atual.elemento % 2 == 0 && atual.elemento % 5 == 0){
            count+= 1;
        }
        return count + evenAndMult5(atual.prox);
    }
}

public class filaflex {
    public static void main(String[] args) {
        Fila fila = new Fila();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir elemento na fila");
            System.out.println("2. Remover elemento da fila");
            System.out.println("3. Mostrar fila");
            System.out.println("4. Mostrar o maior elemento na fila");
            System.out.println("5. Mostrar o terceiro elemento na fila");
            System.out.println("6. Calcular a soma dos elementos na fila");
            System.out.println("7. Inverter a fila");
            System.out.println("8. Contar elementos divisíveis por 2 e 5");
            System.out.println("9. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número que deseja inserir na fila: ");
                    int numeroInserir = scanner.nextInt();
                    fila.inserir(numeroInserir);
                    break;
                case 2:
                    try {
                        int removido = fila.remover();
                        System.out.println("Elemento removido: " + removido);
                    } catch (Exception e) {
                        System.out.println("Erro ao remover elemento: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Fila:");
                    fila.mostrar();
                    System.out.println();
                    break;
                case 4:
                    try {
                        int maior = fila.maior();
                        System.out.println("Maior elemento na fila: " + maior);
                    } catch (Exception e) {
                        System.out.println("Erro ao encontrar o maior elemento: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        int terceiro = fila.terceiroElemento();
                        System.out.println("Terceiro elemento na fila: " + terceiro);
                    } catch (Exception e) {
                        System.out.println("Erro ao encontrar o terceiro elemento: " + e.getMessage());
                    }
                    break;
                case 6:
                    int soma = fila.soma();
                    System.out.println("Soma dos elementos na fila: " + soma);
                    break;
                case 7:
                    fila.inverter();
                    System.out.println("Fila invertida:");
                    fila.mostrar();
                    System.out.println();
                    break;
                case 8:
                    int divisiveis = fila.evenAndMult5(fila.primeiro.prox);
                    System.out.println("Número de elementos divisíveis por 2 e 5 na fila: " + divisiveis);
                    break;
                case 9:
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
