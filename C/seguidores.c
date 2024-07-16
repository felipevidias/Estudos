#include <stdio.h>
#include <stdlib.h>

int main(void){
    int seguidores; int meta; int seguidoresNoMes; int totalSeguidores = 0;
    scanf("%d", &seguidores);
    scanf("%d", &meta);
    for(int i = 0; i < 30; i++){
        scanf("%d", &seguidoresNoMes);
        totalSeguidores += seguidoresNoMes;
    }
    int media = 0;
    if(totalSeguidores % 30 == 0){
        media = totalSeguidores/30;
    } else{
        media = totalSeguidores/30 + 1; 
    }
    int segRest = meta - seguidores;
    int dias = 0;
    if(segRest % media == 0){
        dias = segRest/media;
    } else{
        dias = (segRest/media)+1;
    }
    printf("%d\n", dias);
    return 0;
}