class ArvoreArvore {
    No raiz;
}

class No {
    char letra;
    No esq, dir;
    No2 raiz;
}

class No2 {
    String palavra;
    No2 esq, dir;
}

// Q02 - receber uma string e mostrar quantas palavras na arvore de arvore tem o
// mesmo numero de letras e começam com a mesma letra
int contarPalavras(String padrao) {
    return contarPalavras(padrao, raiz);
}

int contarPalavras(String padrao, No i){
    if(i == null){
        return 0;
    }
    int qtdPal = 0;
    if(padrao.charAt(0) == i.letra){
        qtdPal = qtdPal + contPalSubArv(i.raiz, padrao.length());  // contar letras na subArv
    }
    if(padrao.charAt(0) < i.letra){
        qtdPal += contarPalavras(padrao, i.esq);
    } else if((padrao.charAt(0) > i.letra)){
        qtdPal += contarPalavras(padrao, i.dir);
    }

    return qtdPal;
}

int contPalSubArv(No2 i, tam){
    if(i == null){
        return 0;
    }

    qtdPal = 0;
    if(i.palavra.length() == tam){
        qtdPal++;
    }
    qtdPal+= contPalSubArv(i.esq, tam);
    qtdPal+= contPalSubArv(i.dir, tam);
}