#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int casos = 1; int n; int q;
    do{
        scanf("%d %d", &n, &q);
        if(n != 0 && q != 0){
            int* marmores = (int*)malloc(n * sizeof(int));
            for(int i  = 0; i < n; i++)
            {
                scanf("%d", &marmores[i]);
            }

            for(int i = 0; i < n; i++)
            {
                int min = i;
                for(int j = i + 1; j < n; j++)
                {
                    if( marmores[j] < marmores[min])
                    {
                        min = j;
                    }
                }
                int tmp = marmores[i];
                marmores[i] = marmores[min];
                marmores[min] = tmp;
            }

            // buscas 
            int* consultas = (int*)malloc(n * sizeof(int));
            for(int i = 0; i < q; i++)
            {
                scanf("%d", &consultas[i]);
            }

            int found = 0;
            printf("CASE# %d:\n", casos);
            for(int i = 0; i < q; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if(consultas[i] == marmores[j])
                    {
                        printf("%d found at %d\n", consultas[i], j + 1);
                        found = 1;
                        i = q; 
                        j= n;
                    }
                }
                if(found != 1)
                {
                     printf("%d not found\n", consultas[i]);
                }
            }
            

           casos++;
           free(marmores);
           free(consultas);
        }
    } while(n != 0 && q != 0);
} 