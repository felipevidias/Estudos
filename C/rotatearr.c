#include <stdio.h>

void rotateArrayLeft(int* arr, int n, int d) {
    int temp[d];
    
    // Copia os primeiros d elementos para o array temporário
    for (int i = 0; i < d; i++) {
        temp[i] = arr[i];
    }
    
    // Move os elementos restantes do array original para a esquerda
    for (int i = d; i < n; i++) {
        arr[i - d] = arr[i];
    }
    
    // Copia os elementos do array temporário de volta para o array original
    for (int i = 0; i < d; i++) {
        arr[n - d + i] = temp[i];
    }
}

/*
    FUNÇÃO PRINCIPAL
*/

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int n = 5; // tamanho do arranjo 
    int d = 0;

    printf("Rotações: ");
    scanf("%d", &d);

    printf("Array antes da rotação:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    // Chamada da função 
    rotateArrayLeft(arr, n, d);

    printf("Array após a rotação:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
