#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>

bool isIn(int x, int n, int arr[])
{
    for(int i = 0; i < n; i++)
    {
        if(arr[i] == x)
        {
            return true;
        }
    } // end for 

    return false;
} // end isIn( )

int main(void)
{
    int n, x;
    bool result = false;
    printf("Digite o tamanho do arranjo: ");
    scanf("%d", &n); getchar();

    if(n < 0)
    {
        printf("ERROR: Arranjo nulo ou inexistente!");
    }
    else
    {
        int arr[n];

        for(int i = 0; i < n; i++)
        {
            printf("[%d]: ", i);
            scanf("%d", &arr[i]);
        } // end for


        printf("ARRANJO: ");
        for(int j = 0; j < n; j++)
        {
            printf("%d\t", arr[j]);
        } // end for 
        printf("\n");

        printf("Digite um numero a ser pesquisado: ");
        scanf("%d", &x);

        result = isIn(x, n, arr);

        if(result)
        {
            printf("O valor esta dentro do arranjo!\n");
        }
        else
        {
            printf("O valor nao esta dentro do arranjo!\n");
        } // end if
    } // end if 


    return 0;
}