#include <iostream>
#include <stdexcept>

using namespace std;

class Celula
{
public:
    int elemento;
    Celula *prox;

    Celula() : elemento(0), prox(nullptr) {}
    Celula(int x) : elemento(x), prox(nullptr) {}
};

class Fila
{
public:
    Celula *primeiro;
    Celula *ultimo;

    Fila()
    {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    ~Fila()
    {
        while (primeiro != nullptr)
        {
            Celula *tmp = primeiro;
            primeiro = primeiro->prox;
            delete tmp;
        }
    }

    void inserir(int x)
    {
        ultimo->prox = new Celula(x);
        ultimo = ultimo->prox;
    }

    int remover()
    {
        if (primeiro == ultimo)
        {
            throw runtime_error("Erro: Fila vazia!");
        }
        Celula *tmp = primeiro->prox;
        primeiro->prox = primeiro->prox->prox;
        if (tmp == ultimo)
        {
            ultimo = primeiro;
        }
        int elemento = tmp->elemento;
        delete tmp;
        return elemento;
    }

    void mostrar()
    {
        for (Celula *i = primeiro->prox; i != nullptr; i = i->prox)
        {
            cout << i->elemento << " ";
        }
        cout << endl;
    }

    int maior()
    {
        if (primeiro == ultimo)
        {
            throw runtime_error("Erro: Fila vazia!");
        }

        int maior = primeiro->prox->elemento;
        for (Celula *i = primeiro->prox->prox; i != nullptr; i = i->prox)
        {
            if (i->elemento > maior)
            {
                maior = i->elemento;
            }
        }
        return maior;
    }

    int terceiroElemento()
    {
        if (primeiro == ultimo || primeiro->prox == ultimo || primeiro->prox->prox == ultimo)
        {
            throw runtime_error("Erro: Fila não possui terceiro elemento!");
        }

        return primeiro->prox->prox->prox->elemento;
    }

    int soma()
    {
        int result = 0;
        for (Celula *i = primeiro->prox; i != nullptr; i = i->prox)
        {
            result += i->elemento;
        }
        return result;
    }

    void inverter()
    {
        if (primeiro == ultimo)
        {
            return;
        }

        Celula *fim = ultimo;
        Celula *atual = primeiro->prox;
        Celula *anterior = nullptr;

        while (atual != nullptr)
        {
            Celula *proxima = atual->prox;
            atual->prox = anterior;
            anterior = atual;
            atual = proxima;
        }

        primeiro->prox = anterior;
        ultimo = fim;
    }

    int evenAndMult5(Celula *atual)
    {
        if (atual == nullptr)
        {
            return 0;
        }
        int count = (atual->elemento % 2 == 0 && atual->elemento % 5 == 0) ? 1 : 0;
        return count + evenAndMult5(atual->prox);
    }
};

int main()
{
    Fila fila;
    bool continuar = true;

    while (continuar)
    {
        cout << "Escolha uma opção:" << endl;
        cout << "1. Inserir elemento na fila" << endl;
        cout << "2. Remover elemento da fila" << endl;
        cout << "3. Mostrar fila" << endl;
        cout << "4. Mostrar o maior elemento na fila" << endl;
        cout << "5. Mostrar o terceiro elemento na fila" << endl;
        cout << "6. Calcular a soma dos elementos na fila" << endl;
        cout << "7. Inverter a fila" << endl;
        cout << "8. Contar elementos divisíveis por 2 e 5" << endl;
        cout << "9. Sair" << endl;
        cout << "Opção: ";
        int opcao;
        cin >> opcao;

        switch (opcao)
        {
        case 1:
        {
            cout << "Digite o número que deseja inserir na fila: ";
            int numeroInserir;
            cin >> numeroInserir;
            fila.inserir(numeroInserir);
            break;
        }
        case 2:
        {
            try
            {
                int removido = fila.remover();
                cout << "Elemento removido: " << removido << endl;
            }
            catch (runtime_error &e)
            {
                cout << "Erro ao remover elemento: " << e.what() << endl;
            }
            break;
        }
        case 3:
            cout << "Fila:" << endl;
            fila.mostrar();
            break;
        case 4:
        {
            try
            {
                int maior = fila.maior();
                cout << "Maior elemento na fila: " << maior << endl;
            }
            catch (runtime_error &e)
            {
                cout << "Erro ao encontrar o maior elemento: " << e.what() << endl;
            }
            break;
        }
        case 5:
        {
            try
            {
                int terceiro = fila.terceiroElemento();
                cout << "Terceiro elemento na fila: " << terceiro << endl;
            }
            catch (runtime_error &e)
            {
                cout << "Erro ao encontrar o terceiro elemento: " << e.what() << endl;
            }
            break;
        }
        case 6:
        {
            int soma = fila.soma();
            cout << "Soma dos elementos na fila: " << soma << endl;
            break;
        }
        case 7:
            fila.inverter();
            cout << "Fila invertida:" << endl;
            fila.mostrar();
            break;
        case 8:
        {
            int divisiveis = fila.evenAndMult5(fila.primeiro->prox);
            cout << "Número de elementos divisíveis por 2 e 5 na fila: " << divisiveis << endl;
            break;
        }
        case 9:
            continuar = false;
            cout << "Saindo do programa." << endl;
            break;
        default:
            cout << "Opção inválida. Tente novamente." << endl;
        }
    }

    return 0;
}
