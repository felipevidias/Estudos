#include <stdio.h>
#include <stdlib.h>


typedef struct
{
    int data[3];
    float valor;
}Boleto;


int main(){
    int dia, mes, ano, indice = 0,contador = 0, i = 0;
    float valor;
    Boleto* boleto;
    FILE* dados = fopen("DADOS.TXT", "r"); 
    while(fscanf(dados, "%d", &dia) != EOF && fscanf(dados, "%d", &mes) != EOF && fscanf(dados, "%d", &ano) != EOF && fscanf(dados, "%f", &valor) != EOF){
        //pegar quantidade de boletos
        contador++;

    }
    boleto = (Boleto*)malloc(contador * sizeof(Boleto));
    fclose(dados);

    dados = fopen("DADOS.TXT", "r");
    while(fscanf(dados, "%d", &dia) != EOF && fscanf(dados, "%d", &mes) != EOF && fscanf(dados, "%d", &ano) != EOF && fscanf(dados, "%f", &valor) != EOF){
        i  = 0;
        boleto[indice].data[i++]  = dia;
        boleto[indice].data[i++]  = mes;
        boleto[indice].data[i]  = ano;
        boleto[indice++].valor = valor;
    }
    printf("Entre com o dia: ");
    scanf("%d", &dia);
    printf("Entre com o mes: ");
    scanf("%d", &mes);
    printf("Entre com o ano: ");
    scanf("%d", &ano);
    fclose(dados);

    dados = fopen("BOLETOS.TXT", "w");

    for(int i = 0; i < contador; i++){
        if(boleto[i].data[0] == dia && boleto[i].data[1] == mes && boleto[i].data[2] == ano){
            fprintf(dados, "%f\n", boleto[i].valor);
        }
    }

}