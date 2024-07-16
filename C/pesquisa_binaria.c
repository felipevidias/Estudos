#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>

// busca binaria precisa está com o vetor ordenado!
// chave é o valor que quero buscar 
// [ (inicio + fim) / 2 ] para achar o meio do arranjo 

int buscaBinariaRecursiva(int *vet, int chave, int inicio, int fim)
{
    if(inicio <= fim)
    {
        int meio = ((inicio + fim) / 2);
        if(chave == vet[meio])
        {
            return meio;
        } 
        else
        {
            if(chave < vet[meio])
            {
                return buscaBinariaRecursiva(vet, chave, inicio, meio - 1);
            }
            else
            {
                return buscaBinariaRecursiva(vet, chave, meio + 1, fim);
            } // end if 
        } // end if
    } // end if
    return -1;
} // end buscaBinariaRecursiva( )

int buscaBinaria(int *vet, int chave, int fim)
{
    int inicio = 0;
    int meio = ((inicio + fim) / 2);

    while(inicio <= fim)
    {
        if(chave == vet[meio])
        {
            return meio;
        }
        else
        {
            if(chave < vet[meio])
            {
                fim = meio - 1;
            }
            else
            {
                inicio = meio + 1;
            } // end if 
        } // end if
    } // end while

    return -1;
} // end buscaBinaria

int main (void)
{
    int vet[10] = {13,14,19,43,47,52,65,82,89,91};
    int valor, op;

    do
    {
        printf("Digite um valor a ser buscado (ou 0 para sair): ");
        scanf("%d", &valor);

        if (valor == 0)
        {
            op = 0; // Defina op como 0 para sair do loop
        }
        else
        {
            printf("\nResultado: %d\n", buscaBinariaRecursiva(vet,valor, 0 , 9));
            //printf("\nResultado: %d\n", buscaBinaria(vet, valor, 9));
        } // end if 
    } while(op != 0); // end while 

    return 0;
} // end main()