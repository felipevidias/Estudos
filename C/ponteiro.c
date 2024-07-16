#include <stdio.h>
#include <stdlib.h>

void mudar(int *ptr1, int *ptr2){
    *ptr1 += 5;
    *ptr2 += 10; 
}


int main(void){
    int x = 5;
    int *ptr = &x;
    int y = 10;
    int *ptr2 = &y;
    printf("ANTES:\n");
    printf(" x = %d &x = %p y = %d &y = %p\n", x, ptr, y, ptr2);
    mudar(&x, &y);
    printf(" x = %d &x = %p y = %d &y = %p\n", x, ptr, y, ptr2);
    return 0;
}