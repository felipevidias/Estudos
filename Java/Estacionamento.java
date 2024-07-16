import java.util.Scanner;
import java.util.Stack;

public class Estacionamento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            if (N == 0 && K == 0)
                break;

            int[][] motoristas = new int[N][2];

            for (int i = 0; i < N; i++) {
                motoristas[i][0] = sc.nextInt(); // Hora de chegada
                motoristas[i][1] = sc.nextInt(); // Hora de saída
            }

            if (podeEstacionar(N, K, motoristas)) {
                System.out.println("Sim");
            } else {
                System.out.println("Nao");
            }
        }

        sc.close();
    }

    private static boolean podeEstacionar(int N, int K, int[][] motoristas) {
        Stack<Integer> estacionamento = new Stack<>();

        for (int i = 0; i < N; i++) {
            int chegada = motoristas[i][0];
            int saida = motoristas[i][1];

            // Remover todos os carros que devem sair antes do carro atual chegar
            while (!estacionamento.isEmpty() && estacionamento.peek() <= chegada) {
                estacionamento.pop();
            }

            // Adiciona o carro atual ao estacionamento
            estacionamento.push(saida);

            // Verifica se a capacidade foi excedida
            if (estacionamento.size() > K) {
                return false;
            }
        }

        return true;
    }
}
