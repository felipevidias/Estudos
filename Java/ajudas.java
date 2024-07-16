// **CÓDIGO EM C**

// Função para verificar se um número é primo
bool isPrimo(int n){if(n<2)return false;for(int i=2;i*i<=n;i++){if(n%i==0)return false;}return true;}

// Função para encontrar o próximo número primo maior que o atual
int proxPrimo(int atual){int n=atual+1;while(!isPrimo(n)){n++;}return n;}

// Estrutura de dados para ordenar em C
typedef struct{char nome[50];int idade;}Duende;

// Função de comparação para ordenar 'Duende' em C
int compareTo(const void*a,const void*b){Duende*a1=(Duende*)a;Duende*b1=(Duende*)b;int resp=b1->idade-a1->idade;if(resp==0)resp=strcmp(a1->nome,b1->nome);return resp;}

// Ordenação usando qsort
void ordenarDuendes(Duende*time,int n){qsort(time,n,sizeof(Duende),compareTo);}

// Função para inverter uma string
void reverseString(char*str){int len=strlen(str);for(int i=0;i<len/2;i++){char temp=str[i];str[i]=str[len-1-i];str[len-1-i]=temp;}}

// Função para verificar se uma string é um palíndromo
bool isPalindrome(char*str){int len=strlen(str);for(int i=0;i<len/2;i++){if(str[i]!=str[len-1-i]){return false;}}return true;}

// Função para buscar um elemento em um vetor
int buscarElemento(int arr[],int n,int chave){for(int i=0;i<n;i++){if(arr[i]==chave){return i; // Retorna o índice do elemento encontrado
}}return-1; // Retorna -1 se o elemento não for encontrado
}

// Função de comparação para qsort em C
int comparar(const void*a,const void*b){return(*(int*)a-*(int*)b);}

// Função para calcular o MDC usando o algoritmo de Euclides
int calcularMDC(int a,int b){while(b!=0){int temp=b;b=a%b;a=temp;}return a;}

// Função para calcular o MMC
int calcularMMC(int a,int b){return(a*b)/calcularMDC(a,b);}

// Função para ler um arquivo
void lerArquivo(const char*nomeArquivo){FILE*file=fopen(nomeArquivo,"r");if(file==NULL){printf("Erro ao abrir o arquivo\n");return;}

char linha[100];while(fgets(linha,sizeof(linha),file)){printf("%s",linha); // Imprime cada linha do arquivo
}

fclose(file);}

// Função para escrever em um arquivo
void escreverArquivo(const char*nomeArquivo,const char*conteudo){FILE*file=fopen(nomeArquivo,"w");if(file==NULL){printf("Erro ao abrir o arquivo\n");return;}

fprintf(file,"%s\n",conteudo);fclose(file);}

// **CÓDIGO EM JAVA**

import java.util.*;

// Classe para ilustrar a ordenação em Java
class Duende implements Comparable<Duende> {
    String nome;
    int idade;

    public Duende(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public int compareTo(Duende outro) {
        int compare = Integer.compare(outro.idade, this.idade);
        if (compare == 0) {
            compare = this.nome.compareTo(outro.nome);
        }
        return compare;
    }

    @Override
    public String toString() {
        return nome + " - " + idade;
    }

}

    // Função para inverter uma string em Java
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Função para verificar se uma string é um palíndromo em Java
    public static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Função para buscar um elemento em uma lista em Java
    public static int buscarElemento(List<Integer> lista, int chave) {
        return lista.indexOf(chave); // Retorna o índice do elemento ou -1 se não encontrado
    }

    // Função para ordenar uma lista de 'Duende' em Java
    public static void ordenarDuendes(List<Duende> time) {
        time.sort((b, a) -> {
            int compare = Integer.compare(a.idade, b.idade);
            if (compare == 0)
                compare = a.nome.compareTo(b.nome);
            return compare;
        });
    }

    // Função para calcular o MDC usando o algoritmo de Euclides em Java
    public static int calcularMDC(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Função para calcular o MMC em Java
    public static int calcularMMC(int a, int b) {
        return (a * b) / calcularMDC(a, b);
    }

    // Função para ler um arquivo em Java
    public static void lerArquivo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha); // Imprime cada linha do arquivo
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo");
            e.printStackTrace();
        }
    }

    // Função para escrever em um arquivo em Java
public static void escreverArquivo(String nomeArquivo, String conteudo) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
        bw.write(conteudo + "\n");
    } catch (IOException e) {
        System.out.println("Erro ao abrir o arquivo");
        e.printStackTrace();
    }
}
