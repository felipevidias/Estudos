#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
    int l, c;
    scanf("%d", &l);
    scanf("%d", &c);
    int matriz[l][c];
    int transposta[c][l];
        
    for(int i = 0; i < l; i++)
    {
        for(int j = 0; j < c; j++)
        {
            scanf("%d", &matriz[i][j]);
        } // end for 
    } // end for 

    for(int i = 0; i < l; i++)
    {
        for(int j = 0; j < c; j++)
        {
            transposta[j][i] = matriz[i][j];
        } // end for 
    } // end for 

    printf("ORIGINAL:\n");

     for(int i = 0; i < l; i++)
    {
        for(int j = 0; j < c; j++)
        {
            printf("%d\t",matriz[i][j]);
        } // end for 
        printf("\n");
    } // end for

    printf("TRANSPOSTA:\n");


     for(int j = 0; j < c; j++)
    {
        for(int i = 0; i < l; i++)
        {
            printf("%d\t",transposta[j][i]);
        } // end for 
        printf("\n");
    } // end for

    return 0;
}