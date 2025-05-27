
import java.util.Stack;

class Node {
    String valor;
    Node esquerda;
    Node direita;

    Node(String valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

public class ContarFolhasIterativo {

    public static int contarFolhas(Node raiz) {
        if (raiz == null) return 0;

        Stack<Node> pilha = new Stack<>();
        pilha.push(raiz);
        int folhas = 0;

        while (!pilha.isEmpty()) {
            Node atual = pilha.pop();
            if (atual.esquerda == null && atual.direita == null) {
                folhas++;
            }
            if (atual.direita != null) pilha.push(atual.direita);
            if (atual.esquerda != null) pilha.push(atual.esquerda);
        }

        return folhas;
    }

    public static void main(String[] args) {
        Node raiz = new Node("A");
        raiz.esquerda = new Node("B");
        raiz.direita = new Node("C");
        raiz.esquerda.esquerda = new Node("D");
        raiz.esquerda.direita = new Node("E");
        raiz.direita.direita = new Node("F");

       
        System.out.println("Nós folha (iterativo): " + contarFolhas(raiz));
    }
}
