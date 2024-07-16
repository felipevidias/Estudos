import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Imovel {
    int pessoas;
    int consumo;
}

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numeroCidade = 1;

        int n;
        do {
            n = sc.nextInt();
            if (n != 0) {
                List<Imovel> imoveis = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    Imovel imovel = new Imovel();
                    imovel.pessoas = sc.nextInt();
                    imovel.consumo = sc.nextInt();
                    imoveis.add(imovel);
                }
                resultados(numeroCidade, imoveis);
                numeroCidade++;
            }
        } while (n != 0);

        sc.close();
    }

    static double consumoMedio(List<Imovel> imoveis) {
        int totalPessoas = 0;
        int totalConsumo = 0;
        for (Imovel imovel : imoveis) {
            totalPessoas += imovel.pessoas;
            totalConsumo += imovel.consumo;
        }
        return (double) totalConsumo / totalPessoas;
    }

    static void ordenarConsumo(List<Imovel> imoveis) {
        for (int i = 0; i < imoveis.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < imoveis.size(); j++) {
                if (imoveis.get(j).consumo < imoveis.get(min).consumo) {
                    min = j;
                }
            }
            Imovel tmp = imoveis.get(i);
            imoveis.set(i, imoveis.get(min));
            imoveis.set(min, tmp);
        }
    }

    static void resultados(int numeroCidade, List<Imovel> imoveis) {
        ordenarConsumo(imoveis);
        System.out.println("Cidade# " + numeroCidade + ":");
        for (Imovel imovel : imoveis) {
            System.out.print(imovel.pessoas + "-" + imovel.consumo + " ");
        }
        System.out.println();
        double media = consumoMedio(imoveis);
        String mediaFormat = String.format("%.2f", media);
        System.out.println("Consumo medio: " + mediaFormat + " m3");
    }
}
