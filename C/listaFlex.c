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

typedef struct Lista {
    Celula *primeiro, *ultimo;
} Lista;

void start(Lista *lista) {
    lista->primeiro = NULL; // Inicializa a lista como vazia
    lista->ultimo = NULL;
}

void addInitial(Lista *lista, int x) {
    Celula *tmp = newCelula(x);
    if (lista->primeiro == NULL) {
        lista->ultimo = tmp;
    } else {
        tmp->prox = lista->primeiro;
    }
    lista->primeiro = tmp;
}

void addEnd(Lista *lista, int x) {
    Celula *tmp = newCelula(x);
    if (lista->primeiro == NULL) {
        lista->primeiro = tmp;
    } else {
        lista->ultimo->prox = tmp;
    }
    lista->ultimo = tmp;
}

int removeInitial(Lista *lista) {
    if (lista->primeiro == NULL) {
        printf("Erro: Lista vazia!\n");
        exit(EXIT_FAILURE);
    }
    Celula *tmp = lista->primeiro;
    int elemento = tmp->elemento;
    lista->primeiro = lista->primeiro->prox;
    if (lista->primeiro == NULL) {
        lista->ultimo = NULL;
    }
    free(tmp);
    return elemento;
}

int removeEnd(Lista *lista) {
    if (lista->primeiro == NULL) {
        printf("Erro: Lista vazia!\n");
        exit(EXIT_FAILURE);
    }
    int elemento;
    Celula *tmp = lista->primeiro;
    if (tmp->prox == NULL) { // Se houver apenas um elemento na lista
        elemento = tmp->elemento;
        free(tmp);
        lista->primeiro = NULL;
        lista->ultimo = NULL;
        return elemento;
    }
    while (tmp->prox->prox != NULL) {
        tmp = tmp->prox;
    }
    elemento = tmp->prox->elemento;
    free(tmp->prox);
    tmp->prox = NULL;
    lista->ultimo = tmp;
    return elemento;
}

int size(Lista *lista) {
    int result = 0;
    Celula *i = lista->primeiro;
    while (i != NULL) {
        result++;
        i = i->prox;
    }
    return result;
}

void inserir(Lista *lista, int x, int pos) {
    int tamanho = size(lista);
    if (pos < 0 || pos > tamanho) {
        printf("Erro: Posição inválida!\n");
        exit(EXIT_FAILURE);
    }
    if (pos == 0) {
        addInitial(lista, x);
    } else if (pos == tamanho) {
        addEnd(lista, x);
    } else {
        Celula *tmp = newCelula(x);
        Celula *i = lista->primeiro;
        for (int j = 0; j < pos - 1; j++) {
            i = i->prox;
        }
        tmp->prox = i->prox;
        i->prox = tmp;
    }
}

int remover(Lista *lista, int pos) {
    int tamanho = size(lista);
    if (pos < 0 || pos >= tamanho) {
        printf("Erro: Posição inválida!\n");
        exit(EXIT_FAILURE);
    }
    if (pos == 0) {
        return removeInitial(lista);
    } else if (pos == tamanho - 1) {
        return removeEnd(lista);
    } else {
        Celula *i = lista->primeiro;
        for (int j = 0; j < pos - 1; j++) {
            i = i->prox;
        }
        Celula *tmp = i->prox;
        int elemento = tmp->elemento;
        i->prox = tmp->prox;
        free(tmp);
        return elemento;
    }
}

void print(Lista *lista) {
    Celula *i = lista->primeiro;
    printf("[");
    while (i != NULL) {
        printf(" %d ", i->elemento);
        i = i->prox;
    }
    printf("]\n");
}

int main(void) {
    Lista lista;
    start(&lista);
    addInitial(&lista, 10);
    addEnd(&lista, 20);
    addEnd(&lista, 30);
    printf("LISTA ENCADEADA:\n");
    print(&lista);
    inserir(&lista, 40, 2);
    printf("ADD:\n");
    print(&lista);
   int elemento = remover(&lista, 2);
    printf("REMOVE:\n");
    print(&lista);
    elemento = removeInitial(&lista);
    printf("REMOVE INICIO:\n");
    print(&lista);
    elemento = removeEnd(&lista);
    printf("REMOVE FIM:\n");
    print(&lista);
    return 0;
}
