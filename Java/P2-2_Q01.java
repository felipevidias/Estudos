class ArvoreArvore{
    No raiz;
}
class No{
    char letra;
    No esq, dir;
    No2 raiz;
}
class No2{
    String palavra;
    No2 esq,dir;
}
int contarPalavras(char primeiro, char ultimo){
    return contarPalavras(raiz, primeiro, ultimo);
}
int contarPalavras(No i, char primeiro, char ultimo){
    if(i == null){
        return 0;
    }
    int qtdPal = 0;
    if(i.letra == primeiro){
        qtdPal = qtdPal + contPalSubArv(i.raiz, primeiro, ultimo);
    }
    if(i.letra < primeiro){
        qtdPal = qtdPal + contarPalavras(i.esq, primeiro, ultimo);
    } else if(i.letra > primeiro){
        qtdPal = qtdPal + contarPalavras(i.dir, primeiro, ultimo);
    } 
    return qtdPal;
}
int contPalSubArv(No2 i, char primeiro, char ultimo){
    if(i == null){
        return 0;
    }
    int qtdPal = 0
    if(i.palavra.charAt(0) == primeiro && i.palavra.charAt(i.palavra.length() - 1) == ultimo){
        qtdPal++;
    }
    qtdPal = qtdPal + contPalSubArv(i.esq, primeiro, ultimo);
    qtdPal = qtdPal + contPalSubArv(i.dir, primeiro, ultimo);
    return qtdPal;
}
