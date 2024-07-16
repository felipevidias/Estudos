#include <stdio.h>
#include <stdlib.h>

void ateZero(int n){ //  começo                     // for(começo; condição de parada; atualização)
    if(n >= 0){ // condição de parada
        printf("%d ", n);
        ateZero(n - 1); // atualização chamando a si mesmo  
    }
}

int main(void){
    int n = 0;
    scanf("%d", &n);
    printf("VALORES DE N ATE 0:\n");
    ateZero(n);
    printf("\n");
    return 0;
}