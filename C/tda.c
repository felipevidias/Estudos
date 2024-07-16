#include <stdio.h>
#include <stdlib.h>

int gcd(int a, int b) {
    if (b == 0) {
        return a;
    } else {
        return gcd(b, a % b);
    }
}

int main(void){
    int n = 0; 
    int N1, N2, D1, D2;
    char DIV1, DIV2, OP;
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++){
        scanf("%d %c %d %c %d %c %d", &N1, &DIV1, &D1, &OP, &N2, &DIV2, &D2);
        int numerator, denominator;
        char result[100], simpleResult[100];
        
        if(OP == '+'){
            numerator = N1 * D2 + N2 * D1;
            denominator = D1 * D2;
        } else if(OP == '-'){
            numerator = N1 * D2 - N2 * D1;
            denominator = D1 * D2;
        } else if(OP == '*'){
            numerator = N1 * N2;
            denominator = D1 * D2;
        } else if(OP == '/'){
            numerator = N1 * D2;
            denominator = N2 * D1;
        }
        
        // Simplificar a fração
        int gcdValue = gcd(numerator, denominator);
        numerator /= gcdValue;
        denominator /= gcdValue;
        
        // Formatar a expressão original
        sprintf(result, "%d%c%d %c %d%c%d", N1, DIV1, D1, OP, N2, DIV2, D2);
        
        // Formatar a fração simplificada
        sprintf(simpleResult, "%d/%d", numerator, denominator);
        
        // Exibir a expressão original e a fração simplificada
        printf("%s = %s\n", result, simpleResult);
    }
    
    return 0;
}
