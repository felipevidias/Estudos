#include <stdio.h>

// Ponteiro estático para manter a string original entre chamadas
static char *strtok_static = NULL;

char *str_tok(char *s, char delimiter)
{
    // Se s não é nulo, inicializamos strtok_static com s
    if (s != NULL)
    {
        strtok_static = s;
    }
    // Se strtok_static for nulo, não há mais tokens a retornar
    if (strtok_static == NULL)
    {
        return NULL;
    }

    char *start = strtok_static; // Ponteiro para o início do token atual

    // Avançar o ponteiro strtok_static até encontrar o delimitador ou o final da string
    while (*strtok_static != '\0' && *strtok_static != delimiter)
    {
        strtok_static++;
    }

    // Se o delimitador foi encontrado, substituí-lo por '\0' e avançar o ponteiro strtok_static
    if (*strtok_static == delimiter)
    {
        *strtok_static = '\0';
        strtok_static++; // Avançar para o próximo caractere após o delimitador
    }
    else
    {
        // Se chegamos ao final da string, configurar strtok_static como NULL
        strtok_static = NULL;
    }

    return start; // Retornar o ponteiro para o início do token atual
}

int main()
{
    char str[] = "C,é,uma,linguagem,de,programação,poderosa,e,flexível";
    char delimiter = ',';
    char *token;

    // Primeira chamada de str_tok com a string original
    token = str_tok(str, delimiter);
    while (token != NULL)
    {
        printf("%s\n", token); // Imprimir o token atual
        // Chamadas subsequentes de str_tok com NULL
        token = str_tok(NULL, delimiter);
    }

    return 0;
}
