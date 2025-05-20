public class ArvoreBinaria {

    static class Node {
        String valor;
        Node esquerda;
        Node direita;

        Node(String valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    public static int contarNos(Node raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + contarNos(raiz.esquerda) + contarNos(raiz.direita);
    }

    public static void main(String[] args) {
        Node raiz = new Node("A");
        raiz.esquerda = new Node("B");
        raiz.direita = new Node("C");
        raiz.esquerda.esquerda = new Node("D");
        raiz.esquerda.direita = new Node("E");
        raiz.direita.direita = new Node("F");

        int total = contarNos(raiz);
        System.out.println("Total de nos na arvore: " + total);
    }
}
