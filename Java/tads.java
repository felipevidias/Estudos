import java.util.*;

class Lista
{
    int[] array;
    int n;

    Lista(int tamanho)
    {
        array = new int[tamanho];
        n = 0;
    } // end construtor

    // METODOS
    
    void InserirInicio(int x)
    {
        if(n >= array.length)
        {
          System.out.println("Nao existe mais espaço!");
        } // end if
        for(int i = n; i > 0; i--)
        {
          array[i] = array[i - 1];
        } // end for 
        array[0] = x;
        n++;
    } // end InserirInicio 

    void InserirFim(int x)
    {
        if(n >= array.length)
        {
          System.out.println("Nao existe mais espaço!");
        } // end if
        array[n] = x;
        n++;
    } // end InserirFim

    void Inserir(int x, int pos)
    {
        if(n >= array.length)
        {
          System.out.println("Nao existe mais espaço!");
        } // end if

        for(int i = n; i < pos; i--)
        {   
            array[i] = array[i - 1];
        } // end for 
        array[pos] = x;
        n++;
    } // end Inserir

    int RemoverInicio()
    {
        if(n == 0)
        {
            System.out.println("Array vazio!");
            return -1;
        } // end if 
        int resp = array[0];
        n--;
        for(int i = 1; i < n; i++)
        {
            array[i] = array[i+1];
        } // end for 
        return resp;
    } // end RemoverInicio

    int RemoverFim()
    {
        if(n == 0)
        {
            System.out.println("Array vazio!");
            return -1;
        } // end if 
        int resp = array[n - 1];
        n--;
        return resp;
    } // end 

    int Remover(int pos)
    {
        if(n == 0)
        {
            System.out.println("Array vazio!");
            return -1;
        } // end if 
        int resp = array[pos];
        n--;
        for(int i = 0; i < n; i++)
        {
            array[i] = array[i+1];
        } // end for 
        return resp;
    } // end Remover

    void swap(int j, int i)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp; 
    } // end swap

    void Selecao()
    {
        int min;
        for(int i = 0; i < (n - 1); i++)
        {
            min = i;
            for(int j = i + 1; j <= n; i++) // a ultima comparação sera o = n do <= n 
            {
                if(array[i] > array[j])
                {
                    min = j;
                } // end if
            } // end for
            swap(min, i);
        } // end for
    } // end Selecao

    void Insercao()
    {
        for(int i = 1; i < n; i++)
        {
           int tmp = array[i];
           int j = i - 1;
           while((j >= 0) && (array[j] > tmp))
           {
            array[j + 1] = array[j];
            j--;
           } // end while
           array[j + 1] = tmp;
        } // end for 
    } // end Insercao

    void BubbleSort()
    {

    for(int rep = 0; rep < n - 1; rep++) // repete ele (n - 1) vezes pra ordenar o vetor 
    {
        for(int i = 0; i < n; i++) // repete pra comparar os elementos do arranjo 
        {                          // e por ele na ultima posição  
            int j = i + 1;
            if(array[i] > array[j])
            {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            } // end if 
        } // end for 
    }
        
    } // end BubbleSort

    void insercaoPorCor(int cor, int h)
    {
        for(int i = (h + cor); i < n; i+=h)
        {
            int tmp = array[i];
            int j = i - h;
            while((j>= 0) && (array[j] > tmp))
            {
                array[j + h] = array[j];
                j -= h; 
            } // end while 
            array[j + h] = tmp;
        } // end for
    } // end insercaoPorCor

    void Shellsort()
    {
        int h = 1; 
        do{h = (h*3) + 1;} while (h < n);
        do
        {
        h /= 3;
        for(int cor = 0; cor < h; cor++)
        {
            insercaoPorCor(cor, h);
        } // end for 
        } while(h!= 1); // end while      
    } // end Shellsort

    void Quicksort(int esq, int dir)
    {
        int i = esq, j = dir, pivo = array[(dir + esq) / 2];
        while( i <= j)
        {
            while(array[i] < pivo) // varre primeira metade pra ver se ha valores maiores que o pivo
                i++;
            while(array[j] > pivo) // varre a segunda metade pra ver se ha valores menores que o pivo
                j--;
            
            if(i <= j)
            { swap(i, j); i++; j--; } // troca se a primeira metade tiver um valor maior que o pivo
        } // end while 
        if(esq < j)
            Quicksort(esq, j); // chama recursivamente pra ver a primeira metade
        if(i < dir)
            Quicksort(dir, i); // chama recursivamente pra ver a segunda metade 
    } // end Quicksort
} // end Lista

class Pilha
{
int array[];
int n;
Pilha(int tamanho)
{
    array = new int[tamanho];
    n = 0;
} // end Pilha


// METODOS

void Push(int x)
{
    if(n >= array.length)
    {
        System.out.println("Error");
    } // end if 
    array[n] = x;
    n++;
} // end Push

int Pop()
{
    if(n >= array.length)
    {
        System.out.println("Error");
    } // end if
    int resp = array[n-1];
    n--;
    return resp;
} // end Pop()
} // end Pilha

class Fila
{
    int array[];
    int n;
    Fila(int tamanho)
    {
        array = new int[tamanho];
    } // end Fila 

    // METODOS

    void Insert(int x)
    {
         if(n >= array.length)
         {
            System.out.println("ERROR");
         } // end if 
         array[n] = x;
         n++;
    } // end Insert

    int Remove()
    {
        if(n == 0)
        {
            System.out.println("ERROR");
        } // end if 
        int resp = array[0];
        for(int i = 0; i < (n - 1); i++)
        {
            array[i] = array[i + 1];
        } // end for
        n--;
        return resp;
    } // end Remove
} // end Fila 

public class tads {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        Lista lista = null;
        Pilha pilha = null;
        Fila fila = null;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Testar Lista");
            System.out.println("2. Testar Pilha");
            System.out.println("3. Testar Fila");
            System.out.println("0. Sair");

            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    testarLista();
                    break;
                case 2:
                    testarPilha();
                    break;
                case 3:
                    testarFila();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);
    }

    public static void testarLista() {
        Lista lista = new Lista(6);

        lista.InserirFim(12);
        lista.InserirFim(5);
        lista.InserirFim(20);
        lista.InserirInicio(99);
        lista.InserirInicio(92);
        lista.InserirInicio(100);

        System.out.println("Elementos da lista:");
        for (int i = 0; i < lista.n; i++) {
            System.out.print(lista.array[i] + " ");
        }
        System.out.println();

            // Chamadas para ordenação
            //lista.Shellsort(); // Shell Sort
             lista.Quicksort(0, lista.n - 1); // Quick Sort
    
            System.out.println("Elementos da lista ordenados:");
            for (int i = 0; i < lista.n; i++) {
                System.out.print(lista.array[i] + " ");
            }
            System.out.println();
        }
    

    public static void testarPilha() {
        Pilha pilha = new Pilha(5);

        pilha.Push(10);
        pilha.Push(20);
        pilha.Push(30);

        System.out.println("Elementos da pilha:");
        while (pilha.n > 0) {
            System.out.print(pilha.Pop() + " ");
        }
        System.out.println();
    }

    public static void testarFila() {
        Fila fila = new Fila(5);

        fila.Insert(10);
        fila.Insert(20);
        fila.Insert(30);

        System.out.println("Elementos da fila:");
        while (fila.n > 0) {
            System.out.print(fila.Remove() + " ");
        }
        System.out.println();
    }
}