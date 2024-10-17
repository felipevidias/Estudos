#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define MAX 100

// Estrutura da pilha
typedef struct
{
    int topo;
    int itens[MAX];
} Pilha;

// Funções da pilha
void inicializaPilha(Pilha *p)
{
    p->topo = -1;
}

int pilhaVazia(Pilha *p)
{
    return p->topo == -1;
}

int pilhaCheia(Pilha *p)
{
    return p->topo == MAX - 1;
}

void empilhar(Pilha *p, int valor)
{
    if (!pilhaCheia(p))
    {
        p->itens[++(p->topo)] = valor;
    }
    else
    {
        printf("Pilha cheia!\n");
    }
}

int desempilhar(Pilha *p)
{
    if (!pilhaVazia(p))
    {
        return p->itens[(p->topo)--];
    }
    else
    {
        printf("Pilha vazia!\n");
        return -1;
    }
}

// Função para determinar precedência dos operadores
int precedencia(char operador)
{
    if (operador == '+' || operador == '-')
    {
        return 1;
    }
    if (operador == '*' || operador == '/')
    {
        return 2;
    }
    return 0;
}

// Função que realiza a operação
int executarOperacao(int operando1, int operando2, char operador)
{
    switch (operador)
    {
    case '+':
        return operando1 + operando2;
    case '-':
        return operando1 - operando2;
    case '*':
        return operando1 * operando2;
    case '/':
        return operando1 / operando2;
    default:
        return 0;
    }
}

// Função para avaliar a expressão usando pilha
int avaliarExpressao(char *expressao)
{
    Pilha operadores, operandos;
    inicializaPilha(&operadores);
    inicializaPilha(&operandos);

    for (int i = 0; expressao[i] != '\0'; i++)
    {
        if (isdigit(expressao[i]))
        {
            empilhar(&operandos, expressao[i] - '0'); // Converte char para int
        }
        else if (expressao[i] == '(')
        {
            empilhar(&operadores, expressao[i]);
        }
        else if (expressao[i] == ')')
        {
            while (!pilhaVazia(&operadores) && operadores.itens[operadores.topo] != '(')
            {
                int operando2 = desempilhar(&operandos);
                int operando1 = desempilhar(&operandos);
                char operador = desempilhar(&operadores);
                empilhar(&operandos, executarOperacao(operando1, operando2, operador));
            }
            desempilhar(&operadores); // Remove o '(' da pilha
        }
        else if (expressao[i] == '+' || expressao[i] == '-' ||
                 expressao[i] == '*' || expressao[i] == '/')
        {
            while (!pilhaVazia(&operadores) && precedencia(operadores.itens[operadores.topo]) >= precedencia(expressao[i]))
            {
                int operando2 = desempilhar(&operandos);
                int operando1 = desempilhar(&operandos);
                char operador = desempilhar(&operadores);
                empilhar(&operandos, executarOperacao(operando1, operando2, operador));
            }
            empilhar(&operadores, expressao[i]);
        }
    }

    while (!pilhaVazia(&operadores))
    {
        int operando2 = desempilhar(&operandos);
        int operando1 = desempilhar(&operandos);
        char operador = desempilhar(&operadores);
        empilhar(&operandos, executarOperacao(operando1, operando2, operador));
    }

    return desempilhar(&operandos);
}

int main()
{
    char expressao[MAX];
    printf("Digite a expressão: ");
    scanf("%s", expressao);

    int resultado = avaliarExpressao(expressao);
    printf("Resultado: %d\n", resultado);

    return 0;
}
