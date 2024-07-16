#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int *arr = (int*)malloc(3 * sizeof(int));
    int n;
    for(int i = 0; i < 3; i++)
    {
        scanf("%d", &arr[i]);getchar();
    }
    for(int i = 0;i < 3; i++)
    {
        int min = i;
        for(int j = i + 1; j < 3; j++)
        {
            if(arr[j] < arr[min])
            {
                min = j;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[min];
        arr[min] = tmp; 
    }

    for(int i = 0; i < 3; i++)
    {
        printf("%d\n", arr[i]);
    }
    free(arr);
    return 0;
}