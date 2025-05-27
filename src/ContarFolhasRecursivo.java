// ContarFolhasRecursivo.java
// Solução simples e clara usando recursão para contar nós folha em uma árvore binária.

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

public class ContarFolhasRecursivo {

    // Método que conta os nós folha de forma recursiva
    public static int contarFolhas(Node no) {
        if (no == null) return 0;
        if (no.esquerda == null && no.direita == null) return 1;

        // Chamada recursiva para os dois lados
        return contarFolhas(no.esquerda) + contarFolhas(no.direita);
    }

    public static void main(String[] args) {
        // Construindo a árvore conforme a imagem
        Node raiz = new Node("A");
        raiz.esquerda = new Node("B");
        raiz.direita = new Node("C");
        raiz.esquerda.esquerda = new Node("D");
        raiz.esquerda.direita = new Node("E");
        raiz.direita.direita = new Node("F");

        // Exibindo o resultado
        System.out.println("Nós folha (recursivo): " + contarFolhas(raiz));
    }
}
