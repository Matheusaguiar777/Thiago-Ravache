public class No {
    int valor;
    No esquerda;
    No direita;
    No pai;
    boolean corVermelha;

    public No(int valor) {
        this.valor = valor;
        this.corVermelha = true;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}