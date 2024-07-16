#include <stdio.h>
#include <stdlib.h>

int main(void){
    int rows = 3;
    int col = 3;
    int** mat = (int**)malloc(rows * sizeof(int*));

    for (int i=0;i < rows;++i)
    {
        mat[i] = (int*)malloc(col * sizeof(int));
    }

    int val = 1;
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < col; j++){
            mat[i][j] = val;
            val++;
        }
    }

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < col; j++){
            printf("%d\t", mat[i][j]);
        }
        printf("\n");
    }




    


}