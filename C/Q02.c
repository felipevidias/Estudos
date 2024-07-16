#include <stdio.h>
#include <math.h>

int main(void)
{
    int n; float IMC; float altura; float peso;
    printf("Numero de pessoas: ");
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        printf("Pessoa[%d]: \n", i+1);
        printf("Informe o peso: ");
        scanf("%f", &peso);
        printf("Informe a altura: ");
        scanf("%f", &altura);
        // IMC = peso/altura²
        altura = pow(altura,2); // pow (base, expoente);
        IMC = peso/altura;

        if(peso < 0)
        {
            i = n;
            printf("ERROR: Numero negativo!\n");
        }

       if(IMC > 16.9)
       {
        printf("Muito abaixo do peso.\n");
       }
       else if(IMC >= 17 && IMC <= 18.4)
       {
        printf("Abaixo do peso.\n");
       }
       else if(IMC >= 18.5 && IMC <= 24.9)
       {
        printf("Peso normal.\n");
       }
       else if(IMC >= 25 && IMC <= 29.9)
       {
        printf("Acima do peso.\n");
       }
       else if(IMC > 30)
       {
        printf("Acima do peso.\n");
       }
    }
    return 0;
}