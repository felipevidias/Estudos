#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Celula{
    int elemento;
    struct Celula *prox;
}Celula;

Celula *newCelula(int x){
    Celula *nova = (Celula*)malloc(sizeof(Celula#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Celula{
    int elemento;
    struct Celula *prox;
}Celula;

Celula *newCelula(int x){
    Celula *nova = (Celula*)malloc(sizeof(Celula));
    nova->elemento = x;
    nova->prox = NULL;
    return nova;
}

typedef struct Pilha{
    Celula *topo;
}Pilha;

void start(Pilha *pilha){
    pilha->topo = NULL;
}

void push(Pilha *pilha, int x){
    Celula *tmp = newCelula(x);
    tmp->prox = pilha->topo;
    pilha->topo = tmp;
}

int pop(Pilha *pilha){
    if(pilha->topo == NULL){
        printf("Pilha Vazia!");
    }
    int elemento = pilha->topo->elemento;
    Celula *tmp = pilha->topo;
    pilha->topo = pilha->topo->prox;
    tmp->prox = NULL;
    free(tmp);
    tmp = NULL;
    return elemento;
}

void print(Pilha *pilha){
    Celula *i;
    for(i = pilha->topo; i != NULL; i = i->prox){
        printf("[%d]", i->elemento);
    }
    printf("\n");
}

int main(void){
    Pilha pilha;
    start(&pilha);
    push(&pilha, 20);
    push(&pilha, 30);
    push(&pilha, 40);
    printf("PILHA FLEX:\n");
    print(&pilha);
    printf("\n");
    int elemento = pop(&pilha);
    printf("POP:\n");
    print(&pilha);
    printf("\n");
    return 0;
}
