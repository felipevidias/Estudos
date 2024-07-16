#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct CelulaDupla{
    struct CelulaDupla *ant,*prox;
}CelulaDupla;

CelulaDupla *newCelula(int x){
    CelulaDupla *nova = (CelulaDupla*)(sizeof(CelulaDupla));
    nova->elemento = x;
    nova->ant = NULL;
    nova->prox = NULL;
    return nova;
}

typedef struct Lista{
    CelulaDupla *primeiro,*ultimo;
}Lista;

void start(Lista *lista){
    lista->primeiro = newCelula(-1);
    lista->ultimo = lista->primeiro;
}