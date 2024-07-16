#include <stdio.h>
#include <stdlib.h>

typedef struct Celula {
    int numero;
    struct Celula *prox;
} Celula;

typedef struct CelulaMatriz {
    int numero;
    struct CelulaMatriz *prox, *ant;
    struct CelulaMatriz *inf, *sup;
} CelulaMatriz;

typedef struct No {
    int numero;
    struct No *esq, *dir;
} No;

// Função para verificar se um valor está presente na matriz
int estaNaMatriz(CelulaMatriz *inicio, int valor) {
    CelulaMatriz *linha = inicio;
    while (linha != NULL) {
        CelulaMatriz *coluna = linha;   
        while (coluna != NULL) {
            if (coluna->numero == valor) {
                return 1;
            }
            coluna = coluna->prox;
        }
        linha = linha->inf;
    }
    return 0;
}
// Função para percorrer a árvore em ordem decrescente e encontrar valores repetidos
void percorrerArvore(No *raiz, CelulaMatriz *inicio, Celula **lista) {
    if (raiz == NULL) {
        return;
    }
    // Primeiro percorre a subárvore direita
    percorrerArvore(raiz->dir, inicio, lista);
    // Verifica se o valor está na matriz
    if (estaNaMatriz(inicio, raiz->numero)) {
        // Insere no início da lista para manter a ordem decrescente
        Celula *novo = (Celula *)malloc(sizeof(Celula));
        novo->numero = raiz->numero;
        novo->prox = *lista;
        *lista = novo;
    }
    // Depois percorre a subárvore esquerda
    percorrerArvore(raiz->esq, inicio, lista);
}
Celula* encontrarRepetidos(No* raiz, CelulaMatriz* inicio) {
    Celula *lista = NULL;
    percorrerArvore(raiz, inicio, &lista);
    return lista;
}