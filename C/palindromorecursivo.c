#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>

bool palindromo(char *s, int start, int end)
{
    if(start >= end)
    {
        return true;
    } // end if 

    if(s[start] != s[end])
    {
        return false;
    } // end if 

    return palindromo(s, start + 1, end -1);
} //end palindromo 

int main(void)
{
    // definir dados
    char s[80];

    printf("Digite uma string: ");
    scanf("%s", s);

    // funcoes auxiliares
    if(palindromo(s, 0, strlen(s) - 1))
    {
        printf("1\n");
    }
    else
    {
        printf("0\n");
    } // end if 
} // end main( )