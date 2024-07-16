#include <stdio.h>
#include <math.h>

typedef struct Poligono{
    int lado;
    float area;
    int perimetro;
    int qtdLado;
} Poligono;

void calcularAreaPerim(Poligono *poligono) {
    // Calcular o perímetro
    poligono->perimetro = poligono->lado * poligono->qtdLado;
    
    // Calcular a área usando a fórmula para polígonos regulares
    int n = poligono->qtdLado;
    int l = poligono->lado;
    poligono->area = (n * l * l) / (4 * tan(M_PI / n));
}

int main() {
    Poligono poligono;
    int lado, qtdlado;
    scanf("%d", &lado);
    scanf("%d", &qtdlado);
    poligono.lado = lado;
    poligono.qtdLado = qtdlado;
    
    calcularAreaPerim(&poligono);
    
    printf("Perímetro: %d\n", poligono.perimetro);
    printf("Área: %f\n", poligono.area);
    
    return 0;
}
