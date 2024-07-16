#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool isPrimo(int n){
    if(n < 2) return false;
    for(int i = 2; i * i <= n; i++){
        if(n % i == 0) return false;
    }
    return true;
}

int proxPrimo(int atual){
    int n = atual + 1;
    while(!isPrimo(n)){
        n++;
    }
    return n;
}

int primoJosephus(int* homens, int tamanho){
    int salto = 2; // Primeiro primo após 1
    int inicio = 0;

    for(int i = 0; i < tamanho - 1; i++){
        int contador = 0;
        int passos = 0;
        
        while(passos < salto){
            inicio = (inicio + 1) % tamanho;
            if(homens[inicio] == 1) { // Encontrar o próximo vivo
                passos++;
            }
        }

        homens[inicio] = 0; // Eliminar o homem na posição atual
        salto = proxPrimo(salto); // Próximo primo para o próximo salto
    }

    for(int i = 0; i < tamanho; i++){
        if(homens[i] == 1){
            return i; // Retornar a posição do sobrevivente (1-indexado)
        }
    }
    return -1; // Caso algo dê errado
}

int main(void){
    int n;
    do{
        scanf("%d", &n);
        if(n != 0){
            int* homens = (int*)malloc(n * sizeof(int));
            for(int i = 0; i < n; i++){
                homens[i] = 1; // 1 vivo, 0 morto
            }
            int vivo = primoJosephus(homens, n);
            printf("%d\n", vivo);
            free(homens);
        }
    } while(n != 0);
    return 0;
}
