#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int pessoas;
    int consumo;
}Imovel;

double consumoMedio(Imovel *imoveis,int num_imoveis)
{
  int  totalPessoas = 0;
  int  totalConsumo = 0;

  for(int i = 0; i < num_imoveis; i++)
  {
    totalPessoas += imoveis[i].pessoas;
    totalConsumo += imoveis[i].consumo;
  }

  return (double)totalConsumo/totalPessoas;
}

void ordenarConsumo(Imovel *imoveis, int num_imoveis)
{
    for(int i = 0; i < num_imoveis; i++)
    {
        int min = i;
        for(int j = 1; j < num_imoveis - 1; j++)
        {
            if(imoveis[j].consumo < imoveis[min].consumo)
            {
                min = j;
            }
        }
        Imovel tmp = imoveis[i];
        imoveis[i] = imoveis[min];
        imoveis[min] = tmp;
    }
}

void resultados(int numeroCidade, Imovel *imoveis, int num_imoveis)
{
    ordenarConsumo(imoveis, num_imoveis);
    printf("Cidade# %d:\n", numeroCidade);
    for(int i = 0; i < num_imoveis; i++)
    {
        printf("%d-%d ",imoveis[i].pessoas, imoveis[i].consumo);
    }
    printf("\n");
    double media = consumoMedio(imoveis, num_imoveis);
    printf("Consumo medio: %.2lf m3\n",media);
}

int main(void)
{
    int numeroCidade = 1;
    int n;
    do
    { 
        scanf("%d", &n);
        if(n != 0)
        {
            Imovel *imoveis = (Imovel *)malloc(n * sizeof(Imovel));
            for(int i = 0; i < n; i++)
            {
                scanf("%d %d", &imoveis[i].pessoas, &imoveis[i].consumo);
            }
            resultados(numeroCidade, imoveis, n);
            numeroCidade++;

            free(imoveis);
        }
    } while (n != 0);
    

return 0;
}