#include <stdio.h>

int main(void)
{
    int n = 0;
    printf("\nColoque o valor de n: ");
    scanf("%d", &n);
    float s = 0;
    for(int i = 1; i <= n; i++)
    {
        s = s + (i/n - i + 1.0);
    }
    printf("Resultado: %f\n", s);
}
