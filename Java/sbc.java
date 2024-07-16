import java.util.ArrayList;
import java.util.Scanner;

class Processo {
    int tempo;
    int ciclos;

    public Processo(int t, int c) {
        this.tempo = t;
        this.ciclos = c;
    }
}

class sbc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            ArrayList<Processo> processos = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int t = sc.nextInt();
                int c = sc.nextInt();
                Processo p = new Processo(t, c);
                processos.add(p);
            }

            // Ordena os processos pelo tempo de chegada (tempo) e depois pela duração (ciclos)
            processos.sort((a, b) -> {
                int compare = a.tempo - b.tempo;
                if (compare == 0) compare = a.ciclos - b.ciclos;
                return compare;
            });

            int currentTime = 0;
            int totalWaitTime = 0;

            for (int i = 0; i < processos.size(); i++) {
                Processo p = processos.get(i);
                if (currentTime < p.tempo) {
                    currentTime = p.tempo;
                }
                totalWaitTime += (currentTime - p.tempo);
                currentTime += p.ciclos;
            }

            System.out.println(totalWaitTime);
        }

        sc.close();
    }
}
