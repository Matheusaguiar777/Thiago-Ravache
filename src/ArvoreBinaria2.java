public class ArvoreBinaria2 {

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

    public static void preOrdem(Node raiz) {
        if (raiz == null) {
            return;
        }
        System.out.print(raiz.valor + " ");
        preOrdem(raiz.esquerda);
        preOrdem(raiz.direita);
    }

    public static void main(String[] args) {
        Node raiz = new Node("A");
        raiz.esquerda = new Node("B");
        raiz.direita = new Node("C");
        raiz.esquerda.esquerda = new Node("D");
        raiz.esquerda.direita = new Node("E");
        raiz.direita.direita = new Node("F");

        System.out.print("Percurso em pre-ordem: ");
        preOrdem(raiz);
    }
}
