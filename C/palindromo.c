#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>

bool palindromo(char *s)
{
    int length = strlen(s);

    for(int i = 0; i < length / 2; i++) // iteração por pares
    {
        if(s[i] != s[length - 1 - i])
        {
            return false; // não é palindromo
        } // end if 
    } // end for 
    return true; // é palindromo
} // end palindromo 

int main(void)
{
    // definir dados 
    bool result;
    char s[80];

    printf("Digite uma string: ");
    scanf("%s", s);
    
    // aplicar funções auxiliares
    result = palindromo(s);
    if(result == true)
    {
        printf("SIM\n");
    }
    else
    {
        printf("NAO\n");
    } // end if


    return 0;
} // end main 