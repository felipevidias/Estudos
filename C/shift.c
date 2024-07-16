#include <stdio.h>

#define MAX 100 // Tamanho máximo do array

void printArray(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void insertInMiddle(int arr[], int *size, int element)
{
    if (*size >= MAX)
    {
        printf("O array está cheio. Não é possível inserir novos elementos.\n");
        return;
    }

    int middle = (*size) / 2; // Encontra o meio da lista

    // Move todos os elementos a partir da posição do meio uma posição à direita
    for (int i = *size; i > middle; i--)
    {
        arr[i] = arr[i - 1];
    }

    // Insere o novo elemento no meio
    arr[middle] = element;

    // Atualiza o tamanho do array
    (*size)++;
}

int main()
{
    int arr[MAX] = {1, 2, 3, 4, 5}; // Exemplo de array
    int size = 5;                   // Tamanho atual do array
    int element = 99;               // Elemento a ser inserido

    printf("Array original:\n");
    printArray(arr, size);

    insertInMiddle(arr, &size, element);

    printf("Array após inserção:\n");
    printArray(arr, size);

    return 0;
}
