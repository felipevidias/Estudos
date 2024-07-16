#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct Duende{
    char* nome;
    int idade;
}Duende;

int compareTo(const void *a, const void *b){
    Duende* a1 = (Duende*)a;
    Duende* b1 = (Duende*)b;
    int resp = b1->idade - a1->idade;
    if(resp == 0) resp = strcmp(a1->nome,b1->nome);

    return resp;
}


int main(void){
    int n = 0;
    scanf("%d", &n);
    Duende* time = (Duende*)malloc(n * sizeof(Duende));

    for(int i = 0; i < n; i++){
        Duende duende;
        duende.nome = (char*)calloc(50,sizeof(char));
        scanf("%s", duende.nome);
        scanf("%d", &duende.idade);
        time[i] = duende;
    }

    qsort(time, n, sizeof(Duende), compareTo);
    
    Duende* lideres = (Duende*)malloc(n * sizeof(Duende));
    Duende* entregadores = (Duende*)malloc(n * sizeof(Duende));
    Duende* pilotos = (Duende*)malloc(n * sizeof(Duende));

    for(int i = 0; i < n/3; i++){
        lideres[i] = time[i];
    }
    for(int j = 0; j < n/3; j++){
        entregadores[j] = time[j + n/3];
    }
    for(int k = 0; k < n/3; k++){
        pilotos[k] = time[k + 2 * (n/3)];
    }
    int count = 1;
    for(int i = 0; i < n/3; i++){
        printf("Time %d\n", count); count++;
        printf("%s %d\n", lideres[i].nome, lideres[i].idade);
        printf("%s %d\n", entregadores[i].nome, entregadores[i].idade);
        printf("%s %d\n", pilotos[i].nome, pilotos[i].idade);
        printf("\n");
    }

    return 0;
}