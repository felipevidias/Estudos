#include <stdio.h>
#include <stdlib.h>
#include <time.h>   // mexer com n "aleatorios"

typedef struct Array
{
    int length;
    int* dados;
}Array;

Array* randomInt(Array* arr1){
    int val1, val2;
    scanf("%d",&val1);
    scanf("%d",&val2);
    arr1->dados[0] = val1;
    arr1->dados[arr1->length - 1] = val2;
    for(int i = 1; i < arr1->length - 1; i++){
        arr1->dados[i] = rand() % 100;
    }
    return arr1;
}

int main(void){
    Array* arr1;
    arr1 = (Array*)malloc(sizeof(Array));
    arr1->length = 5;
    arr1->dados = (int*)malloc(arr1->length * sizeof(int));
    arr1 = randomInt(arr1);
    for(int i = 0; i < arr1->length; i++){
        printf("%d ", arr1->dados[i]);
    }
    printf("\n");
    free(arr1->dados);
    free(arr1);
    return 0;
}

