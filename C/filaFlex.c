#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Celula {
    int elemento;
    struct Celula *prox;
} Celula;

Celula *newCelula(int x) {
    Celula *nova = (Celula*)malloc(sizeof(Celula));
    nova->elemento = x;
    nova->prox = NULL;
    return nova;
}

typedef struct Fila {
    Celula *primeiro, *ultimo;
} Fila;

void start(Fila *fila) {
    fila->primeiro = newCelula(-1);
    fila->ultimo = fila->primeiro;
}

void add(Fila *fila, int x) {
    fila->ultimo->prox = newCelula(x);
    fila->ultimo = fila->ultimo->prox;
}

int unqueue(Fila *fila) {
    if (fila->primeiro == fila->ultimo) {
        printf("Erro!");
        exit(1);
    }
    Celula *tmp = fila->primeiro->prox;
    fila->primeiro->prox = tmp->prox;
    int elemento = tmp->elemento;
    free(tmp);
    return elemento;
}

void print(Fila *fila) {
    Celula *i;
    printf("[");
    for (i = fila->primeiro->prox; i != NULL; i = i->prox) {
        printf(" %d ", i->elemento);
    }
    printf("]");
}

int main(void) {
    Fila fila;
    start(&fila);
    add(&fila, 10);
    add(&fila, 20);
    add(&fila, 30);
    printf("FILA ENCADEADA: \n");
    print(&fila);
    printf("\n");
    int elemento = unqueue(&fila);
    printf("UNQUEUE: %d\n", elemento);
    print(&fila);
    printf("\n");
    return 0;
}
