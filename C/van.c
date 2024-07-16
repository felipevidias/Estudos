#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef struct Aluno{
    char* nome;
    char regiao;
    int custo;
}Aluno;

int compare(const void *a, const void *b){
    const Aluno* alunoA = (const Aluno*)a;
    const Aluno* alunoB = (const Aluno*)b;

    if(alunoA->custo != alunoB->custo){
        return alunoA - alunoB;
    } else{
        return alunoA->regiao - alunoB->regiao;
    }
}

void ordenarEMostrar(int n){
    Aluno* arr = (Aluno*)malloc(n * sizeof(Aluno));
    for(int i = 0; i < n; i++){
        arr[i].nome = (char*)malloc(50 * sizeof(char));
        scanf("%s %c %d", arr[i].nome, &arr[i].regiao, &arr[i].custo);
    }

    qsort(arr, n, sizeof(Aluno), compare);

    for(int i = 0; i < n; i++){
        printf("%s\n", arr[i].nome);
    }
}


int main(void){
    int n; 
    scanf("%d", &n);
    ordenarEMostrar(n);
    return 0;
}