public class NoAvl {
    int chave;
    int altura;
    NoAvl esquerda;
    NoAvl direita;

    public NoAvl(int chave) {
        this.chave = chave;
        this.altura = 1;
        this.esquerda = null;
        this.direita = null;
    }
}