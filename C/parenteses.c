#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main(void){
    char* s = (char*)calloc(50,sizeof(char));
    while(scanf("%s", s) != EOF){
        bool opened = false;
        bool closed = false;
        int parAbre = 0, parFecha = 0;
        int tamanho = strlen(s);
    
        for(int i = 0; i < tamanho; i++){
           if(s[0] == ')'){
             opened = false; closed = false; i = tamanho;
             }else if(s[tamanho - 1] == '('){
            opened = false; closed = false; i = tamanho
            }

            if(s[i] == '('){
                opened = true;
                parAbre++;
            } else if(s[i] == ')'){
                closed = true;
                parFecha++;
            }
        }

        if(opened && closed && parAbre == parFecha){
            printf("correct\n");
        } else{
            printf("incorrect\n");
        }
    }
    free(s);
    return 0;   
}