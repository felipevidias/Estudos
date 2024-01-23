import java.util.Random;

public class SubstituicaoAleatoria {

    public static String substituirLetras(String texto, char letraOriginal, char letraSubstituta) {
        StringBuilder resultado = new StringBuilder();

        for (char caractere : texto.toCharArray()) {
            if (caractere == letraOriginal) {
                resultado.append(letraSubstituta);
            } else {
                resultado.append(caractere);
            }
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        Random gerador = new Random();
        gerador.setSeed(4); // Configuração da semente para reprodutibilidade

        // Exemplo de entrada
        String[] linhasEntrada = {
            "o rato roeu a roupa do rei de roma",
            "e qwe qwe qwe ewq ewq ewq"
        };

        // Para cada linha de entrada, sorteia duas letras e realiza a substituição
        for (String linha : linhasEntrada) {
            char letraOriginal = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char letraSubstituta = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

            System.out.println("Letras sorteadas: " + letraOriginal + "->" + letraSubstituta);

            // Aplica a substituição e exibe o resultado
            String linhaSubstituida = substituirLetras(linha, letraOriginal, letraSubstituta);
            System.out.println(linhaSubstituida);
        }
    }
}
