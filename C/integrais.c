#include <stdio.h>
#include <math.h>
#define PI 3.14159265359

// Função para calcular a integral
double integral(double (*f)(double), double a, double b, int n)
{
    double deltaX = (b - a) / n;
    double soma = 0.0;

    for (int i = 0; i < n; i++)
    {
        double xi = a + i * deltaX;
        soma += f(xi) * deltaX;
    }

    return soma;
}

// Função da questão 01
double f_questao01(double x)
{
    return 2 * sqrt(16 - x * x);
}

// Função para processar a questão 01
void questao01()
{
    double a, b;
    int n;

    printf("Questão 01: Integral de 2 * sqrt(16 - x^2)\n");
    printf("Digite o limite inferior (a): ");
    scanf("%lf", &a);
    printf("Digite o limite superior (b): ");
    scanf("%lf", &b);

    printf("Digite o número de subdivisões (n): ");
    scanf("%d", &n);

    double resultado = integral(f_questao01, a, b, n);

    printf("A integral de f(x) entre %.2lf e %.2lf é: %.10lf\n", a, b, resultado);
}

// Função da questão 2
double f_questao02(double x)
{
    return 12 / sqrt(9 - x * x);
}

void questao02()
{
    double a, b;
    int n;

    printf("Questão 01: Integral de 12 / sqrt(9-x²)\n");
    printf("Digite o limite inferior (a): ");
    scanf("%lf", &a);
    printf("Digite o limite superior (b): ");
    scanf("%lf", &b);

    printf("Digite o número de subdivisões (n): ");
    scanf("%d", &n);

    double resultado = integral(f_questao02, a, b, n);

    printf("A integral de f(x) entre %.2lf e %.2lf é: %.10lf\n", a, b, resultado);
}

// Função da questão 3
double f_questao03(double x)
{
    return 20 * PI;
}

void questao03()
{
    double a, b;
    int n;

    printf("Questão 03: 2 * PI * 2 * x * sqrt(4 - pow(x - 4, 2));\n");
    printf("Digite o limite inferior (a): ");
    scanf("%lf", &a);
    printf("Digite o limite superior (b): ");
    scanf("%lf", &b);

    printf("Digite o número de subdivisões (n): ");
    scanf("%d", &n);

    double resultado = integral(f_questao03, a, b, n);

    printf("A integral de f(x) entre %.2lf e %.2lf é: %.10lf\n", a, b, resultado);
}

// Função principal com menu
int main()
{
    int opcao;

    do
    {
        printf("\n--- Menu de Integrais ---\n");
        printf("1. Questão 01\n");
        printf("2. Questão 02\n");
        printf("3. Questão 03\n");
        printf("4. Questão 04\n");
        printf("0. Sair\n");
        printf("Escolha uma opção: ");
        scanf("%d", &opcao);

        switch (opcao)
        {
        case 1:
            questao01();
            break;
        case 2:
            questao02();
            break;
        case 3:
            questao03();
            break;
        case 0:
            printf("Saindo...\n");
            break;
        default:
            printf("Opção inválida!\n");
        }

    } while (opcao != 0);

    return 0;
}
