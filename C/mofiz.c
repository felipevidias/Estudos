#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int A, B;
    scanf("%d %d", &A, &B);
    
    int resultado = 0;
    int carry = 0;

    for (int i = 0; i < 32; i++) {
        int bit_A = (A >> i) & 1; // Obtém o i-ésimo bit de A
        int bit_B = (B >> i) & 1; // Obtém o i-ésimo bit de B

        // Calcula a soma dos bits considerando o carry
        int soma_bits = bit_A ^ bit_B ^ carry;
        
        // Atualiza o carry
        carry = (bit_A & bit_B) | ((bit_A ^ bit_B) & carry);
        
        // Define o resultado
        resultado |= (soma_bits << i);
    }

    printf("%d\n", resultado);

    return 0;
}
