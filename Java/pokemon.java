import java.util.*;

class pokemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int i = 0;
        String pokemon;
        String[] arr = new String[n];
        int total = 151;

        sc.nextLine(); // Limpar o buffer

        while (i < n) {
            pokemon = sc.nextLine();
            arr[i] = pokemon;
            i++;
        }

        int count = 0;
        for (int j = 0; j < n - 1; j++) {
            if (!arr[j].equals(arr[j + 1])) {
                count = count + 1;
            }
        }

        int faltam = total - count;
        System.out.println("Falta(m) " + faltam + " pomekon(s).");
        sc.close();
    }
}
