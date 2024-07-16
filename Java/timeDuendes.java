import java.util.ArrayList;
import java.util.Scanner;

class Duende{
    String nome;
    int idade;
    public Duende(){
        this.nome = "";
        this.idade = 0;
    }
    public void setNome(String s){
        this.nome = s;
    }
    public String getNome(){
        return this.nome;
    }
    public void setIdade(int x){
        this.idade = x;
    }
    public int getIdade(){
        return this.idade;
    }

    public String toString() {
        return nome + " " + idade;
    }
}

class timeDuendes{
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = 0;
    n = sc.nextInt();
    String nome = "";
    int idade = 0;
    ArrayList <Duende> time = new ArrayList<>();
    for(int i = 0; i < n; i++){
        Duende duende = new Duende();
        nome = sc.next();
        idade = sc.nextInt();
        duende.setNome(nome);
        duende.setIdade(idade);
        time.add(duende);
    }

    time.sort((b, a) -> {
        int compare = a.idade - b.idade;
        if (compare == 0) compare = a.nome.compareTo(b.nome);
        return compare;
    });

    ArrayList <Duende> lideres = new ArrayList<>();
    ArrayList <Duende> entregadores = new ArrayList<>();
    ArrayList <Duende> pilotos = new ArrayList<>();
    for(int i = 0; i < n/3; i++){
        lideres.add(time.get(i));
    }
    for(int j = 0; j < n/3; j++){
        entregadores.add(time.get(j + (n / 3)));
    }
    for(int k = 0; k < n/3; k++){
        pilotos.add(time.get(k + 2*(n/3)));
    }
    int count = 1;
    for(int i = 0; i < n/3; i++){
        System.out.println("Time " + count); count++;
        System.out.println(lideres.get(i));
        System.out.println(entregadores.get(i));
        System.out.println(pilotos.get(i));
        System.out.println();
    }
    
}
}