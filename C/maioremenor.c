#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>

void menorMaior(int *arr, int n)
{
    int maior = arr[0];
    int menor = arr[0];

    for(int i = 0; i < n; i++)
    {
        if(arr[i] > maior)
        {
            maior = arr[i];
        } // end if 
    } // end for 

    for(int j = 0; j < n; j++)
    {
        if(arr[j] < menor)
        {
            menor = arr[j];
        } // end if 
    } // end for 

    printf("\nO maior e: %d\nO menor e: %d\n", maior, menor);
} // end menorMaior()

int main(void)
{
int n; 
printf("Digite o tamanho do arranjo: ");
scanf("%d", &n);

int *arr = malloc(n * sizeof(int)); // alocar dinamicamente um arranjo

for(int i = 0; i < n; i++)
{
    printf("[%d]: ", i);
    scanf("%d", &arr[i]);
} // end for 

menorMaior(arr, n);
return 0;
} // end main