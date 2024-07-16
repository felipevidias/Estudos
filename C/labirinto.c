#include <stdio.h>
#include <stdbool.h>

#define MAX 100

// Função para verificar se a posição é válida para mover
bool eh_valido(char labirinto[MAX][MAX], bool visitado[MAX][MAX], int x, int y, int N, int M) {
    if (x < 0 || y < 0 || x >= N || y >= M) {
        return false;
    }
    if (labirinto[x][y] == '*' || visitado[x][y]) {
        return false;
    }
    return true;
}

// Função de busca em profundidade (DFS)
bool dfs(char labirinto[MAX][MAX], bool visitado[MAX][MAX], int x, int y, int saida_x, int saida_y, int N, int M) {
    // Se atingimos a saída
    if (x == saida_x && y == saida_y) {
        return true;
    }

    // Marca o ponto atual como visitado
    visitado[x][y] = true;

    // Movimentos possíveis: baixo, cima, direita, esquerda
    int movimentos[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // Explora todas as direções
    for (int i = 0; i < 4; i++) {
        int novo_x = x + movimentos[i][0];
        int novo_y = y + movimentos[i][1];

        if (eh_valido(labirinto, visitado, novo_x, novo_y, N, M)) {
            if (dfs(labirinto, visitado, novo_x, novo_y, saida_x, saida_y, N, M)) {
                return true;
            }
        }
    }

    // Desmarca o ponto atual como visitado (retrocede)
    visitado[x][y] = false;

    return false;
}

int main() {
    int N = 5, M = 5;
    char labirinto[MAX][MAX] = {
        {'*', '*', '*', '*', '*'},
        {' ', ' ', ' ', ' ', '*'},
        {'*', '*', '*', ' ', '*'},
        {'*', ' ', ' ', ' ', ' '},
        {'*', '*', '*', '*', '*'}
    };
    bool visitado[MAX][MAX] = {false};

    // Define os pontos de entrada e saída
    int entrada_x = 1, entrada_y = 0;
    int saida_x = 3, saida_y = 4;

    // Verifica se há um caminho
    if (dfs(labirinto, visitado, entrada_x, entrada_y, saida_x, saida_y, N, M)) {
        printf("sim\n");
    } else {
        printf("nao\n");
    }

    return 0;
}
