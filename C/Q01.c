#include <stdio.h>
int main(void)
{
    int x,y,i,t,n;
    x = 1;
    y = -2;
    printf("\n3 ultimos digitos CP: ");
    scanf("%d", &n);
    for(i = 1; i <= n; i++)
    {
        if(i % 2 == 0 && i % 3 == 0)
        {
            t = y; 
            y = y - 2;
        }
        else{
            t = x;
            x = x + 2;
        }
        printf("\n%d\n", t);
    }
    return 0;
}