#include <stdio.h>
#include <stdlib.h>

int main()
{
    while (1)
    {
        int N, P;
        scanf("%d %d", &N, &P);
        if (N == 0 && P == 0)
            break; // condição de parada

        // Matriz para armazenar as pilhas
        int pilhas[P][N];
        int tamanho_pilha[P];

        // Lendo as pilhas
        for (int i = 0; i < P; i++)
        {
            int Q;
            scanf("%d", &Q);
            tamanho_pilha[i] = Q;
            for (int j = 0; j < Q; j++)
            {
                scanf("%d", &pilhas[i][j]);
            }
        }

        int desempilhados = 0;
        int caixa_encontrada = 0;

        // Procurar a caixa 1 e calcular as caixas que precisam ser desempilhadas
        for (int i = 0; i < P; i++)
        {
            for (int j = tamanho_pilha[i] - 1; j >= 0; j--)
            {
                if (pilhas[i][j] == 1)
                {
                    caixa_encontrada = 1;
                    break;
                }
                else
                {
                    desempilhados++;
                }
            }
            if (caixa_encontrada)
                break;
        }

        printf("%d\n", desempilhados);
    }

    return 0;
}
