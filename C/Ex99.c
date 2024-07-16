#include <stdio.h>
#include <stdlib.h>

int main(void){
    int n = 0;
    scanf("%d", &n);
    int* arr = (int*)malloc(n * sizeof(int));
    for(int i = 0; i < n; i++){
        scanf("%d", &arr[i]);
    }
    printf("ARRANJO:\n");
    for(int i = 0; i < n; i++){
        printf("%d ", arr[i]);
    }
    int x = 5; 
    int *z = &x;
    printf("\nVALORES E PONTEIROS:\n");
    printf("x = %d | z = %p\n", x, z);
    return 0;
}