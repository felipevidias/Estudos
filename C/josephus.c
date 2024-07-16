#include <stdio.h>
#include <stdlib.h>

int josephus(int *homens, int tamanho, int salto) {
    int inicio = 0; // Inicializa a variável inicio com 0, representando a posição inicial no círculo
    int vivo = -1; // Inicializa a variável vivo com -1, indicando que ainda não encontramos o sobrevivente

    // Loop para percorrer todas as pessoas no círculo, exceto a última
    for(int i = 0; i < tamanho - 1; i++) {
        // Calcula a próxima posição a ser eliminada usando a fórmula de Josephus
        inicio = (inicio + salto - 1) % (tamanho - i);

        // Loop para encontrar a pessoa a ser eliminada e marcá-la como morta
        int contador = 0;
        for(int j = 0; j < tamanho; j++) {
            if (homens[j] == 1) { // Verifica se a pessoa está viva
                contador++; // Incrementa o contador para contar a posição da pessoa viva
                if (contador == inicio + 1) { // Verifica se encontrou a pessoa a ser eliminada
                    homens[j] = 0; // Marca a pessoa como morta (atribui 0 à sua posição no array)
                    j = tamanho; // Sai do loop após encontrar a pessoa a ser eliminada
                }
            }
        }
    }

    // Loop para encontrar o último sobrevivente
    for(int i = 0; i < tamanho; i++) {
        if(homens[i] == 1) { // Verifica se a pessoa está viva
            vivo = i + 1; // Armazena a posição do sobrevivente (índice + 1)
            i = tamanho; // Sai do loop após encontrar o sobrevivente
        }
    }

    return vivo; // Retorna a posição do último sobrevivente
}


int main(void) {
    int casos, n, k;
    scanf("%d", &casos);
    for(int c = 1; c <= casos; c++) {
        scanf("%d %d", &n, &k);
        int *homens = malloc(n * sizeof(int));
        if(homens == NULL) {
            printf("Erro de alocação de memória\n");
            return 1;
        }
        for(int i = 0; i < n; i++) {
            homens[i] = 1; // 1 vivo, 0 morto
        }
        int vivo = josephus(homens, n, k);
        free(homens);
        printf("Case %d: %d\n", c, vivo);
    }
    return 0;
}
