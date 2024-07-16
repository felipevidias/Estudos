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

class Pilha
{
public:
    Celula *topo;

    Pilha() : topo(nullptr) {}

    void inserir(int x)
    {
        Celula *tmp = new Celula(x);
        topo->prox = tmp;
        topo = tmp;
    }

    int remover()
    {
        if (topo == nullptr)
            throw runtime_error("Erro!");

        int elemento = topo->elemento;
        Celula *tmp = topo;
        topo = topo->prox;
        delete tmp;
        return elemento;
    }

    void mostrar()
    {
        if (topo != nullptr)
        {
            cout << "|" << topo->elemento << "| <-- TOPO" << endl;
            for (Celula *i = topo->prox; i != nullptr; i = i->prox)
            {
                cout << "|" << i->elemento << "|" << endl;
            }
        }
        else
        {
            cout << "Pilha vazia." << endl;
        }
    }

    int soma()
    {
        int result = 0;
        for (Celula *i = topo; i != nullptr; i = i->prox)
        {
            result += i->elemento;
        }
        return result;
    }

    int somaR(Celula *topo)
    {
        if (topo == nullptr)
        {
            return 0;
        }
        else
        {
            return topo->elemento + somaR(topo->prox);
        }
    }

    int maior()
    {
        if (topo == nullptr)
            throw runtime_error("Erro: Pilha vazia!");

        int maior = topo->elemento;
        for (Celula *i = topo->prox; i != nullptr; i = i->prox)
        {
            if (i->elemento > maior)
            {
                maior = i->elemento;
            }
        }
        return maior;
    }

    int maiorR(Celula *topo)
    {
        if (topo == nullptr)
        {
            return 0;
        }
        else if (topo->prox == nullptr)
        {
            return topo->elemento;
        }
        else
        {
            int maior = maiorR(topo->prox);
            return (topo->elemento > maior) ? topo->elemento : maior;
        }
    }

    void mostrarInseridos(Celula *topo)
    {
        if (topo != nullptr)
        {
            mostrarInseridos(topo->prox);
            cout << topo->elemento << endl;
        }
    }

    void mostrarRemovidos(Celula *topo)
    {
        if (topo != nullptr)
        {
            cout << topo->elemento << endl;
            mostrarInseridos(topo->prox);
        }
    }
};

int main()
{
    Pilha pilha;
    bool continuar = true;

    while (continuar)
    {
        cout << "1. Inserir elemento na pilha" << endl;
        cout << "2. Remover elemento da pilha" << endl;
        cout << "3. Mostrar pilha" << endl;
        cout << "4. Somar pilha" << endl;
        cout << "5. Encontrar o maior elemento" << endl;
        cout << "6. Sair" << endl;
        cout << "Escolha uma opção: ";
        int opcao;
        cin >> opcao;

        switch (opcao)
        {
        case 1:
        {
            cout << "Digite o número que deseja inserir: ";
            int numeroInserir;
            cin >> numeroInserir;
            pilha.inserir(numeroInserir);
            break;
        }
        case 2:
        {
            try
            {
                int removido = pilha.remover();
                cout << "Elemento removido: " << removido << endl;
            }
            catch (runtime_error &e)
            {
                cout << "Erro ao remover elemento: " << e.what() << endl;
            }
            break;
        }
        case 3:
            cout << "Pilha:" << endl;
            pilha.mostrar();
            cout << endl;
            break;
        case 4:
        {
            int soma = pilha.somaR(pilha.topo);
            cout << "Soma dos elementos da pilha: " << soma << endl;
            break;
        }
        case 5:
        {
            try
            {
                int maior = pilha.maiorR(pilha.topo);
                cout << "Maior elemento da pilha: " << maior << endl;
            }
            catch (runtime_error &e)
            {
                cout << "Erro ao encontrar maior elemento: " << e.what() << endl;
            }
            break;
        }
        case 6:
            continuar = false;
            cout << "Saindo do programa." << endl;
            break;
        default:
            cout << "Opção inválida. Tente novamente." << endl;
        }
    }

    return 0;
}
