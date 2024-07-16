#include <stdio.h>
#include <stdlib.h>

int* somarArrays(int* arr1, int* arr2, int n){
    int* arr3 = (int*)malloc(n * sizeof(int));
    for(int i = 0; i < n; i++){
        arr3[i] = arr1[i] + arr2[i];
    }
    return arr3;
}

int main(void){
    int n = 0;
    scanf("%d", &n);
    int* arr1 = (int*)malloc(n * sizeof(int));
    int* arr2 = (int*)malloc(n * sizeof(int));
    int* arr3 = (int*)malloc(n * sizeof(int));
    printf("PREENCHER ARRANJO 1:\n");
    for(int i = 0; i < n; i++){
        scanf("%d", &arr1[i]);
    }
     printf("PREENCHER ARRANJO 2:\n");
    for(int i = 0; i < n; i++){
        scanf("%d", &arr2[i]);
    }
    printf("SOMA DOS ELEMENTOS DOS DOIS ARRANJOS:\n");
    arr3 = somarArrays(arr1,arr2,n);
    for(int i = 0; i < n; i++){
        printf("%d ", arr3[i]);
    }
    printf("\n");
    return 0;   
}